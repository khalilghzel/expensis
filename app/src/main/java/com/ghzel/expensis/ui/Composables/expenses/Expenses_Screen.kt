package com.ghzel.expensis.ui.Composables.expenses

import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Expenses_Screen(navController: NavController){

    Text(
        text = "EXPENSEEES",
        color = MaterialTheme.colorScheme.onPrimary,
        style = MaterialTheme.typography.displayMedium
    )
}