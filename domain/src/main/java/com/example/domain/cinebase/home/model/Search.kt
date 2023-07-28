package com.example.domain.cinebase.home.model

import java.io.Serializable

data class Search(
    val page: Int?,
    val results: List<Result?>?,
    val total_pages: Int?,
    val total_results: Int?
) : Serializable