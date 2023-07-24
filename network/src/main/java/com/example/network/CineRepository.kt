package com.example.network.remote

import com.example.domain.cinebase.ICineRepository
import com.example.domain.cinebase.nowplaying.model.NowPlaying
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CineRepository @Inject constructor(private val cineRemoteData: ICineRemoteData) : ICineRepository {
    override suspend fun getNowPlaying(page: Int?, language: String?): Flow<List<NowPlaying>> {
        return cineRemoteData.getNowPlaying(page = page,language = language).flowOn(Dispatchers.IO)
    }
}