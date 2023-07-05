package com.example.liftingtracker.workout.viewmodels

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.liftingtracker.workout.states.WorkoutUiState
import com.example.liftingtracker.workout.views.components.WorkoutCardSetInfo
import com.example.liftingtracker.workout.views.components.WorkoutCardUiState

class WorkoutViewModel: ViewModel() {

    val state: WorkoutUiState by derivedStateOf {
        WorkoutUiState.Success(
            name = "Back and Shoulders",
            date = "",
            startTime = "",
            endTime = "",
            listOfCards = listOf(
                WorkoutCardUiState.Success(
                    sets = listOf(
                        WorkoutCardSetInfo(
                            setNum = "1",
                            reps = "6",
                            weight = "280",
                            weightToBeat = "",
                            repsToBeat = "",
                        ),
                        WorkoutCardSetInfo(
                            setNum = "2",
                            reps = "6",
                            weight = "280",
                            weightToBeat = "",
                            repsToBeat = "",
                        ),
                        WorkoutCardSetInfo(
                            setNum = "3",
                            reps = "",
                            weight = "",
                            weightToBeat = "300",
                            repsToBeat = "5",
                        )
                    ),
                    exerciseName = "Hammer Strength Hack Squat",
                ),
                WorkoutCardUiState.Success(
                    sets = listOf(
                        WorkoutCardSetInfo(
                            setNum = "1",
                            reps = "",
                            weight = "",
                            weightToBeat = "80",
                            repsToBeat = "7",
                        ),
                    ),
                    exerciseName = "Cybex Leg Extension",
                ),
            )
        )
    }

}