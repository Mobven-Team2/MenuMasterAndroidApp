package com.example.menumasterapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.menumasterapp.domain.model.Meal

@Entity(tableName = "meal_table")
data class MealsEntity(
    @PrimaryKey
    val date: Int,
    val meals: List<Meal>
)
