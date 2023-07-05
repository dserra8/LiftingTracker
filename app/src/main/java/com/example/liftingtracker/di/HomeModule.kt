package com.example.liftingtracker.di

import com.example.liftingtracker.home.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object HomeModule {

    private val vmModule = module {
        viewModel {
            HomeViewModel(
                dispatchers = get(),
                workoutLogItemDao = get(),
            )
        }
    }

    val modules = arrayOf(vmModule)

}