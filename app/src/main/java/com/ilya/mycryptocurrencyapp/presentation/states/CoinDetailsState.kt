package com.ilya.mycryptocurrencyapp.presentation.states

import com.ilya.mycryptocurrencyapp.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val data: CoinDetails? = null,
    val error: String = ""
)
