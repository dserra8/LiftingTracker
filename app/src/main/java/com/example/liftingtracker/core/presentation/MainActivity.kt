package com.example.liftingtracker.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.liftingtracker.feature_create_schedule.presentation.CreateScheduleScreen
import com.example.liftingtracker.feature_create_schedule.presentation.GetStartedScreen
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }

    @Preview
    @Composable
    fun Main() {
        AppTheme {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "start") {
                composable("start"){ GetStartedScreen(navController) }
                composable("create_schedule"){ CreateScheduleScreen(navController) }
//                composable(
//                    "create_workout_day/{dayNum}",
//                    arguments = listOf(navArgument("dayNum") {type = NavType.IntType})
//                ){ backStackEntry ->
//                    CreateWorkoutDayScreen(navController, dayNum = backStackEntry.arguments?.getInt("dayNum") ?: 0)
//                }
            }
        }
    }
}