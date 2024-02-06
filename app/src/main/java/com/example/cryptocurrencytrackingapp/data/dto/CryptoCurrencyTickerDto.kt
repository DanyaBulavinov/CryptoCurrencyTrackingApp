package com.example.cryptocurrencytrackingapp.data.dto

import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.ZERO_INT
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CryptoCurrencyTickerDto(
    @SerializedName("market_cap")
    val marketCap: Int?,
    @SerializedName("percent_change_12h")
    val percentChange12h: Double?,
    @SerializedName("percent_change_15m")
    val percentChange15m: Double?,
    @SerializedName("percent_change_1h")
    val percentChange1h: Double?,
    @SerializedName("percent_change_1y")
    val percentChange1y: Double?,
    @SerializedName("percent_change_24h")
    val percentChange24h: Double?,
    @SerializedName("percent_change_30d")
    val percentChange30d: Double?,
    @SerializedName("percent_change_30m")
    val percentChange30m: Double?,
    @SerializedName("percent_change_6h")
    val percentChange6h: Double?,
    @SerializedName("percent_change_7d")
    val percentChange7d: Double?,
    val price: Double?,
)

