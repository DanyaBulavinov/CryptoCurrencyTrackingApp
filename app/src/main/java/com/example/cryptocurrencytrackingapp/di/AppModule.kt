package com.example.cryptocurrencytrackingapp.di

import android.content.Context
import com.example.cryptocurrencytrackingapp.data.local.CryptoCurrenciesDatabase
import com.example.cryptocurrencytrackingapp.data.network.CoinPaprikaApi
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCoinBaseApi(): CoinPaprikaApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): CryptoCurrenciesDatabase {
        return CryptoCurrenciesDatabase.getInstance(appContext)
    }
}