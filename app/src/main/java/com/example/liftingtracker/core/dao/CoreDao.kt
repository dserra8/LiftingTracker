package com.example.liftingtracker.core.dao

import androidx.room.*
import com.example.liftingtracker.core.models.User

@Dao
interface CoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM user")
    suspend fun getUser(): User?
}