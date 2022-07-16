package com.example.liftingtracker.di

import android.app.Application
import androidx.room.Room
import com.example.liftingtracker.core.data.local.LiftingDatabase
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
    fun provideDatabase(app: Application): LiftingDatabase =
        Room.databaseBuilder(
            app,
            LiftingDatabase::class.java,
            "lifting_database"
        )
            .createFromAsset("database/user.db")
            .fallbackToDestructiveMigration()
            .build()
}
