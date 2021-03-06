package com.example.liftingtracker.feature_create_schedule.domain.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.example.liftingtracker.core.data.local.LiftingDatabase
import com.example.liftingtracker.core.domain.dao.CoreDao
import com.example.liftingtracker.core.domain.models.Exercise
import com.example.liftingtracker.core.domain.models.User
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutDay
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutDayExerciseCrossRef
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutPlan
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith
import javax.inject.Inject


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
    private lateinit var coreDao: CoreDao

    private lateinit var user1 : User
    private lateinit var plan1: WorkoutPlan
    private lateinit var listOfDays: MutableList<WorkoutDay>
    private lateinit var listOfExercises: MutableList<Exercise>
    private lateinit var countOfExercisesPerDay: MutableList<Int>

    @Before
    fun setup() = runTest {
        //Injecting Dependecies
        hiltRule.inject()

        //Creating Daos
        createScheduleDao = database.createScheduleDao()
        coreDao = database.coreDao()

        //Creating test user
        user1 = User(userId = 1, name = "Danny", weight = 170f, height = 130f)
        coreDao.insertUser(user1)

        //Creating test plan
        plan1 = WorkoutPlan(
            userCreatorId = user1.userId,
            planId = 1,
            planName = "Push Pull Legs"
        )
        createScheduleDao.insertWorkoutPlan(plan1)

        //Creating test workout days
        listOfDays = mutableListOf(
            WorkoutDay(
                dayId = 1,
                dayNum = 1,
                workoutPlanId = plan1.planId,
                title = "Push",
            ),
            WorkoutDay(
                dayId = 2,
                dayNum = 2,
                workoutPlanId = plan1.planId,
                title = "Pull",
            ),
            WorkoutDay(
                dayId = 3,
                dayNum = 3,
                workoutPlanId = plan1.planId,
                title = "Legs",
            ),
            WorkoutDay(
                dayId = 4,
                dayNum = 4,
                workoutPlanId = plan1.planId,
                title = "Rest",
            ),
            WorkoutDay(
                dayId = 5,
                dayNum = 1,
                workoutPlanId = 2,
                title = "Rest",
            )
        )
        listOfDays.forEach {
            createScheduleDao.insertWorkoutDay(it)
        }

        //Initializing list that contains number of exercises per day
        //This will help testing correctness
        countOfExercisesPerDay = MutableList(listOfDays.size){0}

        //Creating test exercises
        listOfExercises = mutableListOf(
            Exercise(
                exerciseId = 1,
                userCreatorId = user1.userId,
                name = "Barbell Squat",
                targetMuscles = "Quads, Glutes"
            ),
            Exercise(
                exerciseId = 2,
                userCreatorId = user1.userId,
                name = "Barbell Bench Press",
                targetMuscles = "Chest"
            ),
            Exercise(
                exerciseId = 3,
                userCreatorId = user1.userId,
                name = "Leg Extension",
                targetMuscles = "Quads"
            )
        )
        listOfExercises.forEach {
            createScheduleDao.insertExercise(it)
        }

        //Inserting the cross ref between exercises and days
        createScheduleDao.insertWorkoutDayExerciseCrossRef(
            WorkoutDayExerciseCrossRef(
                dayId = 3,
                exerciseId = 1
            )
        )
        createScheduleDao.insertWorkoutDayExerciseCrossRef(
            WorkoutDayExerciseCrossRef(
                dayId = 3,
                exerciseId = 3
            )
        )
        countOfExercisesPerDay[2] = 2
        createScheduleDao.insertWorkoutDayExerciseCrossRef(
            WorkoutDayExerciseCrossRef(
                dayId = 1,
                exerciseId = 1
            )
        )
        countOfExercisesPerDay[0] = 1
        createScheduleDao.insertWorkoutDayExerciseCrossRef(
            WorkoutDayExerciseCrossRef(
                dayId = 2,
                exerciseId = 3
            )
        )
        countOfExercisesPerDay[1] = 1
        createScheduleDao.insertWorkoutDayExerciseCrossRef(
            WorkoutDayExerciseCrossRef(
                dayId = 4,
                exerciseId = 1
            )
        )
        countOfExercisesPerDay[3] = 1
        createScheduleDao.insertWorkoutDayExerciseCrossRef(
            WorkoutDayExerciseCrossRef(
                dayId = 5,
                exerciseId = 3
            )
        )
        countOfExercisesPerDay[4] = 1
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
            assertThat(it.exercises.size).isEqualTo(countOfExercisesPerDay[it.workoutDay.dayId.toInt()-1])
        }
    }

    @Test
    fun getUserWithWorkoutPlan() = runTest {
        coreDao.insertUser(User(userId = 2, name = "Kalie", weight = 100f, height = 50f))
        coreDao.insertUser(User(userId = 3, name = "Ivan", weight = 100f, height = 50f))
        createScheduleDao.insertWorkoutPlan(WorkoutPlan(planId = 2, userCreatorId = 2, planName = "Bro Split"))
        createScheduleDao.insertWorkoutPlan(WorkoutPlan(planId = 3, userCreatorId = 1, planName = "Homo Split"))
        val res1 = createScheduleDao.getUserWithWorkoutPlans(id = user1.userId)!!
        val res2 = createScheduleDao.getUserWithWorkoutPlans(id = 2)!!
        assertThat(res1.user).isEqualTo(user1)
        assertThat(res1.workoutPlans.size).isEqualTo(2)
        assertThat(res2.workoutPlans.size).isEqualTo(1)
    }

    @Test
    fun getUserWithExercises() = runTest {
        coreDao.insertUser(User(userId = 2, name = "Kalie", weight = 100f, height = 50f))
        coreDao.insertUser(User(userId = 3, name = "Ivan", weight = 100f, height = 50f))
        createScheduleDao.insertWorkoutPlan(WorkoutPlan(planId = 2, userCreatorId = 2, planName = "Bro Split"))
        createScheduleDao.insertWorkoutPlan(WorkoutPlan(planId = 3, userCreatorId = 1, planName = "Homo Split"))
        val res1 = createScheduleDao.getUserWithExercises(id = user1.userId)

    }
}