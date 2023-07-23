package com.example.domain.cinebase

import com.example.domain.cinebase.nowplaying.model.NowPlaying
import kotlinx.coroutines.flow.Flow

interface ICineNowPlayingRepository {
    suspend fun getNowPlaying(page: Int?, language: String?): Flow<List<NowPlaying>>
}