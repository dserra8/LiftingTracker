package com.example.liftingtracker.di

import com.example.liftingtracker.workout.di.WorkoutModule
import org.koin.core.module.Module


object AppModule {

    val appModule: List<Module> = listOf(
        *HomeModule.modules,
        DispatcherModule.module,
        DatabaseModule.databaseModule,
        *WorkoutModule.modules,
    )
}
