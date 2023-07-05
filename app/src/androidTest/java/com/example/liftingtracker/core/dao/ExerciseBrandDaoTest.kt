package com.example.liftingtracker.core.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.liftingtracker.buildBrand
import com.example.liftingtracker.buildExercise
import com.example.liftingtracker.core.data.local.DatabaseHelper
import com.example.liftingtracker.core.models.Exercise
import com.example.liftingtracker.core.models.ExerciseBrandCrossRef
import com.example.liftingtracker.createDB
import com.example.liftingtracker.di.TestModules
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import java.util.*
import kotlin.test.assertNotEquals

@OptIn(ExperimentalCoroutinesApi::class)
class ExerciseBrandDaoTest  {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var db : DatabaseHelper

    private lateinit var exerciseDao: ExerciseDao
    private lateinit var brandDao: BrandDao
    private lateinit var exerciseBrandCrossRefDao: ExerciseBrandCrossRefDao

    @Before
    fun setup() {
        db = createDB()
        exerciseDao = db.exerciseDao()
        brandDao = db.brandDao()
        exerciseBrandCrossRefDao = db.exerciseBrandCrossRefDao()
    }

    @Test
    fun nonEmptyResult() = runTest{
        val exercise1 = buildExercise(exerciseId = "0")
        val brand1 = buildBrand(brandId = "1")
        val cross = ExerciseBrandCrossRef(
            exerciseId = exercise1.exerciseId,
            brandId = brand1.brandId
        )

        exerciseDao.insertExercise(exercise1)
        brandDao.insertBrand(brand1)
        exerciseBrandCrossRefDao.insertExerciseBrandCrossRef(cross)

        val actual = brandDao.loadBrandsWithExercises()

        assertThat(actual).isNotEmpty()
    }

    @Test
    fun returnsCorrectList() = runTest{
        val exercise1 = buildExercise(exerciseId = "0")
        val exercise2 = buildExercise(exerciseId = "2")
        val brand1 = buildBrand(brandId = "1")

        exerciseDao.insertExercise(exercise1)
        exerciseDao.insertExercise(exercise2)
        brandDao.insertBrand(brand1)

        exerciseBrandCrossRefDao.insertExerciseBrandCrossRef(ExerciseBrandCrossRef(
            exerciseId = exercise1.exerciseId,
            brandId = brand1.brandId
        ))
        exerciseBrandCrossRefDao.insertExerciseBrandCrossRef(ExerciseBrandCrossRef(
            exerciseId = exercise2.exerciseId,
            brandId = brand1.brandId
        ))

        exerciseDao.insertExercise(buildExercise())
        exerciseDao.insertExercise(buildExercise())
        exerciseDao.insertExercise(buildExercise())

        brandDao.insertBrand(buildBrand())
        brandDao.insertBrand(buildBrand())
        brandDao.insertBrand(buildBrand())

        val actual = brandDao.loadBrandsWithExercises()

        assertThat(actual.keys).containsExactly(brand1)
        assertThat(actual.values).containsExactly(listOf(exercise1,exercise2))
    }
}