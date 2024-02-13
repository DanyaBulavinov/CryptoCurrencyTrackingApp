package com.example.cryptocurrencytrackingapp.data.network.repository

import android.util.Log
import com.example.cryptocurrencytrackingapp.data.datastore.DataStoreRepository
import com.example.cryptocurrencytrackingapp.data.local.CryptoCurrenciesDatabase
import com.example.cryptocurrencytrackingapp.data.mappers.toCryptoCurrency
import com.example.cryptocurrencytrackingapp.data.mappers.toCryptoCurrencyEntity
import com.example.cryptocurrencytrackingapp.data.network.CoinPaprikaApi
import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrency
import com.example.cryptocurrencytrackingapp.domain.repository.CryptoCurrenciesRepository
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.REFRESH_TIME
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.TAG
import com.example.cryptocurrencytrackingapp.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CryptoCurrenciesRepositoryImpl @Inject constructor(
    private val coinPaprikaApiService: CoinPaprikaApi,
    private val cryptoCurrenciesDatabase: CryptoCurrenciesDatabase,
    private val dataStoreRepository: DataStoreRepository
) : CryptoCurrenciesRepository {
    override suspend fun getCryptoCurrencies(): Flow<Response<List<CryptoCurrency>>> {
        return flow {
            emit(Response.Loading(true))
            val dao = cryptoCurrenciesDatabase.cryptoCurrencyDao()
            val databaseResult = dao.getAllCryptoCurrencies()
            val dataBaseIsNotEmpty = databaseResult.isNotEmpty()
            val shouldUpdate = System.nanoTime() - dataStoreRepository.updateTime > REFRESH_TIME

            if (dataBaseIsNotEmpty && !shouldUpdate) {
                emit(Response.Success(databaseResult.map { it.toCryptoCurrency() }))
                return@flow
            }

            try {
                val result = coinPaprikaApiService.getCryptoCurrencies()
                val mappedResult = result.map { it.toCryptoCurrency() }
                dao.insertCryptoCurrency(mappedResult.map { it.toCryptoCurrencyEntity() })
                dataStoreRepository.saveUpdateTime(System.nanoTime())
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
