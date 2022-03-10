package com.example.liftingtracker.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.liftingtracker.core.domain.dao.CoreDao
import com.example.liftingtracker.core.domain.models.Exercise
import com.example.liftingtracker.core.domain.models.User
import com.example.liftingtracker.feature_create_schedule.domain.dao.CreateScheduleDao
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutDay
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutDayExerciseCrossRef
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutPlan

@Database(
    entities = [
        WorkoutPlan::class,
        WorkoutDay::class,
        User::class,
        Exercise::class,
        WorkoutDayExerciseCrossRef::class
    ], version = 1
)
abstract class LiftingDatabase : RoomDatabase() {

    //Declare Daos
    abstract fun coreDao(): CoreDao
    abstract fun createScheduleDao(): CreateScheduleDao


}