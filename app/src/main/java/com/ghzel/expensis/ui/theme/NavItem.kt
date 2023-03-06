package com.ghzel.expensis.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ghzel.expensis.R
import com.ghzel.expensis.ui.routes.NAV_HOME_EXPENSES
import com.ghzel.expensis.ui.routes.NAV_HOME_PARAMS
import com.ghzel.expensis.ui.routes.NAV_HOME_PROFILE
import com.ghzel.expensis.ui.routes.NAV_HOME_SCREEN


sealed class NavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val navRoute: String
) {
    object Home : NavItem(R.string.home, R.drawable.home, NAV_HOME_SCREEN)
    object expenses : NavItem(R.string.expenses, R.drawable.budget, NAV_HOME_EXPENSES)
    object Profile : NavItem(R.string.profile, R.drawable.ic_person, NAV_HOME_PROFILE)
    object Parametre : NavItem(R.string.params, R.drawable.params, NAV_HOME_PARAMS)
}