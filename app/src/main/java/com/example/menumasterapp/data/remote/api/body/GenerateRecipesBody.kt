package com.example.menumasterapp.data.remote.api.body

data class GenerateRecipesBody(
    val id: Int,
    val mealTypes: List<String>
)