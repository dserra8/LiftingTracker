package com.example.liftingtracker.home.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.liftingtracker.home.models.WorkoutLogItem

@Dao
interface WorkoutLogItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutLog(workout : WorkoutLogItem): Long

}