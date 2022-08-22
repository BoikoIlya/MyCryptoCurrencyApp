package com.ilya.mycryptocurrencyapp.presentation.ui.navigation

sealed class Screen(val rout: String){
    object CoinList: Screen("coin_list")
    object CoinDetails: Screen("coin_details")
}
