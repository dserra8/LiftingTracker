package com.example.liftingtracker.core.views.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.liftingtracker.core.views.components.MainBottomNavigation

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            MainBottomNavigation(
                navController = navController
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .padding(it)
            ) {
                Navigation(
                    navController = navController
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewHomePage() {
    MainPage()
}