package com.example.liftingtracker.core.models

import androidx.navigation.Navigation
import com.example.liftingtracker.R

sealed class BottomNavigationItem(
    val route: String,
    val icon: Int,
    val title: String,
) {
    object Home : BottomNavigationItem(
        route = "home",
        icon = R.drawable.ic_home,
        title = "Home"
    )

    object Plan : BottomNavigationItem(
        route = "plan",
        icon = R.drawable.ic_assignment,
        title = "Plan"
    )

    object Stats : BottomNavigationItem(
        route = "stats",
        icon = R.drawable.ic_stats,
        title = "Stats"
    )

    object Settings : BottomNavigationItem(
        route = "settings",
        icon = R.drawable.ic_settings,
        title = "Settings"
    )
}
