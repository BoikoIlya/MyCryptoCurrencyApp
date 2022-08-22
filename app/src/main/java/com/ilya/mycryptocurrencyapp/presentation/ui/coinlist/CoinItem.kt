package com.ilya.mycryptocurrencyapp.presentation.ui.coinlist

import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ilya.mycryptocurrencyapp.domain.model.Coin
import com.ilya.mycryptocurrencyapp.presentation.ui.navigation.Screen
import com.ilya.mycryptocurrencyapp.presentation.ui.theme.DarkGray

@Composable
fun CoinItem(
     coin:Coin,
     onItemClick:()->Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable {
                    onItemClick()
            },
        horizontalArrangement = Arrangement.SpaceBetween
    ){
    Text(
        text = "${coin.rank}. ${coin.name} (${coin.symbol})",
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.Center,
        color = Color.White,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
        Text(
            text = if(coin.is_active) "active" else "inactive",
            color = if(coin.is_active) Color.Green else Color.Red,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            maxLines = 1,
        )
        }
}