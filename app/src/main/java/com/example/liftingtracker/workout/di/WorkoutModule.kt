package com.example.liftingtracker.workout.di

import com.example.liftingtracker.di.DispatcherModule.module
import com.example.liftingtracker.workout.viewmodels.WorkoutViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object WorkoutModule {

    private val vmModule = module {

        viewModel {
            WorkoutViewModel()
        }
    }

    val modules = arrayOf(vmModule)
}