package com.example.cryptocurrencytrackingapp.data

import com.example.cryptocurrencytrackingapp.repository.CryptoCurrenciesRepository
import javax.inject.Inject

interface AppContainer {
    val cryptoCurrenciesRepository: CryptoCurrenciesRepository
}

class DefaultAppContainer @Inject constructor
    (cryptoCurrenciesRepository: CryptoCurrenciesRepository) : AppContainer {
    override val cryptoCurrenciesRepository: CryptoCurrenciesRepository by lazy {
        cryptoCurrenciesRepository
    }
}