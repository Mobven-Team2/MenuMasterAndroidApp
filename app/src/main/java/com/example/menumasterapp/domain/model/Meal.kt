package com.example.menumasterapp.domain.model


import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("ingredients")
    val ingredients: List<String>?,
    @SerializedName("isLiked")
    val isLiked: Boolean?,
    @SerializedName("mealType")
    val mealType: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("recipe")
    val recipe: String?
)