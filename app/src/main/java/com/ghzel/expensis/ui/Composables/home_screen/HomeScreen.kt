package com.ghzel.expensis.ui.Composables.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ghzel.expensis.ui.theme.AppMainTheme

@Composable
fun Home_Screen_inside(navController: NavController) {

    val scaffoldState = rememberScaffoldState()
    val viewModel: HomeViewModel = hiltViewModel()



    AppMainTheme(
        displayProgressBar = viewModel.isloading.value,
        scaffoldState = scaffoldState,
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(4.dp))
            Row() {
                Card_Item_Home()
            }

        }


    }
}