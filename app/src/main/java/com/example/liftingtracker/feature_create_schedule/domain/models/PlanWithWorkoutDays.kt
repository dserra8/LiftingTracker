package com.example.liftingtracker.feature_create_schedule.domain.models

import androidx.room.Embedded
import androidx.room.Relation

data class PlanWithWorkoutDays(
    @Embedded val workoutPlan: WorkoutPlan,
    @Relation(
        parentColumn = "planId",
        entityColumn = "workoutPlanId"
    )
    val workoutDays: List<WorkoutDay>
)
