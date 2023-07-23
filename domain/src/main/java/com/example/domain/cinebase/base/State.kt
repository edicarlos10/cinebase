package com.example.domain.cinebase.base

sealed class State<out T> {
    data class Data<T>(val data: T) : State<T>()

    data class Error(val type: Enum<*>? = null, val cause: Throwable? = null) : State<Nothing>()

    object Loading : State<Nothing>()

    fun isData() = this is Data

    fun isError() = this is Error

    fun isLoading() = this is Loading

    companion object {

        fun <T> data(data: T): State<T> = Data(data)

        fun <T> error(
            type: Enum<*>,
            cause: Throwable? = null
        ): State<T> = Error(type, cause)

        fun <T> error(
            cause: Throwable
        ): State<T> = Error(null, cause)

        fun <T> loading(): State<T> = Loading
    }
}