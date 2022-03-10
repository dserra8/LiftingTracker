package com.example.liftingtracker.feature_create_schedule.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutDay(
    @PrimaryKey(autoGenerate = false) val dayId: Long,
    val workoutPlanId: Long,
    val title: String,
    val muscles: String = ""
)
