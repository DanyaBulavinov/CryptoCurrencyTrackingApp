package com.example.cryptocurrencytrackingapp.di

import com.example.cryptocurrencytrackingapp.data.AppContainer
import com.example.cryptocurrencytrackingapp.data.DefaultAppContainer
import com.example.cryptocurrencytrackingapp.data.network.CoinBaseApi
import com.example.cryptocurrencytrackingapp.repository.CryptoCurrenciesRepository
import com.example.cryptocurrencytrackingapp.repository.RemoteCryptoCurrenciesRepository
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideCoinBaseApi(): CoinBaseApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinBaseApi::class.java)

    @Provides
    @Singleton
    fun provideCryptoCurrencyRepository(coinBaseApi: CoinBaseApi): CryptoCurrenciesRepository =
        RemoteCryptoCurrenciesRepository(coinBaseApi)
}