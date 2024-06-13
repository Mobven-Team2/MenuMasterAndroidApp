package com.example.menumasterapp.presentation.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val calendar: Calendar
) : ViewModel() {
    fun getHourOfDay() : Int = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
}