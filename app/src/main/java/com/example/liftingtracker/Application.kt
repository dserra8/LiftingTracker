package com.example.liftingtracker

import android.app.Application
import com.example.liftingtracker.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber.*
import timber.log.Timber.Forest.plant


class Application: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            plant(DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@Application)
            modules(AppModule.appModule)
        }
    }
}