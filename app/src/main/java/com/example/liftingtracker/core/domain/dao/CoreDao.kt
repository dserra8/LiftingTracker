package com.example.liftingtracker.core.domain.dao

import androidx.room.*
import com.example.liftingtracker.core.domain.models.User
import com.example.liftingtracker.core.domain.models.UserWithExercises
import com.example.liftingtracker.core.domain.models.UserWithWorkoutPlans
import retrofit2.http.GET

@Dao
interface CoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM user")
    suspend fun getUser(): User?
}