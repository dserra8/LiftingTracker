package com.example.liftingtracker.feature_create_schedule.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.liftingtracker.core.presentation.StandardButton

@Composable
fun GetStartedScreen(navController: NavController) {
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            StandardButton {
                navController.navigate("create_schedule") {
                    launchSingleTop = true
                }
            }
        }
    }
}

