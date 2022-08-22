package com.ilya.mycryptocurrencyapp.presentation.ui.coindetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.ilya.mycryptocurrencyapp.data.network.dto.CoinDto.Team
import com.ilya.mycryptocurrencyapp.presentation.ui.theme.DarkGray
import com.ilya.mycryptocurrencyapp.presentation.ui.theme.TextWhite

@Composable
fun TeamMember(
   member: Team
){
  Column(
      modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 10.dp, horizontal = 16.dp)
          .background(DarkGray)
  ) {
      Text(
          text = member.name,
          style = MaterialTheme.typography.h4,
          color = TextWhite
      )
      Spacer(modifier = Modifier.height(5.dp))
      Text(
          text = member.position,
          style = MaterialTheme.typography.body2,
          fontStyle = FontStyle.Italic,
          color = TextWhite
      )
  }
}