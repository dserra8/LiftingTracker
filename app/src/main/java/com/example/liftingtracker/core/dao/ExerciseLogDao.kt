package com.example.liftingtracker.core.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.liftingtracker.home.models.ExerciseLog

@Dao
interface ExerciseLogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExerciseLog(item: ExerciseLog) : Long
}