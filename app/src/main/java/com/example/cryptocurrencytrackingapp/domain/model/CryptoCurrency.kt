package com.example.cryptocurrencytrackingapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CryptoCurrency(
    val askPr: String,
    val askSz: String,
    val baseVolume: String,
    val bidPr: String,
    val bidSz: String,
    val change24h: String,
    val changeUtc24h: String,
    val high24h: String,
    val lastPr: String,
    val low24h: String,
    val `open`: String,
    val openUtc: String,
    val quoteVolume: String,
    val symbol: String,
    val ts: String,
    val usdtVolume: String
)