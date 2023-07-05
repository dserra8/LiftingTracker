package com.example.liftingtracker.feature_create_schedule.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.liftingtracker.core.views.StandardButton

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

