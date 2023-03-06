package com.ghzel.expensis.ui.Composables.profil

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Profile_Screen(navController: NavController){

    Text(
        text = "Ghzel Marwa",
        color = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary,
        style = androidx.compose.material3.MaterialTheme.typography.displayMedium
    )
}