package com.example.liftingtracker.feature_create_schedule.domain.models

import androidx.room.Entity

@Entity(primaryKeys = ["id", "exerciseId"])
data class WorkoutDayExerciseCrossRef(
    val id: Long,
    val exerciseId: Long
)
