package com.example.network.remote

import com.example.domain.cinebase.nowplaying.model.NowPlaying
import kotlinx.coroutines.flow.Flow

interface ICineRemoteData {
    suspend fun getNowPlaying (page: Int?, language: String?): Flow<NowPlaying>
}