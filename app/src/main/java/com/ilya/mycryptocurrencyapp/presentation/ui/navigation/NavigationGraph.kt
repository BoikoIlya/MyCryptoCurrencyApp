package com.ilya.mycryptocurrencyapp.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ilya.mycryptocurrencyapp.presentation.ui.coindetails.CoinDetails
import com.ilya.mycryptocurrencyapp.presentation.ui.coinlist.CoinList

@Composable
fun navigationGraph(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = Screen.CoinList.rout
    ){
        composable(Screen.CoinList.rout){
            CoinList(navHostController =  navHostController)
        }
        composable(Screen.CoinDetails.rout+"/{coinId}") {
            CoinDetails()
        }
    }
}