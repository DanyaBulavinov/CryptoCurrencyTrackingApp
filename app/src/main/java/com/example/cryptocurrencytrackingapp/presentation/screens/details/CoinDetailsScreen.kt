package com.example.cryptocurrencytrackingapp.presentation.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cryptocurrencytrackingapp.R
import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrency
import com.example.cryptocurrencytrackingapp.presentation.navigation.NavigationDestination
import com.example.cryptocurrencytrackingapp.presentation.viewmodels.CoinDetailsViewModel

object CoinDetailsDestination : NavigationDestination {
    override val route: String = "details"
    override val titleRes: Int = R.string.details_screen
}

@Composable
fun CoinDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: CoinDetailsViewModel = viewModel()
) {
    val coinDetailsUiState = viewModel.coinDetailsUiState

    CoinStatistics(coinDetailsUiState.coinDetails)
}

@Composable
fun CoinStatistics(
    coinDetails: CryptoCurrency,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Current Price",
                fontSize = 20.sp
            )
            Text(
                text = "${coinDetails.details.price}",
                fontSize = 20.sp
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 20.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Market Cap",
                fontSize = 20.sp
            )
            Text(
                text = "${coinDetails.details.marketCap}",
                fontSize = 20.sp
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 20.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Volume 24h",
                fontSize = 20.sp
            )
            Text(
                text = "Volume",
                fontSize = 20.sp
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 20.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Current Price",
                fontSize = 20.sp
            )
            Text(
                text = "Price",
                fontSize = 20.sp
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 20.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Current Price",
                fontSize = 20.sp
            )
            Text(
                text = "Price",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
@Preview
fun CoinDetailsScreenPreview() {
    CoinDetailsScreen()
}