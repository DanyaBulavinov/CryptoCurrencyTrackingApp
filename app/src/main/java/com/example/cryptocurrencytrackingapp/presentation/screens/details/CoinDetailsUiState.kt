package com.example.cryptocurrencytrackingapp.presentation.screens.details

import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrency

data class CoinDetailsUiState(
    val coinDetails: CryptoCurrency = CryptoCurrency(id = "id")
)