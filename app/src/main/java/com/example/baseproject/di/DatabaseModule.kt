package com.example.baseproject.di

import android.app.Application
import androidx.room.Room
import com.example.baseproject.core.data.local.GeneralDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): GeneralDatabase =
        Room.databaseBuilder(
            app,
            GeneralDatabase::class.java,
            "general_database"
        ).fallbackToDestructiveMigration().build()
}
