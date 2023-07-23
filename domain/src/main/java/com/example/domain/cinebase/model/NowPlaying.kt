package com.example.domain.cinebase.model

import java.io.Serializable

data class NowPlaying(
    val dates: Dates? = null,
    val page: Int? = null,
    val results: List<Result?>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
): Serializable