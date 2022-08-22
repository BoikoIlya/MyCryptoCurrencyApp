package com.ilya.mycryptocurrencyapp.domain.model

import com.ilya.mycryptocurrencyapp.data.network.dto.CoinDto.*

data class CoinDetails(
    val description: String?=null,
    val id: String?=null,
    val is_active: Boolean?=null,
    val name: String?=null,
    val rank: Int?=null,
    val symbol: String?=null,
    val tags: List<String>? = emptyList(),
    val team: List<Team>? = emptyList()
)
