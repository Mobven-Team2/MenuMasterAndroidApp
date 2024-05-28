package com.example.menumasterapp.domain.repository

interface AuthRepository {

    suspend fun loginUser(email: String, password: String): Result<String>

    suspend fun registerUser(name: String, email: String, password: String): Result<String>

}