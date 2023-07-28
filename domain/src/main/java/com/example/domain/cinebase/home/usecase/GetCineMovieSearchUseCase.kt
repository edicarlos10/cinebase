package com.example.domain.cinebase.home.usecase

import com.example.domain.cinebase.ICineRepository
import com.example.domain.cinebase.home.model.Search
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCineMovieSearchUseCase @Inject constructor(private val cineRepository: ICineRepository) {
    suspend fun execute(query: String, page: Int?, language: String?): Flow<Search> {
        return getMovieSearch(query = query, page = page, language = language)
    }

    private suspend fun getMovieSearch(query: String, page: Int?, language: String?): Flow<Search> {
        return cineRepository.getMovieSearch(query = query, page = page, language = language)
    }
}