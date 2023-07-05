package com.example.liftingtracker.di

import com.example.liftingtracker.core.dao.CoreDao
import com.example.liftingtracker.core.data.local.DatabaseHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DatabaseModule {

    val databaseModule = module {
        // Rooms Database
        single {
            DatabaseHelper.buildDatabase(
                context = androidContext()
            )
        }
        single {
            val db : DatabaseHelper = get()
            db.coreDao()
        }
        single {
            val db : DatabaseHelper = get()
            db.createScheduleDao()
        }
        single {
            val db : DatabaseHelper = get()
            db.workoutLogItemDao()
        }
        single {
            val db : DatabaseHelper = get()
            db.exerciseDao()
        }
        single {
            val db : DatabaseHelper = get()
            db.exerciseLogDao()
        }
        single {
            val db : DatabaseHelper = get()
            db.exerciseBrandCrossRefDao()
        }
        single {
            val db : DatabaseHelper = get()
            db.brandDao()
        }
    }
}

