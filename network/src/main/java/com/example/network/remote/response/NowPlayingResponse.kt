package com.example.network.remote.response

import com.example.domain.cinebase.home.model.NowPlaying

data class NowPlayingResponse(
    val dates: DatesResponse? = null,
    val page: Int? = null,
    val results: List<ResultResponse?>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
) {
    fun toNowPlaying(): NowPlaying = NowPlaying(
        dates?.toDates(),
        page ?: 1,
        results?.map { it?.toResult() } ?: emptyList(),
        total_pages ?: 0,
        total_results ?: 0
    )
}