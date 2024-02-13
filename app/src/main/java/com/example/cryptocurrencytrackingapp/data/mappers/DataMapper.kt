package com.example.cryptocurrencytrackingapp.data.mappers

import com.example.cryptocurrencytrackingapp.data.dto.CryptoCurrencyDto
import com.example.cryptocurrencytrackingapp.data.dto.CryptoCurrencyTickerDto
import com.example.cryptocurrencytrackingapp.data.dto.QuoteDto
import com.example.cryptocurrencytrackingapp.data.local.CryptoCurrencyEntity
import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrency
import com.example.cryptocurrencytrackingapp.domain.model.CryptoCurrencyDetails
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.EMPTY_STRING
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.ZERO_DOUBLE
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.ZERO_INT
import com.example.cryptocurrencytrackingapp.utils.Constants.Companion.ZERO_LONG


fun CryptoCurrencyDto.toCryptoCurrency() = CryptoCurrency(
    betaValue = betaValue ?: ZERO_DOUBLE,
    circulatingSupply = circulatingSupply ?: ZERO_LONG,
    firstDataAt = firstDataAt ?: EMPTY_STRING,
    id = id,
    lastUpdated = lastUpdated ?: EMPTY_STRING,
    maxSupply = maxSupply ?: ZERO_LONG,
    name = name ?: EMPTY_STRING,
    details = quotes?.toQuote() ?: CryptoCurrencyDetails(),
    rank = rank ?: ZERO_INT,
    symbol = symbol ?: EMPTY_STRING,
    totalSupply = totalSupply ?: ZERO_LONG
)

fun CryptoCurrencyTickerDto.toCryptoCurrencyDetails() = CryptoCurrencyDetails(
    marketCap = marketCap ?: ZERO_LONG,
    volume24h = volume24h ?: ZERO_DOUBLE,
    percentChange12h = percentChange12h ?: ZERO_DOUBLE,
    percentChange15m = percentChange15m ?: ZERO_DOUBLE,
    percentChange1h = percentChange1h ?: ZERO_DOUBLE,
    percentChange1y = percentChange1y ?: ZERO_DOUBLE,
    percentChange24h = percentChange24h ?: ZERO_DOUBLE,
    percentChange30d = percentChange30d ?: ZERO_DOUBLE,
    percentChange30m = percentChange30m ?: ZERO_DOUBLE,
    percentChange6h = percentChange6h ?: ZERO_DOUBLE,
    percentChange7d = percentChange7d ?: ZERO_DOUBLE,
    price = price ?: ZERO_DOUBLE
)

fun QuoteDto.toQuote() = cryptoCurrencyTicker?.toCryptoCurrencyDetails() ?: CryptoCurrencyDetails()

fun CryptoCurrency.toCryptoCurrencyEntity() = CryptoCurrencyEntity(
    id = id,
    name = name,
    symbol = symbol,
    rank = rank,
    totalSupply = totalSupply,
    marketCap = details.marketCap,
    price = details.price,
    volume24h = details.volume24h,
    percentChange24h = details.percentChange24h
)

fun CryptoCurrencyEntity.toCryptoCurrency() = CryptoCurrency(
    id = id,
    name = name,
    symbol = symbol,
    rank = rank,
    totalSupply = totalSupply,
    details = CryptoCurrencyDetails(
        marketCap = marketCap,
        price = price,
        volume24h = volume24h,
        percentChange24h = percentChange24h
    )
)
