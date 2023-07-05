package com.example.liftingtracker.home.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.joda.time.DateTime

@Entity
data class WorkoutLogItem(
    @PrimaryKey(autoGenerate = false)
    val id: Long = 0,
    val title: String,
    val timeInMin: String,
    val startTime: DateTime,
    val endTime: DateTime,
)

