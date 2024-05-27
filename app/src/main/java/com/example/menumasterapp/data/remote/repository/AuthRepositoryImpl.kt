package com.example.menumasterapp.data.remote.repository

import com.example.menumasterapp.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override suspend fun loginUser(email: String, password: String): Result<String> {
        return try {
            Result.success("Login successfully")
        } catch (e : Exception) {
            Result.failure(e)
        }
    }

    override suspend fun registerUser(name: String, email: String, password: String): Result<String> {
        return try {
            Result.success("Register successfully")
        } catch (e : Exception) {
            Result.failure(e)
        }
    }
}