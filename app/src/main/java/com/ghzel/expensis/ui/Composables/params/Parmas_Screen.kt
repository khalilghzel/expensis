package com.ghzel.expensis.ui.Composables.params

import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Params_Screen(navController: NavController){

    Text(
        text = "PARAMS",
        color = MaterialTheme.colorScheme.onPrimary,
        style = MaterialTheme.typography.displayMedium
    )
}