package com.example.cryptocurrencytrackingapp.domain.model

import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.EMPTY_STRING
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.ZERO_DOUBLE
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.ZERO_INT


data class CryptoCurrency(
    val betaValue: Double = ZERO_DOUBLE,
    val circulatingSupply: Int = ZERO_INT,
    val firstDataAt: String = EMPTY_STRING,
    val id: String,
    val lastUpdated: String = EMPTY_STRING,
    val maxSupply: Int = ZERO_INT,
    val name: String = EMPTY_STRING,
    val details: CryptoCurrencyDetails,
    val rank: Int = ZERO_INT,
    val symbol: String = EMPTY_STRING,
    val totalSupply: Int = ZERO_INT
)