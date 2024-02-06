package com.example.cryptocurrencytrackingapp.domain.repository

import com.example.cryptocurrencytrackingapp.data.dto.CryptoCurrencyDto
import com.example.cryptocurrencytrackingapp.utils.Response

interface CryptoCurrenciesRepository {
    suspend fun getCryptoCurrencies(): Response<List<CryptoCurrencyDto>>

    suspend fun getCryptoCurrency(coinId: String): Response<CryptoCurrencyDto>
}

