package com.example.liftingtracker.workout.views.screens.workoutscreen


import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.TextFieldValue
import com.example.liftingtracker.core.states.rememberSaveableInputState
import com.example.liftingtracker.workout.viewmodels.WorkoutViewModel
import org.koin.androidx.compose.getViewModel


@Composable
fun WorkoutScreen(
    viewModel: WorkoutViewModel = getViewModel(),
    navigateBack: () -> Unit,
) {

    val nameState = rememberSaveableInputState()
    val dateState = rememberSaveableInputState()
    val startTimeState = rememberSaveableInputState()
    val endTimeState = rememberSaveableInputState()

    WorkoutPage(
        state = viewModel.state,
        nameState = nameState,
        onBackClicked = navigateBack,
        dateState = dateState,
        startState = startTimeState,
        endState = endTimeState
    )
}