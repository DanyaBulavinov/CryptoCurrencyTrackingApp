package com.example.cryptocurrencytrackingapp.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cryptocurrencytrackingapp.R
import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrency
import com.example.cryptocurrencytrackingapp.presentation.navigation.NavigationDestination
import com.example.cryptocurrencytrackingapp.presentation.viewmodels.HomeViewModel

object HomeDestination : NavigationDestination {
    override val route: String = "home"
    override val titleRes: Int = R.string.app_name
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {
    val homeUiState = viewModel.homeUiState
    LazyColumn {
        items(homeUiState.cryptoCurrenciesList) { cryptoCurrency ->
            CryptoCurrencyCard(cryptoCurrency, modifier)
        }
    }
}

@Composable
fun CryptoCurrencyCard(
    cryptoCurrency: CryptoCurrency,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .height(80.dp)
                .padding(start = 5.dp, end = 5.dp)
        ) {
            Text(
                text = cryptoCurrency.id,
                fontSize = 20.sp,
                modifier = modifier.padding(top = 10.dp, bottom = 10.dp)
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .build(),
                contentDescription = "Token Logo",
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .padding(10.dp)
                    .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp))
                    .background(color = androidx.compose.ui.graphics.Color.Cyan)

            )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = modifier.fillMaxHeight()
            ) {
                Text(text = cryptoCurrency.name)
                Row {
                    Text(text = cryptoCurrency.symbol)
                    Image(
                        painter = painterResource(id = R.drawable.arrow_pointing_to_up),
                        contentDescription = "Small Icon",
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .height(15.dp)
                            .padding(start = 2.dp, end = 3.dp)
                    )
                    Text(text = cryptoCurrency.details.percentChange24h.toString())
                }
            }
            Text(text = cryptoCurrency.details.price.toString())
        }
    }
}


@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}


