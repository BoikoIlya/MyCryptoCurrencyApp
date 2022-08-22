package com.ilya.mycryptocurrencyapp.presentation.states

import com.ilya.mycryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins:List<Coin> = emptyList(),
    val error: String = ""
)
