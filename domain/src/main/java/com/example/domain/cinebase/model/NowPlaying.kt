package com.example.domain.cinebase.model

import java.io.Serializable

data class NowPlaying(
    val dates: Dates?,
    val page: Int?,
    val results: List<Result?>?,
    val total_pages: Int?,
    val total_results: Int?
): Serializable