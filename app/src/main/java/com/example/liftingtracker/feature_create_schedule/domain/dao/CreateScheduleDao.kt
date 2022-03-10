package com.example.liftingtracker.feature_create_schedule.domain.dao

import androidx.room.*
import com.example.liftingtracker.core.domain.models.Exercise
import com.example.liftingtracker.feature_create_schedule.domain.models.*

@Dao
interface CreateScheduleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutPlan(plan: WorkoutPlan)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutDay(day: WorkoutDay)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: Exercise)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutDayExerciseCrossRef(crossRef: WorkoutDayExerciseCrossRef)

    @Transaction
    @Query("SELECT * FROM WorkoutPlan WHERE planId=:id")
    suspend fun getPlanWithWorkoutDays(id: Long): PlanWithWorkoutDays

    @Transaction
    @Query("SELECT * FROM WorkoutDay WHERE workoutPlanId=:id")
    suspend fun getWorkoutDayWithExercises(id: Long): WorkoutDayWithExercises

    @Transaction
    @Query("SELECT * FROM WorkoutPlan WHERE planId=:id")
    suspend fun getPlanWithWorkoutDaysAndExercises(id: Long): PlanWithWorkoutDaysAndExercises
}