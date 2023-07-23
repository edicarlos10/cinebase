package com.example.domain.cinebase.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dates(
    val maximum: String?,
    val minimum: String?
) : Parcelable