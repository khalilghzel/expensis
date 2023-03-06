package com.ghzel.expensis.ui.theme

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ghzel.expensis.ui.Composables.Home.HomeHolderViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppMainTheme(
    displayProgressBar: Boolean,
    scaffoldState: ScaffoldState,
    content: @Composable () -> Unit,
) {
    val viewModel: HomeHolderViewModel = hiltViewModel()
    val nightModeOn = viewModel.nightMode.collectAsState(initial = false)
    val selectedMode = remember { mutableStateOf(lightColor) }

    MaterialTheme(
        colorScheme =  if (nightModeOn.value) darkColor else lightColor,
        typography = UbuntuTypography,
        shapes = AppShapes,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            content()
            CircularIndeterminateProgressBar(
                isDisplayed = displayProgressBar,
                modifier = Modifier.align(Alignment.Center)
            )
            DefaultSnackbar(
                snackbarHostState = scaffoldState.snackbarHostState,
                onDismiss = {
                    scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}
