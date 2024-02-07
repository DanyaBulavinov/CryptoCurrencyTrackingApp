package com.example.cryptocurrencytrackingapp.data.network.repository

import android.util.Log
import com.example.cryptocurrencytrackingapp.data.mappers.toCryptoCurrency
import com.example.cryptocurrencytrackingapp.data.network.CoinPaprikaApi
import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrency
import com.example.cryptocurrencytrackingapp.domain.repository.CryptoCurrenciesRepository
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.TAG
import com.example.cryptocurrencytrackingapp.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CryptoCurrenciesRepositoryImpl @Inject constructor(private val coinPaprikaApiService: CoinPaprikaApi) :
    CryptoCurrenciesRepository {
    override suspend fun getCryptoCurrencies(): Flow<Response<List<CryptoCurrency>>> {
        return flow {
            emit(Response.Loading(true))
            Log.d(TAG, "Loading in RepositoryImpl")
            try {
                val result = coinPaprikaApiService.getCryptoCurrencies()
                val mappedResult = result.map { it.toCryptoCurrency() }
                Log.d(TAG, "Success: ${mappedResult[0].details}")
                result.map { it.toCryptoCurrency() }
                emit(Response.Loading(false))
                emit(Response.Success(mappedResult))
                return@flow
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Response.Error(e.message ?: "An error occurred"))
                Log.d(TAG, "IO Error in RepositoryImpl")
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Response.Error(e.message ?: "An error occurred"))
                Log.d(TAG, "HTTP Error in RepositoryImpl")
            }
        }
    }

    override suspend fun getCryptoCurrency(coinId: String): Response<CryptoCurrency> {
        return Response.Success(coinPaprikaApiService.getCryptoCurrency(coinId).toCryptoCurrency())
    }
}