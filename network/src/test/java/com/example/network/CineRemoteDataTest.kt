package com.example.network

import com.example.network.remote.CineRemoteData
import com.example.network.remote.api.ICineApiClient
import com.example.network.remote.response.DatesResponse
import com.example.network.remote.response.NowPlayingResponse
import com.example.network.remote.response.SearchResponse
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CineRemoteDataTest : BaseTest() {

    @Mock
    lateinit var client: ICineApiClient

    private lateinit var remoteData: CineRemoteData

    private val response = NowPlayingResponse(
        dates = DatesResponse(
            maximum = "2023-07-24",
            minimum = "2023-06-06"
        ),
        page = 1,
        results = emptyList(),
        total_pages = 78,
        total_results = 1545,

    )

    private val responseSearch = SearchResponse(
        page = 1,
        results = emptyList(),
        total_pages = 78,
        total_results = 1545,

        )

    override fun initialize() {
        super.initialize()

        remoteData = CineRemoteData(client)
    }

    @Test
    fun `Should get cine now playing`() = runTest {
        Mockito.`when`(client.getNowPlaying()).thenReturn(response)

        val result = remoteData.getNowPlaying(page, language).toList()

        assertEquals(1, result.size)
        assertEquals(response.toNowPlaying().page, result[0].page)
        Mockito.verify(client).getNowPlaying()
    }

    @Test
    fun `Should get cine search`() = runTest {
        Mockito.`when`(client.getMovieSearch("Barbie")).thenReturn(responseSearch)

        val result = remoteData.getMovieSearch("Barbie", page, language).toList()

        assertEquals(1, result.size)
        assertEquals(responseSearch.toSearch().page, result[0].page)
        Mockito.verify(client).getMovieSearch("Barbie")
    }
}