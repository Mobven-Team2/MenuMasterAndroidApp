package com.example.menumasterapp.domain.repository

import com.example.menumasterapp.data.remote.api.response.LoginResponse

interface AuthRepository {

    suspend fun loginUser(email: String, password: String): LoginResponse

    suspend fun registerUser(name: String, email: String, password: String): Result<String>

}