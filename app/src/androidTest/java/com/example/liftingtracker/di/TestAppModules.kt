package com.example.liftingtracker.di

import com.example.leagueapp1.util.DispatcherProvider
import com.example.liftingtracker.AndroidTestDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class]
)
object TestAppModules {

}


@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DispatcherModule::class]
)
object TestDispatcherModule {

    @ExperimentalCoroutinesApi
    @Singleton
    @Provides
    fun provideTestDispatcherProvider(): DispatcherProvider {
        return AndroidTestDispatchers()
    }
}