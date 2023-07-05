package com.example.liftingtracker.home.viewmodels

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leagueapp1.util.DispatcherProvider
import com.example.liftingtracker.core.models.Exercise
import com.example.liftingtracker.home.dao.WorkoutLogItemDao
import com.example.liftingtracker.home.models.ExerciseLog
import com.example.liftingtracker.home.models.WorkoutLogItem
import com.example.liftingtracker.home.states.HomeUiState
import com.example.liftingtracker.home.states.WorkoutLogsUiState
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.joda.time.DateTime


class HomeViewModel(
    dispatchers: DispatcherProvider,
    private val workoutLogItemDao: WorkoutLogItemDao,
) : ViewModel() {

    private var isError: Boolean by mutableStateOf(false)
    private var workoutLogsUiState : WorkoutLogsUiState by mutableStateOf(WorkoutLogsUiState.Loading)

    val state: HomeUiState by derivedStateOf {
        if(isError) {
            HomeUiState.Error
        } else {
            HomeUiState.Initial(
                workoutLogsUiState = workoutLogsUiState
            )
        }
    }


    init {
        viewModelScope.launch(dispatchers.io) {
            initWorkoutLogsAsync().await()
        }
    }

    private fun initWorkoutLogsAsync() =
        viewModelScope.async {

        }
}