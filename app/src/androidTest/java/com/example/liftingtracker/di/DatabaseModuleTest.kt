package com.example.liftingtracker.di

import android.content.Context
import androidx.room.Room
import com.example.liftingtracker.core.data.local.LiftingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import org.junit.Assert.*

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class]
)
object DatabaseModuleTest {
    @Provides
    fun provideInMemoryDb(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(context, LiftingDatabase::class.java)
            .allowMainThreadQueries()
            .build()
}