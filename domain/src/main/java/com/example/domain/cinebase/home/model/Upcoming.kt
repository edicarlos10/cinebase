package com.example.domain.cinebase.home.model

import java.io.Serializable

data class Upcoming(
    val dates: Dates? = null,
    val page: Int? = null,
    val results: List<Result?>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
): Serializable