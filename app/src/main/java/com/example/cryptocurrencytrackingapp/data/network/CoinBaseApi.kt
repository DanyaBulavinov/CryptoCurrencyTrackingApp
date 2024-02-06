package com.example.cryptocurrencytrackingapp.data.network

import com.example.cryptocurrencytrackingapp.data.dto.CryptoCurrencyDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinBaseApi {
    @GET("https://api.coinpaprika.com/v1/")
    suspend fun getCryptoCurrencies(): List<CryptoCurrencyDto>

    @GET("api/v2/spot/market/tickers/{coinId}")
    suspend fun getCryptoCurrency(@Path("coinId") coinId: String): CryptoCurrencyDto
}