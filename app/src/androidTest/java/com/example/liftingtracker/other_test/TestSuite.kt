package com.example.liftingtracker.other_test

import com.example.liftingtracker.core.domain.dao.CoreDaoTest
import com.example.liftingtracker.feature_create_schedule.domain.dao.CreateScheduleDaoTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite

@ExperimentalCoroutinesApi
@RunWith(Suite::class)
@Suite.SuiteClasses(
    CreateScheduleDaoTest::class,
    CoreDaoTest::class,
    TestDaoNullability::class
)
class TestSuite