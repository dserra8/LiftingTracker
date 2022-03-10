package com.example.liftingtracker.feature_create_schedule.presentation

import androidx.lifecycle.ViewModel
import com.example.liftingtracker.adapter.CreateScheduleItem
import dagger.hilt.android.lifecycle.HiltViewModel


class CreateScheduleViewModel : ViewModel() {

    val dayMap = hashMapOf<Int, List<String>>()

    fun onClickDay(day: CreateScheduleItem) {

    }

}