package com.example.liftingtracker.home.views.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.liftingtracker.core.models.BottomNavigationItem
import com.example.liftingtracker.home.views.screens.home.HomeScreen
import com.example.liftingtracker.workout.views.screens.workoutscreen.WorkoutScreen

@Composable
fun HomeNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeNavigationRoute.Home.route) {
        composable(HomeNavigationRoute.Home.route) {
            HomeScreen(
                navigateWorkoutScreen = {
                    navController.navigate(HomeNavigationRoute.Workout.route)
                }
            )
        }
        composable(HomeNavigationRoute.Workout.route) {
            WorkoutScreen(
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}

sealed class HomeNavigationRoute {
    abstract val route: String

    object NavigationGraph: HomeNavigationRoute() {
        override val route: String = "home-graph"
    }

    object Home: HomeNavigationRoute() {
        override val route: String = "home"
    }

    object Workout: HomeNavigationRoute() {
        override val route: String = "workout"
    }
}