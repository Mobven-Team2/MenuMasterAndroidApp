package com.example.menumasterapp.presentation.auth.register

data class ValidationResult(
    val isSuccess: Boolean = false,
    val errorMessage: String? = null
)
