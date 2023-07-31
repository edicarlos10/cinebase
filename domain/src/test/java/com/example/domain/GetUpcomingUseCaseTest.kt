package com.example.domain

import com.example.domain.cinebase.ICineRepository
import com.example.domain.cinebase.home.model.Dates
import com.example.domain.cinebase.home.model.Upcoming
import com.example.domain.cinebase.home.usecase.GetUpcomingUseCase
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class GetUpcomingUseCaseTest : BaseTest() {

    @Mock
    private lateinit var cineRepository: ICineRepository

    private lateinit var getUpcomingUseCase: GetUpcomingUseCase

    override fun initialize() {
        super.initialize()

        getUpcomingUseCase = GetUpcomingUseCase(cineRepository)
    }

    private val expected = Upcoming(
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
    fun `Should return upcoming flow`() = runTest {
        val flow = flowOf(expected)
        Mockito.`when`(cineRepository.getUpcoming(page, language)).thenReturn(flow)

        val result = getUpcomingUseCase.execute(page, language).toList()

        assertEquals(expected.page, result[0].page)
        Mockito.verify(cineRepository).getUpcoming(page, language)
    }
}