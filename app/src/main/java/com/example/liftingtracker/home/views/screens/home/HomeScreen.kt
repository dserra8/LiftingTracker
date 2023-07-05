package com.example.liftingtracker.home.views.screens.home

import androidx.compose.runtime.Composable
import com.example.liftingtracker.home.viewmodels.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    viewModel : HomeViewModel = getViewModel(),
    navigateWorkoutScreen: () -> Unit,
) {
    HomePage(
        state = viewModel.state,
        onClickTopBar = navigateWorkoutScreen
    )
}