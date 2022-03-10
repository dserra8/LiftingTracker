package com.example.liftingtracker.core.domain.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutPlan

data class UserWithWorkoutPlans(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userCreatorId"
    )
    val workoutPlans: List<WorkoutPlan>
)
