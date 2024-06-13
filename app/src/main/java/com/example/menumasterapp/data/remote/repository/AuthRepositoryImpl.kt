package com.example.menumasterapp.data.remote.repository

import com.example.menumasterapp.data.remote.api.MenuMasterApi
import com.example.menumasterapp.data.remote.api.body.LoginBody
import com.example.menumasterapp.data.remote.api.response.LoginResponse
import com.example.menumasterapp.domain.model.UserInfo
import com.example.menumasterapp.domain.repository.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: MenuMasterApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AuthRepository {
    override suspend fun loginUser(email: String, password: String): LoginResponse = withContext(ioDispatcher) {
        api.loginUser(LoginBody(email, password))
    }

    override suspend fun registerUser(userInfo: UserInfo): LoginResponse = withContext(ioDispatcher) {
        api.registerUser(userInfo)
    }
}