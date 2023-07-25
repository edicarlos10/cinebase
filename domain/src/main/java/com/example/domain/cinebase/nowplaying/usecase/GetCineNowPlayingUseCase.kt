package com.example.domain.cinebase.nowplaying.usecase

import com.example.domain.cinebase.ICineRepository
import com.example.domain.cinebase.nowplaying.model.NowPlaying
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCineNowPlayingUseCase @Inject constructor(private val cineRepository: ICineRepository) {
    suspend fun execute(page: Int?, language: String?): Flow<NowPlaying> {
        return getNowPlaying(page = page, language = language)
    }

    private suspend fun getNowPlaying(page: Int?, language: String?): Flow<NowPlaying> {
        return cineRepository.getNowPlaying(page = page, language = language)
    }
}