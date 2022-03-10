package com.example.liftingtracker.feature_create_schedule.domain.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.liftingtracker.core.data.local.LiftingDatabase
import com.example.liftingtracker.core.domain.models.Exercise
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutDay
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutDayExerciseCrossRef
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutPlan
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import kotlin.time.ExperimentalTime


@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
class CreateScheduleDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var database: LiftingDatabase

    private lateinit var createScheduleDao: CreateScheduleDao

  //  private lateinit var plan1: WorkoutPlan

    @Before
    fun setup() {
        hiltRule.inject()
        createScheduleDao = database.createScheduleDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun getPlanWithWorkoutDays() = runBlockingTest {
        val plan1 = WorkoutPlan(
            userCreatorId = 1,
            planName = "Push Pull Legs"
        )
        val listOfDays = mutableListOf(
            WorkoutDay(
                dayId = 1,
                workoutPlanId = plan1.planId,
                title = "Push",
                muscles = "Chest"
            ),
            WorkoutDay(
                dayId = 2,
                workoutPlanId = plan1.planId,
                title = "Pull",
                muscles = "Back"
            ),
            WorkoutDay(
                dayId = 3,
                workoutPlanId = plan1.planId,
                title = "Legs",
                muscles = "Hamstrings"
            ),
            WorkoutDay(
                dayId = 4,
                workoutPlanId = plan1.planId,
                title = "Rest",
            ),
            WorkoutDay(
                dayId = 1,
                workoutPlanId = 2,
                title = "Rest",
            )
        )

        createScheduleDao.insertWorkoutPlan(plan1)
        listOfDays.forEach{
            createScheduleDao.insertWorkoutDay(it)
        }

        listOfDays.removeLast()

       val res = createScheduleDao.getPlanWithWorkoutDays(plan1.planId)
        assertThat(res.workoutPlan).isEqualTo(plan1)
        assertThat(res.workoutDays).isEqualTo(listOfDays)
    }

    @Test
    fun getWorkoutDayWithExercises() = runBlockingTest {

    }

    @Test
    fun getPlanWithWorkoutDaysAndExercises() = runBlockingTest {

    }

}