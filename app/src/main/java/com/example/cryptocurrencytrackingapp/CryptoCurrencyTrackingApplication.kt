package com.example.cryptocurrencytrackingapp

import android.app.Application
import com.example.cryptocurrencytrackingapp.data.AppContainer
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class CryptoCurrencyTrackingApplication : Application() {
    @Inject
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
    }
}
