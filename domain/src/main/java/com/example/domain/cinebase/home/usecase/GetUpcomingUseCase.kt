package com.example.domain.cinebase.home.usecase

import com.example.domain.cinebase.ICineRepository
import com.example.domain.cinebase.home.model.Upcoming
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUpcomingUseCase @Inject constructor(private val cineRepository: ICineRepository) {
    suspend fun execute(page: Int?, language: String?): Flow<Upcoming> {
        return getUpcoming(page = page, language = language)
    }

    private suspend fun getUpcoming(page: Int?, language: String?): Flow<Upcoming> {
        return cineRepository.getUpcoming(page = page, language = language)
    }
}