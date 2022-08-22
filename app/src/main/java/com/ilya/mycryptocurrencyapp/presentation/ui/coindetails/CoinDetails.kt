package com.ilya.mycryptocurrencyapp.presentation.ui.coindetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.ilya.mycryptocurrencyapp.domain.model.Coin
import com.ilya.mycryptocurrencyapp.domain.model.CoinDetails
import com.ilya.mycryptocurrencyapp.presentation.ui.theme.ColorPrimary
import com.ilya.mycryptocurrencyapp.presentation.ui.theme.DarkGray
import com.ilya.mycryptocurrencyapp.presentation.ui.theme.TextWhite
import com.ilya.mycryptocurrencyapp.presentation.viewModels.CoinDetailsViewModel

@Composable
fun CoinDetails(
   coinDetailsViewModel: CoinDetailsViewModel = hiltViewModel()
){
    val state = coinDetailsViewModel.state.value
    state.data?.let { coinDetails ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${coinDetails.rank}. ${coinDetails.name} (${coinDetails.symbol})",
                            style = MaterialTheme.typography.h2,
                            textAlign = TextAlign.Center,
                            color = TextWhite,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Text(
                            text = if (coinDetails.is_active == true) "active" else "inactive",
                            color = if (coinDetails.is_active== true) Color.Green else Color.Red,
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Center,
                            fontStyle = FontStyle.Italic,
                            maxLines = 1,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = coinDetails.description?:"",
                        style = MaterialTheme.typography.body2,
                        color = TextWhite
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
            item {
                Text(
                    text = "Tags",
                    style = MaterialTheme.typography.h3,
                    color = TextWhite
                )
                Spacer(modifier = Modifier.height(20.dp))
                FlowRow(
                    mainAxisSpacing = 10.dp,
                    crossAxisSpacing = 10.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    coinDetails.tags?.forEach { tag ->
                        TagItem(tag = tag)
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Team members",
                    style = MaterialTheme.typography.h3,
                    color = TextWhite
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
            items(coinDetails.team?: emptyList()) { member ->
                TeamMember(member = member)
                Divider(color = Color.DarkGray)
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
}