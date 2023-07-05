package com.example.liftingtracker.workout.views.screens.workoutscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.liftingtracker.R
import com.example.liftingtracker.core.states.InputState
import com.example.liftingtracker.core.states.rememberSaveableInputState
import com.example.liftingtracker.core.views.AppTheme
import com.example.liftingtracker.core.views.components.MainAppBar
import com.example.liftingtracker.core.views.components.ResizeableTextField
import com.example.liftingtracker.core.views.components.theme.Bones
import com.example.liftingtracker.workout.states.WorkoutUiState
import com.example.liftingtracker.workout.views.components.WorkoutCard
import com.example.liftingtracker.workout.views.components.WorkoutCardSetInfo
import com.example.liftingtracker.workout.views.components.WorkoutCardUiState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutPage(
    state: WorkoutUiState,
    nameState: InputState,
    dateState: InputState,
    startState: InputState,
    endState: InputState,
    onBackClicked: () -> Unit,
) {
    Scaffold(
        topBar = {
            MainAppBar(
                isPopEnabled = true,
                title = {
                    Text(
                        text = stringResource(id = R.string.workout_screen_title)
                    )
                },
                onBackPressed = onBackClicked
            )
        },
    ) { paddingValues ->
        when (state) {
            is WorkoutUiState.Error -> TODO()
            is WorkoutUiState.Loading -> TODO()
            is WorkoutUiState.Success -> {
                val focusManager = LocalFocusManager.current
                val listState = rememberLazyListState()
                val coroutineScope = rememberCoroutineScope()
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    state = listState
                ) {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                value = nameState.value,
                                onValueChange = {
                                    nameState.onValueChanged(it)
                                },
                                label = {
                                    Text(
                                        text = "Workout name"
                                    )
                                },
                                shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        coroutineScope.launch {
                                            listState.animateScrollToItem(1)
                                        }
                                        focusManager.moveFocus(
                                            focusDirection = FocusDirection.Next
                                        )
                                    }
                                ),
                                singleLine = true,
                            )
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                value = dateState.value,
                                onValueChange = {
                                    dateState.onValueChanged(it)
                                },
                                label = {
                                    Text(
                                        text = "Date"
                                    )
                                },
                                shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        coroutineScope.launch {
                                            listState.animateScrollToItem(2)
                                        }
                                        focusManager.moveFocus(
                                            focusDirection = FocusDirection.Next
                                        )
                                    }
                                ),
                                singleLine = true,
                            )
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                value = startState.value,
                                onValueChange = {
                                    startState.onValueChanged(it)
                                },
                                label = {
                                    Text(
                                        text = "Start time"
                                    )
                                },
                                shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        coroutineScope.launch {
                                            listState.animateScrollToItem(3)
                                        }
                                        focusManager.moveFocus(
                                            focusDirection = FocusDirection.Next
                                        )
                                    }
                                ),
                                singleLine = true,
                            )
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                value = endState.value,
                                onValueChange = {
                                    endState.onValueChanged(it)
                                },
                                label = {
                                    Text(
                                        text = "End time"
                                    )
                                },
                                shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        coroutineScope.launch {
                                            listState.animateScrollToItem(4)
                                        }
                                        focusManager.moveFocus(
                                            focusDirection = FocusDirection.Next
                                        )
                                    }
                                ),
                                singleLine = true,
                            )
                        }
                        Bones.Spacing.Spacing8()
                    }
                    items(state.listOfCards) {
                        WorkoutCard(
                            state = it,
                            onAddSet = {},
                            focusManager = focusManager,
                        )
                    }
                    item {
                        Bones.Spacing.Spacing8()
                        FloatingActionButton(
                            modifier = Modifier,
                            onClick = { /*TODO*/ },
                            content = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_add),
                                    contentDescription = "Add exercise"
                                )
                            }
                        )
                        Bones.Spacing.Spacing16()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WorkoutPagePreview() {
    AppTheme {
        WorkoutPage(
            state = WorkoutUiState.Success(
                name = "",
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
            ),
            onBackClicked = {},
            nameState = rememberSaveableInputState(),
            dateState = rememberSaveableInputState(),
            endState = rememberSaveableInputState(),
            startState = rememberSaveableInputState()
        )
    }
}