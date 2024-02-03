package com.example.cryptocurrencytrackingapp.data.network

import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrency
import retrofit2.http.GET

interface CoinBaseApi {
    @GET("api/v2/spot/market/tickers")
    suspend fun getCryptoCurrencies(): List<CryptoCurrency>
}