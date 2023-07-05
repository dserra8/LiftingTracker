package com.example.liftingtracker.core.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Exercise(
    @PrimaryKey
    val exerciseId: String = UUID.randomUUID().toString(),
    val exerciseName: String,
    val targetMuscle: String,
)

@Entity(primaryKeys = ["exerciseId", "brandId"], tableName = "crossref")
data class ExerciseBrandCrossRef(
    val exerciseId: String,
    val brandId: String,
)

