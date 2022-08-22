package com.ilya.mycryptocurrencyapp.presentation.ui.coindetails

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.ilya.mycryptocurrencyapp.presentation.ui.theme.ColorPrimary
import com.ilya.mycryptocurrencyapp.presentation.ui.theme.Shapes

@Composable
fun TagItem(
    tag: String
){
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(10.dp)
    ) {
         Text(
             text = tag,
             color = MaterialTheme.colors.primary,
             style = MaterialTheme.typography.body2
         )
    }
}