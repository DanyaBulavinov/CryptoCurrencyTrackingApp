package com.example.cryptocurrencytrackingapp.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencytrackingapp.domain.repository.CryptoCurrenciesRepository
import com.example.cryptocurrencytrackingapp.presentation.screens.home.HomeUiState
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.TAG
import com.example.cryptocurrencytrackingapp.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val cryptoCurrenciesRepository: CryptoCurrenciesRepository) :
    ViewModel() {

    var homeUiState by mutableStateOf(HomeUiState())
        private set

    init {
        fetchCryptoCurrencies()
    }

    private fun fetchCryptoCurrencies() {
        viewModelScope.launch {
            cryptoCurrenciesRepository.getCryptoCurrencies().collect {
                when (it) {
                    is Response.Success -> {
                        homeUiState = homeUiState.copy(cryptoCurrenciesList = it.data)
                    }

                    is Response.Loading -> {
                        homeUiState = homeUiState.copy(isLoading = it.isLoading)
                    }

                    is Response.Error -> {
                        Log.d(TAG, "Error: ${it.message}")
                    }
                }
            }
        }
    }

//    fun createMockUpData() {
//        val tempList = mutableListOf<CryptoCurrency>()
//        var cryptoCurrency: CryptoCurrency?
//        var cryptoDetails: CryptoCurrencyDetails?
//        for (i in 1..20) {
//            cryptoDetails = CryptoCurrencyDetails(
//                marketCap = i * 50343 * i,
//                percentChange24h = i * Random.nextDouble(from = -0.5, until = 1.5),
//                price = i * 3534.0
//            )
//            cryptoCurrency = CryptoCurrency(
//                id = i.toString(),
//                name = "Bitcoin",
//                symbol = "BTC",
//                circulatingSupply = 10000000,
//                details = cryptoDetails
//            )
//            tempList.add(cryptoCurrency)
//        }
//        homeUiState = HomeUiState(tempList)
//    }
}

