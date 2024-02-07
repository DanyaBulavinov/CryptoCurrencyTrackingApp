package com.example.cryptocurrencytrackingapp.data.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class CryptoCurrencyDto(
    @SerializedName("beta_value")
    val betaValue: Double?,
    @SerializedName("circulating_supply")
    @Contextual
    val circulatingSupply: Long?,
    @SerializedName("first_data_at")
    val firstDataAt: String?,
    val id: String,
    @SerializedName("last_updated")
    val lastUpdated: String?,
    @SerializedName("max_supply")
    val maxSupply: Long?,
    val name: String?,
    @SerializedName("quotes")
    val quotes: QuoteDto? = null,
    val rank: Int?,
    val symbol: String?,
    @SerializedName("total_supply")
    val totalSupply: Long?
)
