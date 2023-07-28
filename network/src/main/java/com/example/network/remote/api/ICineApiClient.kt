package com.example.network.remote.api

import com.example.network.remote.response.NowPlayingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ICineApiClient {

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey: String = "b19f46767a72e4812181f01a5d9085b8",
        @Query("page") page: Int? = 1,
        @Query("language") language: String? = "pt-br",
        ): NowPlayingResponse
}