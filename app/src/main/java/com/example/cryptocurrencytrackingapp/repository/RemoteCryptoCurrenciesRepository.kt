package com.example.cryptocurrencytrackingapp.repository

import com.example.cryptocurrencytrackingapp.data.network.CoinBaseApi
import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrency
import javax.inject.Inject

class RemoteCryptoCurrenciesRepository @Inject constructor(private val coinBaseApiService: CoinBaseApi) :
    CryptoCurrenciesRepository {
    override suspend fun getCryptoCurrencies(): List<CryptoCurrency> {
        return coinBaseApiService.getCryptoCurrencies()
    }
}