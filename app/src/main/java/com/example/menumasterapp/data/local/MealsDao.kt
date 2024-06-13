package com.example.menumasterapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MealsDao {
    @Insert
    suspend fun insertDailyMeals(mealsEntity: MealsEntity)

    @Query("SELECT * FROM meal_table WHERE date = :date")
    suspend fun getDailyMeals(date: Int): MealsEntity

    @Query("SELECT EXISTS(SELECT * FROM meal_table WHERE date = :date)")
    fun checkDailyMealsExist(date: Int) : Boolean


}