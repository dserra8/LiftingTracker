package com.example.liftingtracker.feature_create_schedule.views.createschedule.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.unit.dp
import com.example.liftingtracker.R
import com.example.liftingtracker.core.views.components.SwipeToDismissBackground
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutDay
import com.example.liftingtracker.feature_create_schedule.views.createschedule.state.CreateScheduleState
import kotlinx.coroutines.launch
import timber.log.Timber

const val TAG = "TAG"

@ExperimentalMaterialApi
@Composable
fun BackLayer(
    state: CreateScheduleState
) {
    val scope = rememberCoroutineScope()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(state.list, { list: WorkoutDay -> list.id }) { item ->

            val dismissState = rememberDismissState(
                confirmStateChange = {
                    if (it == DismissValue.DismissedToEnd || it == DismissValue.DismissedToStart) {
                        Timber.tag(TAG).d("deleting: $item")
                        state.deleteDay(item)
                    }
                    true
                }
            )

            SwipeToDismiss(
                state = dismissState,
                dismissThresholds = {
                    FractionalThreshold(0.4f)
                },
                background = {
                    SwipeToDismissBackground(dismissState = dismissState)
                },
                directions = setOf(DismissDirection.EndToStart, DismissDirection.StartToEnd),
                dismissContent = {
                    WorkoutDayItem(
                        item = item,
                        elevation = animateDpAsState(
                            targetValue = if (dismissState.dismissDirection != null) 4.dp else 0.dp
                        ).value
                    ) {
                        //Implement OnClick Listener
                        scope.launch {
                            Timber.tag(TAG).d("clicking: $item")
                            state.day = item.dayNum - 1
                            state.scaffoldState.conceal()
                        }
                    }
                }
            )
        }
        item {
            FloatingButton(
                text = "Day",
                drawable = R.drawable.ic_add,
                contentDescription = "Add Workout Day"
            ) {
                state.addDay(0)
            }
        }

    }
}