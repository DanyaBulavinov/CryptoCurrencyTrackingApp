package com.example.cryptocurrencytrackingapp.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.cryptocurrencytrackingapp.data.dto.CryptoCurrencyDto
import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrency
import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrencyDetails
import com.example.cryptocurrencytrackingapp.domain.repository.CryptoCurrenciesRepository
import com.example.cryptocurrencytrackingapp.presentation.screens.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor(private val cryptoCurrenciesRepository: CryptoCurrenciesRepository) :
    ViewModel() {

    var homeUiState by mutableStateOf<HomeUiState>(HomeUiState())
        private set

    init {
        createMockUpData()
    }
    fun createMockUpData(){
        val tempList = mutableListOf<CryptoCurrency>()
        var cryptoCurrency: CryptoCurrency?
        var cryptoDetails: CryptoCurrencyDetails?
        for (i in 1..20){
            cryptoDetails = CryptoCurrencyDetails(
                marketCap = i * 50343 * i,
                percentChange24h = i * Random.nextDouble(from= -0.5, until = 1.5),
                price = i * 3534.0
            )
            cryptoCurrency = CryptoCurrency(
                id = i.toString(),
                name = "Bitcoin",
                symbol = "BTC",
                circulatingSupply = 10000000,
                details = cryptoDetails
            )
            tempList.add(cryptoCurrency)
        }
        homeUiState = HomeUiState(tempList)
    }
}

