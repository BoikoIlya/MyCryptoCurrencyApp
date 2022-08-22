package com.ilya.mycryptocurrencyapp.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.ilya.mycryptocurrencyapp.data.network.dto.CoinDto.Team
import com.ilya.mycryptocurrencyapp.domain.model.Coin
import com.ilya.mycryptocurrencyapp.presentation.states.CoinDetailsState
import com.ilya.mycryptocurrencyapp.presentation.ui.coindetails.CoinDetails
import com.ilya.mycryptocurrencyapp.presentation.ui.coindetails.TeamMember
import com.ilya.mycryptocurrencyapp.presentation.ui.coinlist.CoinItem
import com.ilya.mycryptocurrencyapp.presentation.ui.coinlist.CoinList
import com.ilya.mycryptocurrencyapp.presentation.ui.navigation.navigationGraph
import com.ilya.mycryptocurrencyapp.presentation.ui.theme.DarkGray
import com.ilya.mycryptocurrencyapp.presentation.ui.theme.MyCryptoCurrencyAppTheme
import com.ilya.mycryptocurrencyapp.presentation.viewModels.CoinDetailsViewModel
import com.ilya.mycryptocurrencyapp.presentation.viewModels.CoinsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val coinViewModel: CoinsViewModel by viewModels()
    val coinDetailsViewModel: CoinDetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = coinViewModel.state.value
            val detailsState = coinDetailsViewModel.state.value

                coinDetailsViewModel.state.value
            MyCryptoCurrencyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  val navController = rememberNavController()
                    navigationGraph(navController)
//                    CoinDetails(
//                        coinDetails =com.ilya.mycryptocurrencyapp.domain.model.CoinDetails(
//                        description = "bitcoin is cool coin",
//                        id = "1",
//                        is_active = false,
//                        name = "Bitcoin",
//                        rank = 0,
//                        symbol = "BTC",
//                        tags = listOf("btc", "efirium", "payments", "sha256", "Lightning Network"),
//                        team = listOf(Team("", "ilya", "developer"),
//                            Team("", "vadim", "clerk"),
//                            Team("", "andrei", "timlid")
//                        )
//                    ) )
//                    detailsState.data?.let {
//                        CoinDetails(coinDetails = it)
//                    }
                }
            }
        }
    }
}
