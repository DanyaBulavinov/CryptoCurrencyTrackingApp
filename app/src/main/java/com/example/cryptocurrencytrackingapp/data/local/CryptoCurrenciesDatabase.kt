package com.example.cryptocurrencytrackingapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CryptoCurrencyEntity::class], version = 2, exportSchema = false)
abstract class CryptoCurrenciesDatabase : RoomDatabase() {

    abstract fun cryptoCurrencyDao(): CryptoCurrencyDao

    companion object {
        const val DATABASE_NAME = "crypto_currencies_db"

        @Volatile
        private var instance: CryptoCurrenciesDatabase? = null

        fun getInstance(context: Context): CryptoCurrenciesDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    CryptoCurrenciesDatabase::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { instance = it }
            }
        }
    }

}