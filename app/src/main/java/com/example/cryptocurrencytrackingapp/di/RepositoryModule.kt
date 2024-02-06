package com.example.cryptocurrencytrackingapp.di

import com.example.cryptocurrencytrackingapp.data.network.repository.CryptoCurrenciesRepositoryImpl
import com.example.cryptocurrencytrackingapp.domain.repository.CryptoCurrenciesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(
    SingletonComponent::class
)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCryptoCurrenciesRepository(
        cryptoCurrenciesRepositoryImpl: CryptoCurrenciesRepositoryImpl
    ): CryptoCurrenciesRepository
}