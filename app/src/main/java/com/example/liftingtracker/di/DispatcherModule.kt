package com.example.liftingtracker.di

import com.example.leagueapp1.util.DispatcherProvider
import com.example.leagueapp1.util.StandardDispatchers
import org.koin.dsl.binds
import org.koin.dsl.module


object DispatcherModule {
    val module = module {
        single {
            StandardDispatchers()
        } binds arrayOf(DispatcherProvider::class)
    }
}