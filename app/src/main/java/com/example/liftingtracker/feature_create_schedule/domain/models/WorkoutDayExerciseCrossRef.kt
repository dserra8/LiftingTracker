package com.example.liftingtracker.feature_create_schedule.domain.models

import androidx.room.Entity

@Entity(primaryKeys = ["dayId", "exerciseId"])
data class WorkoutDayExerciseCrossRef(
    val dayId: Long,
    val exerciseId: Long
)
