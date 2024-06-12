package com.example.menumasterapp.domain.repository

import com.example.menumasterapp.data.remote.api.response.LoginResponse
import com.example.menumasterapp.domain.model.UserInfo

interface AuthRepository {

    suspend fun loginUser(email: String, password: String): LoginResponse

    suspend fun registerUser(userInfo: UserInfo): LoginResponse

}