package com.example.cryptocurrencytrackingapp.domain.model

import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.EMPTY_STRING
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.ZERO_DOUBLE
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.ZERO_INT
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.ZERO_LONG


data class CryptoCurrency(
    val betaValue: Double = ZERO_DOUBLE,
    val circulatingSupply: Long = ZERO_LONG,
    val firstDataAt: String = EMPTY_STRING,
    val id: String,
    val lastUpdated: String = EMPTY_STRING,
    val maxSupply: Long = ZERO_LONG,
    val name: String = EMPTY_STRING,
    val details: CryptoCurrencyDetails,
    val rank: Int = ZERO_INT,
    val symbol: String = EMPTY_STRING,
    val totalSupply: Long = ZERO_LONG
)