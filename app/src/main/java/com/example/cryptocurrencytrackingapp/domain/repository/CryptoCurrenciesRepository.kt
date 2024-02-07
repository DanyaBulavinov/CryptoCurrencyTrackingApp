package com.example.cryptocurrencytrackingapp.domain.repository

import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrency
import com.example.cryptocurrencytrackingapp.utils.Response
import kotlinx.coroutines.flow.Flow

interface CryptoCurrenciesRepository {
    suspend fun getCryptoCurrencies(): Flow<Response<List<CryptoCurrency>>>

    suspend fun getCryptoCurrency(coinId: String): Response<CryptoCurrency>
}

