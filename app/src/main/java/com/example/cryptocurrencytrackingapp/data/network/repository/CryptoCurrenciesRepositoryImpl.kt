package com.example.cryptocurrencytrackingapp.data.network.repository

import com.example.cryptocurrencytrackingapp.data.dto.CryptoCurrencyDto
import com.example.cryptocurrencytrackingapp.data.network.CoinBaseApi
import com.example.cryptocurrencytrackingapp.domain.repository.CryptoCurrenciesRepository
import com.example.cryptocurrencytrackingapp.utils.Response
import javax.inject.Inject

class CryptoCurrenciesRepositoryImpl @Inject constructor(private val coinBaseApiService: CoinBaseApi) :
    CryptoCurrenciesRepository {
    override suspend fun getCryptoCurrencies(): Response<List<CryptoCurrencyDto>> {
        return Response.Success(coinBaseApiService.getCryptoCurrencies())
    }

    override suspend fun getCryptoCurrency(coinId: String): Response<CryptoCurrencyDto> {
        return Response.Success(coinBaseApiService.getCryptoCurrency(coinId))
    }
}