package com.example.menumasterapp.data.remote.repository

import android.content.SharedPreferences
import com.example.menumasterapp.data.remote.api.MenuMasterApi
import com.example.menumasterapp.data.remote.api.body.GenerateRecipesBody
import com.example.menumasterapp.domain.model.Meal
import com.example.menumasterapp.domain.repository.MealRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val api: MenuMasterApi,
    private val sharedPreferences: SharedPreferences,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MealRepository {
    override suspend fun generateMeals(generateRecipesBody: GenerateRecipesBody): List<Meal> = withContext(ioDispatcher) {
        api.generateMeals("Bearer ${sharedPreferences.getString("access_token", null)}", generateRecipesBody)
    }

    override suspend fun getGeneratedMeals(): List<Meal> = withContext(Dispatchers.IO) {
        api.getGeneratedMeals("Bearer ${sharedPreferences.getString("access_token", null)}")
    }

}