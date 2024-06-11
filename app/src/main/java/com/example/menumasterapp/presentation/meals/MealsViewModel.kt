package com.example.menumasterapp.presentation.meals

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val calendar: Calendar
) : ViewModel() {

    fun getDayOfMonth(): Int = calendar.get(Calendar.DAY_OF_MONTH)
    fun getDayList(): List<Day> {
        val dayList = mutableListOf<Day>()
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val dayFormat = DateTimeFormatter.ofPattern("EEE", Locale("tr", "TR"))
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        for (date in 1..daysInMonth) {
            val localDate = LocalDate.of(year, month, date)
            val dayOfWeekName = localDate.format(dayFormat)
            dayList.add(Day(dayOfWeekName, date))
        }
        return dayList
    }
}

data class Day(
    val name: String,
    val date: Int
)