package com.example.liftingtracker.core.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Exercise(
    @PrimaryKey val exerciseId: Long,
    val name: String,
    val targetMuscles: String
)



