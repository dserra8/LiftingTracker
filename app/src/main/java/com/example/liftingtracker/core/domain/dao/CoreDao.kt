package com.example.liftingtracker.core.domain.dao

import androidx.room.*
import com.example.liftingtracker.core.domain.models.User
import com.example.liftingtracker.core.domain.models.UserWithWorkoutPlans

@Dao
interface CoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Transaction
    @Query("SELECT * FROM User WHERE userId=:id")
    suspend fun loadUserAndWorkoutPlans(id: Long): UserWithWorkoutPlans

}