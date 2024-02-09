package com.example.cryptocurrencytrackingapp.data.network.repository

import android.util.Log
import com.example.cryptocurrencytrackingapp.data.local.CryptoCurrenciesDatabase
import com.example.cryptocurrencytrackingapp.data.mappers.toCryptoCurrency
import com.example.cryptocurrencytrackingapp.data.mappers.toCryptoCurrencyEntity
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

class CryptoCurrenciesRepositoryImpl @Inject constructor(
    private val coinPaprikaApiService: CoinPaprikaApi,
    private val cryptoCurrenciesDatabase: CryptoCurrenciesDatabase
) :
    CryptoCurrenciesRepository {
    override suspend fun getCryptoCurrencies(): Flow<Response<List<CryptoCurrency>>> {
        return flow {
            emit(Response.Loading(true))
            Log.d(TAG, "Loading in RepositoryImpl")

            val dao = cryptoCurrenciesDatabase.cryptoCurrencyDao()

            val databaseResult = dao.getAllCryptoCurrencies()
            if (databaseResult.isNotEmpty()) {
                emit(Response.Success(databaseResult.map { it.toCryptoCurrency() }))
                return@flow
            }

            try {
                val result = coinPaprikaApiService.getCryptoCurrencies()
                val mappedResult = result.map { it.toCryptoCurrency() }
                dao.insertCryptoCurrency(mappedResult.map { it.toCryptoCurrencyEntity() })
                emit(Response.Success(mappedResult))
                emit(Response.Loading(false))
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
