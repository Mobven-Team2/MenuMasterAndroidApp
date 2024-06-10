package com.example.menumasterapp.data.remote.api.body

data class RegisterBody(
    val activityStatus: String,
    val age: Int,
    val cuisineNames: List<String>,
    val dietTypes: List<String>,
    val email: String,
    val fullName: String,
    val gender: String,
    val height: Int,
    val password: String,
    val passwordConfirm: String,
    val weight: Int
)