package com.ilya.mycryptocurrencyapp.domain.repositiory

import com.ilya.mycryptocurrencyapp.data.network.dto.CoinDto.CoinDto
import com.ilya.mycryptocurrencyapp.data.network.dto.CoinsDto.CoinsDto
import com.ilya.mycryptocurrencyapp.data.network.dto.CoinsDto.CoinsDtoItem

interface Repository {

    suspend fun getCoins(): List<CoinsDtoItem>

    suspend fun getCoinById(coinId: String): CoinDto
}