package com.example.network.remote

import com.example.domain.cinebase.home.model.NowPlaying
import com.example.domain.cinebase.home.model.Search
import com.example.network.remote.api.ICineApiClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CineRemoteData @Inject constructor(private val apiICineApiClient: ICineApiClient) : ICineRemoteData {
    override suspend fun getNowPlaying(page: Int?, language: String?): Flow<NowPlaying> = flow {
        emit(apiICineApiClient.getNowPlaying(page = page,language = language).toNowPlaying())
    }

    override suspend fun getMovieSearch(
        query: String,
        page: Int?,
        language: String?
    ): Flow<Search> = flow {
        emit(apiICineApiClient.getMovieSearch(query = query,page = page, language = language).toSearch())
    }
}