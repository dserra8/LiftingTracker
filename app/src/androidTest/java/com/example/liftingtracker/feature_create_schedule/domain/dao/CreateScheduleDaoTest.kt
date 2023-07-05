package com.example.liftingtracker.feature_create_schedule.domain.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.example.liftingtracker.core.dao.CoreDao
import com.example.liftingtracker.core.data.local.DatabaseHelper
import com.example.liftingtracker.core.models.Exercise
import com.example.liftingtracker.core.models.User
import com.example.liftingtracker.workout.models.WorkoutDay
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutPlan
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@ExperimentalCoroutinesApi
@SmallTest
class CreateScheduleDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var database: DatabaseHelper

    private lateinit var createScheduleDao: CreateScheduleDao
    private lateinit var coreDao: CoreDao

    private lateinit var user1 : User
    private lateinit var plan1: WorkoutPlan
    private lateinit var listOfDays: MutableList<WorkoutDay>
    private lateinit var listOfExercises: MutableList<Exercise>
    private lateinit var countOfExercisesPerDay: MutableList<Int>

    @Before
    fun setup() = runTest {
        //Injecting Dependecies

        //Creating Daos
        createScheduleDao = database.createScheduleDao()
        coreDao = database.coreDao()

        //Creating test user
        user1 = User(userId = 1, userName = "Danny", weight = 170f, height = 130f)
        coreDao.insertUser(user1)

        //Creating test plan
        plan1 = WorkoutPlan(
            userCreatorId = user1.userId,
            planId = 1,
            planName = "Push Pull Legs" )

    }

    @After
    fun teardown() {
        database.close()
    }



    @Test
    fun getPlanWithWorkoutDays() = runTest {

        listOfDays.removeLast()

        val res = createScheduleDao.getPlanWithWorkoutDays(plan1.planId)!!

        assertThat(res.workoutPlan).isEqualTo(plan1)
        assertThat(res.workoutDays).isEqualTo(listOfDays)
    }

    @Test
    fun getWorkoutDayWithExercises() = runTest {
        val dayId = 3L
        val res = createScheduleDao.getWorkoutDayWithExercises(id = dayId)!!

        assertThat(res.workoutDay).isEqualTo(listOfDays[(dayId - 1).toInt()])
        assertThat(res.exercises.size).isEqualTo(countOfExercisesPerDay[dayId.toInt()-1])
    }

    @Test
    fun getPlanWithWorkoutDaysAndExercises() = runTest {
        val res = createScheduleDao.getPlanWithWorkoutDaysAndExercises(id = plan1.planId)!!
        assertThat(res.plan).isEqualTo(plan1)
        res.workoutDays.forEach {
            assertThat(it.workoutDay.workoutPlanId).isEqualTo(plan1.planId)
            assertThat(it.exercises.size).isEqualTo(countOfExercisesPerDay[it.workoutDay.id.toInt()-1])
        }
    }

//    @Test
//    fun getUserWithWorkoutPlan() = runTest {
//        coreDao.insertUser(User(userId = 2, userName = "Kalie", weight = 100f, height = 50f))
//        coreDao.insertUser(User(userId = 3, userName = "Ivan", weight = 100f, height = 50f))
//        createScheduleDao.insertWorkoutPlan(WorkoutPlan(planId = 2, userCreatorId = 2, planName = "Bro Split"))
//        createScheduleDao.insertWorkoutPlan(WorkoutPlan(planId = 3, userCreatorId = 1, planName = "Homo Split"))
//        val res1 = createScheduleDao.getUserWithWorkoutPlans(id = user1.userId)!!
//        val res2 = createScheduleDao.getUserWithWorkoutPlans(id = 2)!!
//        assertThat(res1.user).isEqualTo(user1)
//        assertThat(res1.workoutPlans.size).isEqualTo(2)
//        assertThat(res2.workoutPlans.size).isEqualTo(1)
//    }
//
//    @Test
//    fun getUserWithExercises() = runTest {
//        coreDao.insertUser(User(userId = 2, userName = "Kalie", weight = 100f, height = 50f))
//        coreDao.insertUser(User(userId = 3, userName = "Ivan", weight = 100f, height = 50f))
//        createScheduleDao.insertWorkoutPlan(WorkoutPlan(planId = 2, userCreatorId = 2, planName = "Bro Split"))
//        createScheduleDao.insertWorkoutPlan(WorkoutPlan(planId = 3, userCreatorId = 1, planName = "Homo Split"))
//        val res1 = createScheduleDao.getUserWithExercises(id = user1.userId)
//
//    }
}