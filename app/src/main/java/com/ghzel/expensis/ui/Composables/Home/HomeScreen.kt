package com.ghzel.expensis.ui.Composables.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ghzel.expensis.ui.Composables.Home.Components.AppBottomNavigation
import com.ghzel.expensis.ui.Composables.Home.Components.Drawer_Content_Screen
import com.ghzel.expensis.ui.Composables.Home.Components.Toolbar
import com.ghzel.expensis.ui.Composables.expenses.Expenses_Screen
import com.ghzel.expensis.ui.Composables.home_screen.HomeViewModel
import com.ghzel.expensis.ui.Composables.home_screen.Home_Screen_inside
import com.ghzel.expensis.ui.Composables.params.Params_Screen
import com.ghzel.expensis.ui.Composables.params.categories.Categories_Screen
import com.ghzel.expensis.ui.Composables.profil.Profile_Screen
import com.ghzel.expensis.ui.routes.*
import com.ghzel.expensis.ui.theme.AppMainTheme
import com.ghzel.expensis.ui.theme.Bg_Home_Color
import com.ghzel.expensis.ui.theme.DarkBlue
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeScreen(
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState()
    val navControllers = rememberNavController()
    val coroutineScope = rememberCoroutineScope()

      AppMainTheme(
        displayProgressBar = false,
        scaffoldState = scaffoldState,
    ) {


        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = { AppBottomNavigation(navControllers) },
            drawerContent = {
                Drawer_Content_Screen({
                    navControllers.navigate(it)
                    coroutineScope.launch { scaffoldState.drawerState.close() }
                })
            },
            floatingActionButton = {},
            drawerShape = RoundedCornerShape(0.dp, 30.dp, 30.dp, 0.dp),
            content = { padding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(padding)
                ) {
                    Toolbar(
                        navController,
                        { coroutineScope.launch { scaffoldState.drawerState.open() } })

                    NavHost(navController = navControllers, startDestination = NAV_HOME_SCREEN) {
                        composable(NAV_HOME_SCREEN) { Home_Screen_inside(navControllers) }
                        composable(NAV_HOME_PROFILE) { Profile_Screen(navControllers) }
                        composable(NAV_HOME_PARAMS) { Params_Screen(navControllers) }
                        composable(NAV_HOME_EXPENSES) { Expenses_Screen(navControllers) }
                        composable(NAV_HOME_CATEGORIES) { Categories_Screen(navControllers) }
                    }
                }
            })
    }
}


class NavShape(
    private val widthOffset: Dp,
    private val scale: Float
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Rectangle(
            Rect(
                Offset.Zero,
                Offset(
                    size.width * scale + with(density) { widthOffset.toPx() },
                    size.height
                )
            )
        )
    }
}