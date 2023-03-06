package com.ghzel.expensis.ui.Composables.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.ghzel.expensis.ui.theme.*

@Composable
fun Card_Item_Home() {
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(170.dp)
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Column(modifier = Modifier.fillMaxSize()  .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    gradientRed,
                    gradientRed,
                    gradientPink
                )
            )
        )) {

        }
    }
}