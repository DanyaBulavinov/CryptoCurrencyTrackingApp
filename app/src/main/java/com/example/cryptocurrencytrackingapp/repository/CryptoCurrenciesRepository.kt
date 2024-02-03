package com.example.cryptocurrencytrackingapp.repository

import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrency

interface CryptoCurrenciesRepository {
    suspend fun getCryptoCurrencies(): List<CryptoCurrency>
}

