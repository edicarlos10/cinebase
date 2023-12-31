package com.example.domain.cinebase.home.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dates(
    val maximum: String? = null,
    val minimum: String? = null
) : Parcelable