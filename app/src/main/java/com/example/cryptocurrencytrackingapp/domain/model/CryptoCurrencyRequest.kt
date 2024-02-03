package com.example.cryptocurrencytrackingapp.domain.model

data class CryptoCurrencyRequest(
    val code: String,
    val data: List<CryptoCurrency>,
    val msg: String
)