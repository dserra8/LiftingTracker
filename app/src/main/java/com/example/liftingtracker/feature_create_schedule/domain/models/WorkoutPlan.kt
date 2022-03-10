package com.example.liftingtracker.feature_create_schedule.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutPlan(
    @PrimaryKey(autoGenerate = true) val planId: Long = 0,
    val userCreatorId: Long,
    val planName: String
)
