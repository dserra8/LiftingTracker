package com.example.baseproject.core.presentation

import androidx.lifecycle.ViewModel
import com.example.leagueapp1.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider
) : ViewModel() {

}