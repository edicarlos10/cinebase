package com.example.network.remote.response

import com.example.domain.cinebase.home.model.Search

data class SearchResponse(
    val page: Int?,
    val results: List<ResultResponse?>?,
    val total_pages: Int?,
    val total_results: Int?
) {
    fun toSearch(): Search = Search(
        page ?: 1,
        results?.map { it?.toResult() } ?: emptyList(),
        total_pages ?: 0,
        total_results ?: 0
    )
}