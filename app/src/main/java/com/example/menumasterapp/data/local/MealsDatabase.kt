package com.example.menumasterapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.menumasterapp.constant.Converters

@Database(entities = [MealsEntity::class, ShoppingItemEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract class MealsDatabase: RoomDatabase() {
    abstract fun mealsDao(): MealsDao
    abstract fun shoppingListDao(): ShoppingListDao
}