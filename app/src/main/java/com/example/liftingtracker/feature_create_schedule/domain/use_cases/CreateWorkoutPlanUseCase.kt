package com.example.liftingtracker.feature_create_schedule.domain.use_cases

import com.example.liftingtracker.core.domain.dao.CoreDao
import com.example.liftingtracker.feature_create_schedule.domain.dao.CreateScheduleDao
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutPlan

class CreateWorkoutPlanUseCase(
    private val coreDao: CoreDao,
    private val createScheduleDao: CreateScheduleDao
) {

    suspend operator fun invoke(planName: String) {
        val user = coreDao.getUser()!!
        createScheduleDao.insertWorkoutPlan(WorkoutPlan(userCreatorId = user.userId, planName = planName))
    }


}