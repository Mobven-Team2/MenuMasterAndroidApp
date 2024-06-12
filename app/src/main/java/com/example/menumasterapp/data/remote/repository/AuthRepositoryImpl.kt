package com.example.menumasterapp.data.remote.repository

import com.example.menumasterapp.data.remote.api.MenuMasterApi
import com.example.menumasterapp.data.remote.api.body.LoginBody
import com.example.menumasterapp.data.remote.api.response.LoginResponse
import com.example.menumasterapp.domain.model.UserInfo
import com.example.menumasterapp.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: MenuMasterApi
) : AuthRepository {
    override suspend fun loginUser(email: String, password: String): LoginResponse {
        return api.loginUser(LoginBody(email, password))
    }

    override suspend fun registerUser(userInfo: UserInfo): LoginResponse {
        return api.registerUser(userInfo)
    }
}