package com.example.menumasterapp.presentation.meal_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.menumasterapp.data.local.MealsDao
import com.example.menumasterapp.data.local.ShoppingItemEntity
import com.example.menumasterapp.data.local.ShoppingListDao
import com.example.menumasterapp.domain.repository.MealRepository
import com.example.menumasterapp.presentation.meals.MealsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class MealDetailViewModel @Inject constructor(
    private val mealsDao: MealsDao,
    private val shoppingListDao: ShoppingListDao,
    private val calendar: Calendar
) : ViewModel() {

    private val _mealsState = MutableStateFlow(MealsState())
    val mealsState: StateFlow<MealsState> get() = _mealsState.asStateFlow()

    init {
        fetchGeneratedMeals()
    }

    private fun fetchGeneratedMeals() = viewModelScope.launch {
        try {
            val mealEntity = mealsDao.getDailyMeals(getDayOfMonth())
            _mealsState.value = MealsState(meals = mealEntity.meals)
        } catch (e : Exception) {
            _mealsState.value = MealsState(error = e.localizedMessage.orEmpty())
        }
    }

    fun addShoppingList(category: String, shoppingList: List<String>) = viewModelScope.launch {
        val shoppingItemList = shoppingList.map { ShoppingItemEntity(category = category, name = it) }
        shoppingListDao.addShoppingItems(shoppingItemList)
    }

    private fun getDayOfMonth(): Int = calendar.get(Calendar.DAY_OF_MONTH)

}