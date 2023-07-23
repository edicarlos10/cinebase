package com.example.network.remote.response

import com.example.domain.cinebase.nowplaying.model.Result

data class ResultResponse(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val genre_ids: List<Int?>? = null,
    val id: Int? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val release_date: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
){
    fun toResult(): Result = Result(
        adult ?: false,
        backdrop_path ?: "",
        genre_ids ?: emptyList(),
        id ?: 0,
        original_language ?: "",
        original_title ?: "",
        overview ?: "",
        popularity ?: 0.0,
        poster_path ?: "",
        release_date ?: "",
        title ?: "",
        video ?: false,
        vote_average ?: 0.0,
        vote_count ?: 0
    )
}