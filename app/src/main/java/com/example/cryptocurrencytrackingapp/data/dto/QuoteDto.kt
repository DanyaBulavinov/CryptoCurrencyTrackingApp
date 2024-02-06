package com.example.cryptocurrencytrackingapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class QuoteDto(
    val cryptoCurrencyTicker: CryptoCurrencyTickerDto?
)

