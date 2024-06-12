package com.example.menumasterapp.domain.model


import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("activityStatus")
    val activityStatus: String? = null,
    @SerializedName("age")
    val age: Int? = null,
    @SerializedName("cuisineNames")
    val cuisineNames: List<String>? = null,
    @SerializedName("dietTypes")
    val dietTypes: List<String>? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("fullName")
    val fullName: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("passwordConfirm")
    val passwordConfirm: String? = null,
    @SerializedName("weight")
    val weight: Int? = null
)