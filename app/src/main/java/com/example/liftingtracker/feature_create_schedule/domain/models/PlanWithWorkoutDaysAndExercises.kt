package com.example.liftingtracker.feature_create_schedule.domain.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.liftingtracker.workout.models.WorkoutDay
import com.example.liftingtracker.workout.models.WorkoutDayWithExercises

data class PlanWithWorkoutDaysAndExercises(
    @Embedded val plan: WorkoutPlan,
    @Relation(
        entity = WorkoutDay::class,
        parentColumn = "planId",
        entityColumn = "workoutPlanId"
    )
    val workoutDays: List<WorkoutDayWithExercises>
)
