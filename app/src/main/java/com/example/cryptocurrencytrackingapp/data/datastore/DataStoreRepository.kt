package com.example.cryptocurrencytrackingapp.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore(name = "app_settings")

@Singleton
class DataStoreRepository @Inject constructor(@ApplicationContext context: Context) {

    private object PreferencesKeys {
        val UPDATE_TIME = longPreferencesKey("update_time")
    }

    private val dataStore = context.dataStore

    suspend fun saveUpdateTime(time: Long) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.UPDATE_TIME] = time
        }
    }

    val updateTime
        get() = runBlocking {
            dataStore.data.map { preferences ->
                preferences[PreferencesKeys.UPDATE_TIME] ?: 0L
            }.first()
        }
}