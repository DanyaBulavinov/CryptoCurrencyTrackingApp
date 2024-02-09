package com.example.cryptocurrencytrackingapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_currencies")
data class CryptoCurrencyEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val totalSupply: Long,
    val marketCap: Long,
    val price: Double,
    val volume24h: Double,
)