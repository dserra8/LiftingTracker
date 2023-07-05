package com.example.liftingtracker

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.liftingtracker.core.data.local.DatabaseHelper
import com.example.liftingtracker.core.models.Brand
import com.example.liftingtracker.core.models.Exercise
import java.util.*

fun createDB(): DatabaseHelper {
    val context = ApplicationProvider.getApplicationContext<Context>()
    return Room.inMemoryDatabaseBuilder(context, DatabaseHelper::class.java)
        .allowMainThreadQueries()
        .build()
}

fun buildExercise(
    exerciseId: String = UUID.randomUUID().toString(),
    exerciseName: String = "Bench Press",
    targetMuscle: String = "Chest",
) =
    Exercise(
        exerciseId = exerciseId,
        exerciseName = exerciseName,
        targetMuscle = targetMuscle
    )

fun buildBrand(
    brandId : String = UUID.randomUUID().toString(),
    brandName: String = "Cybex",
    userCreated: Boolean = false,
) =
    Brand(
        brandId = brandId,
        brandName = brandName,
        userCreated = userCreated
    )