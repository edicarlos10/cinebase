package com.example.domain

import com.example.domain.cinebase.ICineRepository
import com.example.domain.cinebase.home.model.Search
import com.example.domain.cinebase.home.usecase.GetCineMovieSearchUseCase
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class GetCineMovieSearchUseCaseTest : BaseTest() {

    @Mock
    private lateinit var cineRepository: ICineRepository

    private lateinit var getCineMovieSearchUseCase: GetCineMovieSearchUseCase

    override fun initialize() {
        super.initialize()

        getCineMovieSearchUseCase = GetCineMovieSearchUseCase(cineRepository)
    }

    private val expected = Search(
        page = 1,
        results = emptyList(),
        total_pages = 78,
        total_results = 1545,

        )

    @Test
    fun `Should return cine search flow`() = runTest {
        val flow = flowOf(expected)
        Mockito.`when`(cineRepository.getMovieSearch("Barbie", page, language)).thenReturn(flow)

        val result = getCineMovieSearchUseCase.execute("Barbie",page, language).toList()

        Assert.assertEquals(expected.page, result[0].page)
        Mockito.verify(cineRepository).getMovieSearch("Barbie",page, language)
    }
}