package com.example.liftingtracker.home.views.previewproviders

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.liftingtracker.core.models.Exercise
import com.example.liftingtracker.home.models.ExerciseLog
import com.example.liftingtracker.home.models.WorkoutLogItem
import com.example.liftingtracker.home.states.HomeUiState
import com.example.liftingtracker.home.states.WorkoutLogsUiState
import org.joda.time.DateTime

class HomeUiStatePreviewParameter : PreviewParameterProvider<HomeUiState> {

    private val exercise = ExerciseLog(
        exercise = Exercise(exerciseName = "Cybex Seated Leg Curl", targetMuscle = "Legs"),
        reps = 7,
        weight = 128.0f,
        order = 1,
        workoutLogId = 0,
    )

    override val values: Sequence<HomeUiState> = sequenceOf(
        HomeUiState.Initial(
            workoutLogsUiState = WorkoutLogsUiState.Success(
                listOf(
                    WorkoutLogItem(
                        title = "Back and Shoulders",
                        timeInMin = "96 min",
                        startTime = DateTime.now(),
                        endTime = DateTime.now(),
                    ),
                    WorkoutLogItem(
                        title = "Legs",
                        timeInMin = "60 min",
                        startTime = DateTime.now(),
                        endTime = DateTime.now(),
                    ),
                    WorkoutLogItem(
                        title = "Legs",
                        timeInMin = "",
                        startTime = DateTime.now(),
                        endTime = DateTime.now(),
                    ),
                )
            )
        ),
        HomeUiState.Initial(
            workoutLogsUiState = WorkoutLogsUiState.Success(
                listOf(
                    WorkoutLogItem(
                        title = "Back and Shoulders",
                        timeInMin = "96 min",
                        startTime = DateTime.now(),
                        endTime = DateTime.now(),
                    ),
                )
            )
        ),
    )
}