package com.example.liftingtracker.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.liftingtracker.core.dao.*
import com.example.liftingtracker.core.models.Brand
import com.example.liftingtracker.core.models.Exercise
import com.example.liftingtracker.core.models.ExerciseBrandCrossRef
import com.example.liftingtracker.core.models.User
import com.example.liftingtracker.feature_create_schedule.domain.dao.CreateScheduleDao
import com.example.liftingtracker.workout.models.WorkoutDay
import com.example.liftingtracker.workout.models.WorkoutDayExerciseCrossRef
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutPlan
import com.example.liftingtracker.home.dao.WorkoutLogItemDao
import com.example.liftingtracker.home.models.ExerciseLog
import com.example.liftingtracker.home.models.WorkoutLogItem

@Database(
    entities = [
        WorkoutPlan::class,
        WorkoutDay::class,
        User::class,
        Exercise::class,
        WorkoutDayExerciseCrossRef::class,
        Brand::class,
        ExerciseLog::class,
        WorkoutLogItem::class,
        ExerciseBrandCrossRef::class,
    ], version = 1
)
@TypeConverters(value = [DatabaseTypeConverters::class])
abstract class DatabaseHelper : RoomDatabase() {

    abstract fun coreDao(): CoreDao

    abstract fun createScheduleDao(): CreateScheduleDao

    abstract fun workoutLogItemDao(): WorkoutLogItemDao

    abstract fun exerciseLogDao(): ExerciseLogDao

    abstract fun exerciseDao(): ExerciseDao

    abstract fun brandDao(): BrandDao

    abstract fun exerciseBrandCrossRefDao(): ExerciseBrandCrossRefDao

    companion object {
        fun buildDatabase(
            context: Context,
        ): DatabaseHelper {
            return Room.databaseBuilder(
                context,
                DatabaseHelper::class.java,
                "liftingtracker-db"
            )
                .fallbackToDestructiveMigrationOnDowngrade()
                .build()
        }
    }
}