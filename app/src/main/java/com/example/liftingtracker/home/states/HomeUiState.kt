package com.example.liftingtracker.home.states

sealed class HomeUiState {

    object Error : HomeUiState()
    data class Initial(
        val workoutLogsUiState: WorkoutLogsUiState
    ) : HomeUiState()
}
