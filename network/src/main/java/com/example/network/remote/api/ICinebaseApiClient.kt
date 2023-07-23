package com.example.network.remote.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ICinebaseApiClient {

    @GET("now_playing")
    fun getNowPlaying(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1,
        @Query("language") language: String = "pt-br",
        )
}