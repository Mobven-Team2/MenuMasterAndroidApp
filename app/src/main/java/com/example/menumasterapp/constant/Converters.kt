package com.example.menumasterapp.constant

import androidx.room.TypeConverter
import com.example.menumasterapp.domain.model.Meal
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromMealList(value: List<Meal>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Meal>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toMealList(value: String): List<Meal> {
        val gson = Gson()
        val type = object : TypeToken<List<Meal>>() {}.type
        return gson.fromJson(value, type)
    }
}