package com.example.liftingtracker.feature_create_schedule.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutDay(
    @PrimaryKey(autoGenerate = true) val dayId: Long = 0,
    val dayNum: Int,
    val workoutPlanId: Long,
    val title: String = "",
    val isRest: Boolean = false
)
