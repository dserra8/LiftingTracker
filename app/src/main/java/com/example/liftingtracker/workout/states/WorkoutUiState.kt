package com.example.liftingtracker.workout.states

import com.example.liftingtracker.workout.views.components.WorkoutCardUiState

sealed class WorkoutUiState {

    object Error: WorkoutUiState()
    object Loading: WorkoutUiState()

    data class Success(
        val name: String,
        val date: String,
        val startTime: String,
        val endTime: String,
        val listOfCards: List<WorkoutCardUiState>
    ): WorkoutUiState()
}
