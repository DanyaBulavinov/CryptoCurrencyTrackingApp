package com.example.cryptocurrencytrackingapp.data.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class QuoteDto(
    @SerializedName("USD")
    val cryptoCurrencyTicker: CryptoCurrencyTickerDto? = null
)

