package com.example.liftingtracker.core.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.liftingtracker.core.data.local.DatabaseHelper
import com.example.liftingtracker.core.models.User
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CoreDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var database: DatabaseHelper

    private lateinit var coreDao: CoreDao

    @Before
    fun setup() = runTest {
        coreDao = database.coreDao()
    }

    @Test
    fun insertingAndRetrievingUser() = runTest {
        var user1 = User(userName = "Daniel", weight = 77f, height = 3.1f)

        val resultID = coreDao.insertUser(user1)
        val verifyUser = coreDao.getUser()!!
        user1 = user1.copy(userId = verifyUser.userId)

        assertThat(user1).isEqualTo(verifyUser)
        assertThat(resultID).isEqualTo(verifyUser.userId)
    }
}