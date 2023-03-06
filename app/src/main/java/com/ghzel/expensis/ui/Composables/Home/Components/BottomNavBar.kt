package com.ghzel.expensis.ui.Composables.Home.Components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ghzel.expensis.ui.theme.*


@SuppressLint("SuspiciousIndentation")
@Composable
fun AppBottomNavigation(navController: NavController) {
    val navItems = listOf(NavItem.Home, NavItem.expenses, NavItem.Profile, NavItem.Parametre)



        BottomNavigation(
            backgroundColor =  MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp)),
            elevation = 0.dp,
        ) {
            //currentBackStackEntryAsState
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            navItems.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = stringResource(item.title),
                            modifier = Modifier.size(30.dp),
                        )
                    },
                    selectedContentColor = main_color,
                    unselectedContentColor = Color.Black.copy(0.2f),
                    alwaysShowLabel = true,
                    selected = currentRoute == item.navRoute,
                    onClick = {
                        navController.navigate(item.navRoute) {
                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
