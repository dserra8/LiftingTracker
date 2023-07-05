package com.example.liftingtracker.workout.views.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.liftingtracker.R
import com.example.liftingtracker.core.views.AppTheme
import com.example.liftingtracker.core.views.components.ResizeableTextField
import com.example.liftingtracker.core.views.components.StandardCard
import com.example.liftingtracker.core.views.components.theme.Bones

sealed class WorkoutCardUiState {
    object Loading : WorkoutCardUiState()
    object Error : WorkoutCardUiState()

    data class Success(
        val sets: List<WorkoutCardSetInfo>,
        val exerciseName: String,
    ) : WorkoutCardUiState()
}

data class WorkoutCardSetInfo(
    val setNum: String,
    val weight: String,
    val reps: String,
    val weightToBeat: String,
    val repsToBeat: String,

    )

@Composable
fun WorkoutCard(
    state: WorkoutCardUiState,
    focusManager: FocusManager,
    onAddSet: () -> Unit,
) {
    when (state) {
        WorkoutCardUiState.Error -> TODO()
        WorkoutCardUiState.Loading -> TODO()
        is WorkoutCardUiState.Success -> {
            StandardCard {
                Column(
                    modifier = Modifier
                        .padding(8.dp),
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(align = Alignment.CenterHorizontally),
                        text = state.exerciseName,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Bones.Spacing.Spacing16()
                    state.sets.forEach { setInfo ->
                        SetRow(
                            data = setInfo,
                            focusManager = focusManager
                        )
                    }
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SmallFloatingActionButton(
                            modifier = Modifier
                                .align(Alignment.BottomEnd),
                            onClick = onAddSet,
                            content = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_add),
                                    contentDescription = "Add Set"
                                )
                            },
                        )
                    }
                }
            }
        }
    }


}

@Composable
fun SetRow(
    data: WorkoutCardSetInfo,
    focusManager: FocusManager,
) {
    val weightState = rememberSaveable {
        mutableStateOf(data.weight)
    }

    val repState = rememberSaveable {
        mutableStateOf(data.reps)
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Bones.Dimension.Palette.Dimen8),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(4.dp),
                    color = MaterialTheme.colorScheme.outline
                )
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp),
                text = data.setNum,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Bones.Spacing.Spacing16()
        ResizeableTextField(
            value = weightState.value,
            labelValue = stringResource(id = R.string.weight),
            interactionSource = interactionSource,
            onValueChange = { weightState.value = it },
            placeholder = {
                Text(
                    text = data.weightToBeat,
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = Color.Gray.copy(
                            alpha = .3f
                        )
                    )
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(
                        focusDirection = FocusDirection.Next
                    )
                }
            ),
        )
        Bones.Spacing.Spacing4()
        ResizeableTextField(
            value = repState.value,
            labelValue = stringResource(id = R.string.reps),
            interactionSource = interactionSource,
            onValueChange = { repState.value = it },
            placeholder = {
                Text(
                    text = data.repsToBeat,
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = Color.Gray.copy(
                            alpha = .3f
                        )
                    )
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(
                        focusDirection = FocusDirection.Next
                    )
                }
            ),
        )
    }
}


@Composable
@Preview(showBackground = true)
fun WorkoutCardPreview() {
    AppTheme {
        WorkoutCard(
            state = WorkoutCardUiState.Success(
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
            onAddSet = {},
            focusManager = LocalFocusManager.current
        )
    }
}