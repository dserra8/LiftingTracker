package com.example.liftingtracker.home.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.liftingtracker.core.models.Exercise

@Entity
data class ExerciseLog(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val workoutLogId : Long,
    val reps: Int,
    val weight: Float,
    val order: Int,
    @Embedded
    val exercise: Exercise,
)