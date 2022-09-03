package com.example.liftingtracker.feature_create_schedule.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutDay(
    @PrimaryKey
    val id: String,
    var dayNum: Int,
    val workoutPlanId: Long,
    var title: String = "",
    val isRest: Boolean = false
)
