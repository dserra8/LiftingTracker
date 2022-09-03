package com.example.liftingtracker.feature_create_schedule.views.createschedule.state

import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.liftingtracker.core.util.swapList
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutDay
import java.util.*

@Suppress("UNCHECKED_CAST")
@OptIn(ExperimentalMaterialApi::class)
class CreateScheduleState(
    val scaffoldState: BackdropScaffoldState,
    initialDay: Int?,
    initialList: List<WorkoutDay>
) {
    var day by mutableStateOf(initialDay)

    val list = mutableStateListOf<WorkoutDay>().swapList(initialList)

    fun addDay(planId: Long) {
        list.add(
            WorkoutDay(
                dayNum = list.size + 1,
                workoutPlanId = planId,
                id = UUID.randomUUID().toString()
            )
        )
        day = list.lastIndex
    }

    fun modifyDay(workout: WorkoutDay) {
        list[workout.dayNum - 1] = workout
    }

    fun deleteDay(workout: WorkoutDay) {
        var index = workout.dayNum
        list.remove(workout)

        for(i in index .. list.size) {
            list[index-1].dayNum = index
            index++
        }

        day = list.lastIndex.let { lastIndex ->
            if (lastIndex == -1) null else lastIndex
        }
    }

    companion object {
        fun saver(
            scaffoldState: BackdropScaffoldState
        ) = listSaver<CreateScheduleState, Any?>(
            save = { original ->
                listOf(

                    original.day,
                    original.list.toList(),
                )
            },
            restore = { saveable ->
                CreateScheduleState(
                    scaffoldState = scaffoldState,
                    initialDay = saveable[0] as Int,
                    initialList = saveable[1] as List<WorkoutDay>
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun rememberCreateScheduleState(
    initialScaffoldState: BackdropValue,
    initialDay: Int,
    initialList: List<WorkoutDay>
): CreateScheduleState {
    val scaffoldState = rememberBackdropScaffoldState(initialValue = initialScaffoldState)
    val saver = CreateScheduleState.saver(
        scaffoldState = scaffoldState
    )
    return rememberSaveable(saver = saver) {
        CreateScheduleState(
            scaffoldState = scaffoldState,
            initialDay = initialDay,
            initialList = initialList
        )
    }
}