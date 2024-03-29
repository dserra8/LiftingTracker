package com.example.liftingtracker.other_test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.liftingtracker.core.dao.CoreDao
import com.example.liftingtracker.core.data.local.DatabaseHelper
import com.example.liftingtracker.feature_create_schedule.domain.dao.CreateScheduleDao
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutPlan
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
class TestDaoNullability {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var database: DatabaseHelper

    private lateinit var createScheduleDao: CreateScheduleDao
    private lateinit var coreDao: CoreDao

    @Before
    fun setup() = runTest {
        createScheduleDao = database.createScheduleDao()
        coreDao = database.coreDao()
    }

    @Test
    fun getUser() = runTest {
        assertThat(coreDao.getUser()).isNull()
    }

    @Test
    fun getPlanWithWorkoutDays() = runTest {

        var result = createScheduleDao.getPlanWithWorkoutDays(1)
        assertThat(result).isNull()

        createScheduleDao.insertWorkoutPlan(WorkoutPlan(planName = "Plan", userCreatorId = 0))
        result = createScheduleDao.getPlanWithWorkoutDays(1)!!
        assertThat(result).isNotNull()
        assertThat(result.workoutDays).isEmpty()
    }

    @Test
    fun getPlanWithWorkoutDaysAndExercises() = runTest {

        var result = createScheduleDao.getPlanWithWorkoutDaysAndExercises(0)
        assertThat(result).isNull()

        createScheduleDao.insertWorkoutPlan(WorkoutPlan(planName = "Plan", userCreatorId = 0))
        result = createScheduleDao.getPlanWithWorkoutDaysAndExercises(1)!!
        assertThat(result).isNotNull()
        assertThat(result.workoutDays).isEmpty()
    }

//    @Test
//    fun getWorkoutDayWithExercises() = runTest {
//
//        var result = createScheduleDao.getWorkoutDayWithExercises(0)
//        assertThat(result).isNull()
//
//        createScheduleDao.insertWorkoutDay(WorkoutDay(dayNum = 1, workoutPlanId = 0))
//        result = createScheduleDao.getWorkoutDayWithExercises(1)!!
//        assertThat(result).isNotNull()
//        assertThat(result.exercises).isEmpty()
//    }

//    @Test
//    fun getUserWithWorkoutPlans() = runTest {
//
//        var result = createScheduleDao.getUserWithWorkoutPlans(0)
//        assertThat(result).isNull()
//
//        coreDao.insertUser(User(userName = "Dan", weight = 77f, height = 1.3f))
//        result = createScheduleDao.getUserWithWorkoutPlans(1)!!
//        assertThat(result).isNotNull()
//        assertThat(result.workoutPlans).isEmpty()
//    }
//
//    @Test
//    fun getUserWithExercises() = runTest {
//
//        var result = createScheduleDao.getUserWithExercises(0)
//        assertThat(result).isNull()
//
//        coreDao.insertUser(User(userName = "Dan", weight = 77f, height = 1.3f))
//        result = createScheduleDao.getUserWithExercises(1)!!
//        assertThat(result).isNotNull()
//        assertThat(result.exercises).isEmpty()
//    }


}