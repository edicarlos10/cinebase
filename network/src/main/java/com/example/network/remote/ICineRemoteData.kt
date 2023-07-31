package com.example.network.remote

import com.example.domain.cinebase.home.model.NowPlaying
import com.example.domain.cinebase.home.model.Search
import com.example.domain.cinebase.home.model.Upcoming
import kotlinx.coroutines.flow.Flow

interface ICineRemoteData {
    suspend fun getNowPlaying (page: Int?, language: String?): Flow<NowPlaying>
    suspend fun getUpcoming (page: Int?, language: String?): Flow<Upcoming>
    suspend fun getMovieSearch (query: String, page: Int?, language: String?): Flow<Search>
}