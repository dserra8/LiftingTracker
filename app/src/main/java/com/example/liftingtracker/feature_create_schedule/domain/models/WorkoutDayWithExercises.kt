package com.example.liftingtracker.feature_create_schedule.domain.models

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.liftingtracker.core.domain.models.Exercise

data class WorkoutDayWithExercises(
    @Embedded val workoutDay: WorkoutDay,
    @Relation(
        parentColumn = "id",
        entityColumn = "exerciseId",
        associateBy = Junction(WorkoutDayExerciseCrossRef::class)
    )
    val exercises: List<Exercise>
)
