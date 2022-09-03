package com.example.liftingtracker.core.views

import androidx.lifecycle.ViewModel
import com.example.leagueapp1.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider
) : ViewModel() {

}