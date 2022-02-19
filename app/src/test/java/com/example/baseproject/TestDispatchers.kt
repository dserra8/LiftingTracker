package com.example.baseproject

import com.example.leagueapp1.util.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Assert.*

@ExperimentalCoroutinesApi
class TestDispatchers : DispatcherProvider {

    override val main: CoroutineDispatcher
        get() = TestCoroutineDispatcher()
    override val io: CoroutineDispatcher
        get() = TestCoroutineDispatcher()
    override val default: CoroutineDispatcher
        get() = TestCoroutineDispatcher()
    override val unconfined: CoroutineDispatcher
        get() = TestCoroutineDispatcher()

}