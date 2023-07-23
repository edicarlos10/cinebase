package com.example.network.remote.response

import com.example.domain.cinebase.nowplaying.model.Dates

data class DatesResponse(
    val maximum: String? = null,
    val minimum: String? = null
) {
    fun toDates(): Dates = Dates(
        maximum ?: "",
        minimum ?: ""
    )
}