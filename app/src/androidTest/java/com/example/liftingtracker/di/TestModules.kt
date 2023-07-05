package com.example.liftingtracker.di

import androidx.room.Room
import com.example.liftingtracker.core.data.local.DatabaseHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object TestModules {

    val modules = module {
        single {
            val context = androidContext()
            Room.inMemoryDatabaseBuilder(context, DatabaseHelper::class.java)
                .allowMainThreadQueries()
                .build()
        }
    }
}