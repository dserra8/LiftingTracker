package com.example.liftingtracker.home.states

import com.example.liftingtracker.home.models.WorkoutLogItem

sealed class WorkoutLogsUiState {

    object Loading : WorkoutLogsUiState()
    object Error : WorkoutLogsUiState()

    data class Success(
        val items : List<WorkoutLogItem>
    ) : WorkoutLogsUiState()
}
