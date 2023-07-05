package com.example.liftingtracker.core.views.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.liftingtracker.core.models.BottomNavigationItem
import com.example.liftingtracker.home.views.navigation.HomeNavigation


@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavigationItem.Home.route) {
        composable(BottomNavigationItem.Home.route) {
            HomeNavigation()
        }
        composable(BottomNavigationItem.Plan.route) {

        }
        composable(BottomNavigationItem.Stats.route) {

        }
        composable(BottomNavigationItem.Settings.route) {

        }
    }
}