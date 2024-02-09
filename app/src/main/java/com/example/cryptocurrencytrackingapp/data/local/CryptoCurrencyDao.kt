package com.example.cryptocurrencytrackingapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CryptoCurrencyDao {

    @Query("SELECT * FROM crypto_currencies")
    suspend fun getAllCryptoCurrencies(): List<CryptoCurrencyEntity>

    @Query("SELECT * FROM crypto_currencies WHERE id = :id")
    suspend fun getCryptoCurrency(id: Int): CryptoCurrencyEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCryptoCurrency(cryptoCurrencyEntities: List<CryptoCurrencyEntity>)

}