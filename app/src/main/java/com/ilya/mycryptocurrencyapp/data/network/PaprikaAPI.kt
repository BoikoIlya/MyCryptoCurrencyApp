package com.ilya.mycryptocurrencyapp.data.network

import com.ilya.mycryptocurrencyapp.data.network.dto.CoinDto.CoinDto
import com.ilya.mycryptocurrencyapp.data.network.dto.CoinsDto.CoinsDto
import com.ilya.mycryptocurrencyapp.data.network.dto.CoinsDto.CoinsDtoItem
import com.ilya.mycryptocurrencyapp.utils.Constance
import retrofit2.http.GET
import retrofit2.http.Path

interface PaprikaAPI {

    @GET(Constance.DESTINATION_URL_COINS)
    suspend fun getCoins(): List<CoinsDtoItem>

    @GET(Constance.DESTINATION_URL_OF_COIN_BY_ID)
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDto
}