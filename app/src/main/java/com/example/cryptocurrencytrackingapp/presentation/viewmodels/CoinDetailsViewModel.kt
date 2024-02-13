package com.example.cryptocurrencytrackingapp.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.cryptocurrencytrackingapp.presentation.screens.details.CoinDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor() : ViewModel() {

    var coinDetailsUiState by mutableStateOf(CoinDetailsUiState())
        private set


}