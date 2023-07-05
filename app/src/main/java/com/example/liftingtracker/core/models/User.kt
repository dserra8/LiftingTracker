package com.example.liftingtracker.core.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Long = 0,
    val userName: String,
    val weight: Float, // In kg
    val height: Float, // In cm
)
