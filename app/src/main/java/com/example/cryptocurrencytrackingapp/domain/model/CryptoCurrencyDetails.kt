package com.example.cryptocurrencytrackingapp.domain.model

import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.ZERO_DOUBLE
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.ZERO_LONG


data class CryptoCurrencyDetails(
    val marketCap: Long = ZERO_LONG,
    val percentChange15m: Double = ZERO_DOUBLE,
    val percentChange12h: Double = ZERO_DOUBLE,
    val percentChange1h: Double = ZERO_DOUBLE,
    val percentChange1y: Double = ZERO_DOUBLE,
    val percentChange24h: Double = ZERO_DOUBLE,
    val percentChange30d: Double = ZERO_DOUBLE,
    val percentChange30m: Double = ZERO_DOUBLE,
    val percentChange6h: Double = ZERO_DOUBLE,
    val percentChange7d: Double = ZERO_DOUBLE,
    val price: Double = ZERO_DOUBLE,
)
