package com.example.menumasterapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShoppingListDao {
    @Insert
    suspend fun addShoppingItems(shoppingItemEntityList: List<ShoppingItemEntity>)

    @Query("SELECT * FROM shopping_items WHERE category = :category")
    suspend fun getShoppingItemsByCategory(category: String): List<ShoppingItemEntity>

}