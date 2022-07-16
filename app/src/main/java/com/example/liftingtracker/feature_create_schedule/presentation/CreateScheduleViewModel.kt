package com.example.liftingtracker.feature_create_schedule.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutDay


class CreateScheduleViewModel : ViewModel() {

    private var list = mutableListOf<WorkoutDay>()


    private val _sliderState = MutableLiveData<Float>()
    val sliderState: LiveData<Float> = _sliderState

    private val _dayState = MutableLiveData<Int>()
    val dayState: LiveData<Int> = _dayState

    private val _switchState = MutableLiveData<Boolean>()
    val switchState: LiveData<Boolean> = _switchState

    init {
        list = mutableListOf(WorkoutDay(dayNum = 1, workoutPlanId = 0))

        //Retrieve User
    }

    fun getList(): List<WorkoutDay> = list

    fun onChangeDay(dayNum: Int) {
        _dayState.value = dayNum-1
        _switchState.value = list[dayNum-1].isRest
    }

    fun onChangeSlider(value: Float) {
        _sliderState.value = value
    }

    fun onModifyWorkoutDay(workout: WorkoutDay): List<WorkoutDay> {
        list[workout.dayNum-1] = workout
        return list
    }

    fun modifyList(newSize: Int): List<WorkoutDay> {
        val oldSize = list.size
        when{
            newSize > oldSize -> {
                for(i in oldSize+1..newSize) {
                    list.add(WorkoutDay(dayNum = i, workoutPlanId = 0))
                }
            }
            newSize < oldSize -> {
                for(i in oldSize-1 downTo newSize) {
                    list.removeAt(i)
                }
            }
        }
        onChangeDay(list.size)
        return list
    }

    fun onSwitchRest(state: Boolean) {
        _switchState.value = state
        val workout = list[dayState.value ?: 0]
        list[dayState.value ?: 0] = workout.copy(isRest = state)
    }
}