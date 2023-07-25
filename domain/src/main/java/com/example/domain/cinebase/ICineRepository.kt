package com.example.domain.cinebase

import com.example.domain.cinebase.home.model.NowPlaying
import kotlinx.coroutines.flow.Flow

interface ICineRepository {
    suspend fun getNowPlaying(page: Int?, language: String?): Flow<NowPlaying>
}