package com.example.cryptocurrencytrackingapp.data.dto

import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrency
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.EMPTY_STRING
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.ZERO_DOUBLE
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.ZERO_INT
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CryptoCurrencyDto(
    @SerializedName("beta_value")
    val betaValue: Double?,
    @SerializedName("circulating_supply")
    val circulatingSupply: Int?,
    @SerializedName("first_data_at")
    val firstDataAt: String?,
    val id: String,
    @SerializedName("last_updated")
    val lastUpdated: String?,
    @SerializedName("max_supply")
    val maxSupply: Int?,
    val name: String?,
    val quote: QuoteDto? = null,
    val rank: Int?,
    val symbol: String?,
    @SerializedName("total_supply")
    val totalSupply: Int?
)
