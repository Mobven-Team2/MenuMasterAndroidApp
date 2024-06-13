package com.example.menumasterapp.presentation.meals

import com.example.menumasterapp.domain.model.Meal

data class MealsState(
    val success: Boolean = false,
    val meals: List<Meal> = listOf(),
    val error: String = ""
)
