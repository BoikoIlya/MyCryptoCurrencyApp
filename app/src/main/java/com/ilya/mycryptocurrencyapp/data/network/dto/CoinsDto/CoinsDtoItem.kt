package com.ilya.mycryptocurrencyapp.data.network.dto.CoinsDto

import com.ilya.mycryptocurrencyapp.domain.model.Coin

data class CoinsDtoItem(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinsDtoItem.toCoin(): Coin{
    return Coin(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}