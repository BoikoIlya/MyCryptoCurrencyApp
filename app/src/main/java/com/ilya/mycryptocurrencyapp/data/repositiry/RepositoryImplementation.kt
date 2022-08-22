package com.ilya.mycryptocurrencyapp.data.repositiry

import com.ilya.mycryptocurrencyapp.data.network.PaprikaAPI
import com.ilya.mycryptocurrencyapp.data.network.dto.CoinDto.CoinDto
import com.ilya.mycryptocurrencyapp.data.network.dto.CoinsDto.CoinsDto
import com.ilya.mycryptocurrencyapp.data.network.dto.CoinsDto.CoinsDtoItem
import com.ilya.mycryptocurrencyapp.domain.repositiory.Repository
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    val paprikaAPI: PaprikaAPI
):Repository {

    override suspend fun getCoins(): List<CoinsDtoItem> {
        return paprikaAPI.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDto {
        return paprikaAPI.getCoinById(coinId)
    }
}
