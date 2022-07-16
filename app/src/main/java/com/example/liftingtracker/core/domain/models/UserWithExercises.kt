package com.example.liftingtracker.core.domain.models

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithExercises(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userCreatorId"
    )
    val exercises: List<Exercise>
)
