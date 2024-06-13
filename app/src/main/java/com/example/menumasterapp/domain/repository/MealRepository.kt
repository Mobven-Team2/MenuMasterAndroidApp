package com.example.menumasterapp.domain.repository

import com.example.menumasterapp.data.remote.api.body.GenerateRecipesBody
import com.example.menumasterapp.domain.model.Meal

interface MealRepository {

    suspend fun generateMeals(generateRecipesBody: GenerateRecipesBody): List<Meal>

    suspend fun getGeneratedMeals() : List<Meal>

}