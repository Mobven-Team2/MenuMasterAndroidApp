package com.example.menumasterapp.presentation.auth.register

data class RegisterFormState(
    val successful: Boolean = false,
    val nameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val repeatedPasswordError: String? = null
)
