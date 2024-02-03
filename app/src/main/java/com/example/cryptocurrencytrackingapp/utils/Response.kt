package com.example.cryptocurrencytrackingapp.utils

sealed class Response<out T : Any> {
    data class Success<T : Any>(val data: T) : Response<T>()
    data class Loading(val isLoading: Boolean) : Response<Nothing>()
    data class Error(val message: String) : Response<Nothing>()
}