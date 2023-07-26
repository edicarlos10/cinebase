package com.example.domain

import com.example.domain.cinebase.ICineRepository
import com.example.domain.cinebase.home.model.Dates
import com.example.domain.cinebase.home.model.NowPlaying
import com.example.domain.cinebase.home.usecase.GetCineNowPlayingUseCase
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class GetCineNowPlayingUseCaseTest : BaseTest() {

    @Mock
    private lateinit var cineRepository: ICineRepository

    private lateinit var getCineNowPlayingUseCase: GetCineNowPlayingUseCase

    override fun initialize() {
        super.initialize()

        getCineNowPlayingUseCase = GetCineNowPlayingUseCase(cineRepository)
    }

    private val expected = NowPlaying(
        dates = Dates(
            maximum = "2023-07-24",
            minimum = "2023-06-06"
        ),
        page = 1,
        results = emptyList(),
        total_pages = 78,
        total_results = 1545,

        )

    @Test
    fun `Should return cine now playing flow`() = runTest {
        val flow = flowOf(expected)
        Mockito.`when`(cineRepository.getNowPlaying(page, language)).thenReturn(flow)

        val result = getCineNowPlayingUseCase.execute(page, language).toList()

        assertEquals(expected.page, result[0].page)
        Mockito.verify(cineRepository).getNowPlaying(page, language)
    }
}