package com.example.liftingtracker.feature_create_schedule.domain.models

import androidx.room.Embedded
import androidx.room.Relation

data class PlanWithWorkoutDaysAndExercises(
    @Embedded val plan: WorkoutPlan,
    @Relation(
        entity = WorkoutDay::class,
        parentColumn = "planId",
        entityColumn = "workoutPlanId"
    )
    val workoutDays: List<WorkoutDayWithExercises>
)
