package com.ilya.mycryptocurrencyapp.presentation.ui.coinlist

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ilya.mycryptocurrencyapp.presentation.states.CoinListState
import com.ilya.mycryptocurrencyapp.presentation.ui.navigation.Screen
import com.ilya.mycryptocurrencyapp.presentation.ui.theme.ColorPrimary
import com.ilya.mycryptocurrencyapp.presentation.ui.theme.DarkGray
import com.ilya.mycryptocurrencyapp.presentation.viewModels.CoinsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun CoinList(
    coinsViewModel: CoinsViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val state = coinsViewModel.state.value
    LazyColumn(modifier = Modifier
        .fillMaxSize()
    ) {
        items(state.coins) { coin ->
            CoinItem(
                coin = coin,
               onItemClick = {
                   navHostController.navigate(Screen.CoinDetails.rout + "/${coin.id}")
               }
            )
        }
    }
    if(state.error.isNotBlank()){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textAlign = TextAlign.Center
            )
        }
    }
    if(state.isLoading){
        Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        CircularProgressIndicator(
            color = ColorPrimary,
        )
        }
    }
}