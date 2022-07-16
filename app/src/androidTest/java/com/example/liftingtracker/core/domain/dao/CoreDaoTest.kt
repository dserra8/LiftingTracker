package com.example.liftingtracker.core.domain.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.liftingtracker.core.data.local.LiftingDatabase
import com.example.liftingtracker.core.domain.models.User
import com.example.liftingtracker.feature_create_schedule.domain.dao.CreateScheduleDao
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltAndroidTest
class CoreDaoTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var database: LiftingDatabase

    private lateinit var coreDao: CoreDao

    @Before
    fun setup() = runTest {
        hiltRule.inject()
        coreDao = database.coreDao()
    }

    @Test
    fun insertingAndRetrievingUser() = runTest {
        var user1 = User(name = "Daniel", weight = 77f, height = 3.1f)

        val resultID = coreDao.insertUser(user1)
        val verifyUser = coreDao.getUser()!!
        user1 = user1.copy(userId = verifyUser.userId)

        assertThat(user1).isEqualTo(verifyUser)
        assertThat(resultID).isEqualTo(verifyUser.userId)
    }
}