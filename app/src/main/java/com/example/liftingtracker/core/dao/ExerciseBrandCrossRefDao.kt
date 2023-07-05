package com.example.liftingtracker.core.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.liftingtracker.core.models.ExerciseBrandCrossRef

@Dao
interface ExerciseBrandCrossRefDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExerciseBrandCrossRef(item : ExerciseBrandCrossRef) : Long
}