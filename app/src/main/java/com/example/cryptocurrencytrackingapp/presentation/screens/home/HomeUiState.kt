package com.example.cryptocurrencytrackingapp.presentation.screens.home

import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrency

data class HomeUiState(val cryptoCurrenciesList: List<CryptoCurrency> = listOf())
