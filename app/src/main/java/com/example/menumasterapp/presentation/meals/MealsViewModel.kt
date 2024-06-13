package com.example.menumasterapp.presentation.meals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.menumasterapp.data.local.MealsDao
import com.example.menumasterapp.data.local.MealsEntity
import com.example.menumasterapp.data.remote.api.body.GenerateRecipesBody
import com.example.menumasterapp.domain.repository.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val mealRepository: MealRepository,
    private val dao: MealsDao,
    private val calendar: Calendar
) : ViewModel() {

    private val _mealsState = MutableStateFlow(MealsState())
    val mealsState: StateFlow<MealsState> get() = _mealsState.asStateFlow()

    init {
        getGeneratedMeals()
    }

    fun generateMeals(mealTypes: List<String>) = viewModelScope.launch {
        try {
            val body = GenerateRecipesBody(39, mealTypes)
            val mealList = mealRepository.generateMeals(body)
            dao.insertDailyMeals(MealsEntity(getDayOfMonth(), mealList))
            _mealsState.value = MealsState(success = true)
        } catch (e : Exception) {
            _mealsState.value = MealsState(error = e.localizedMessage.orEmpty())
        }
    }

    fun getGeneratedMeals() = viewModelScope.launch {
        try {
            val mealsEntity = dao.getDailyMeals(getDayOfMonth())
            _mealsState.value = MealsState(meals = mealsEntity.meals)
        } catch (e : Exception) {
            _mealsState.value = MealsState(error = e.localizedMessage.orEmpty())
        }
    }

    private fun checkDailyMealsExist(): Boolean = dao.checkDailyMealsExist(Calendar.DAY_OF_MONTH)
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