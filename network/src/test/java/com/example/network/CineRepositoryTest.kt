package com.example.network

import com.example.domain.cinebase.home.model.Dates
import com.example.domain.cinebase.home.model.NowPlaying
import com.example.network.remote.ICineRemoteData
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class CineRepositoryTest :BaseTest() {

    @Mock
    private lateinit var remoteData: ICineRemoteData

    private lateinit var cineRepository: CineRepository

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
    override fun initialize() {
        super.initialize()

        cineRepository = CineRepository(remoteData)
    }

    @Test
    fun `Should return flow of cine get now playing`() = runTest {
        val flow = flow { emit(expected) }
        Mockito.`when`(remoteData.getNowPlaying(page, language)).thenReturn(flow)

        val result = cineRepository.getNowPlaying(page, language).toList()

        Assert.assertEquals(1, result.size)
        Assert.assertEquals(expected.page, result[0].page)
        Mockito.verify(remoteData).getNowPlaying(page, language)
    }
}