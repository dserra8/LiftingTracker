package com.example.liftingtracker.workout.models

import androidx.room.Entity

@Entity(primaryKeys = ["id", "exerciseId"])
data class WorkoutDayExerciseCrossRef(
    val id: Long,
    val exerciseId: Long
)
