package com.example.network

import com.example.domain.cinebase.ICineRepository
import com.example.domain.cinebase.home.model.NowPlaying
import com.example.domain.cinebase.home.model.Search
import com.example.domain.cinebase.home.model.Upcoming
import com.example.network.remote.ICineRemoteData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CineRepository @Inject constructor(private val cineRemoteData: ICineRemoteData) : ICineRepository {
    override suspend fun getNowPlaying(page: Int?, language: String?): Flow<NowPlaying> {
        return cineRemoteData.getNowPlaying(page = page,language = language).flowOn(Dispatchers.IO)
    }

    override suspend fun getUpcoming(page: Int?, language: String?): Flow<Upcoming> {
        return cineRemoteData.getUpcoming(page = page,language = language).flowOn(Dispatchers.IO)
    }

    override suspend fun getMovieSearch(
        query: String,
        page: Int?,
        language: String?
    ): Flow<Search> {
        return  cineRemoteData.getMovieSearch(query = query, page = page, language = language).flowOn(Dispatchers.IO)
    }
}