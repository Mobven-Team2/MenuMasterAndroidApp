package com.example.menumasterapp.data.remote.api

import com.example.menumasterapp.data.remote.api.body.LoginBody
import com.example.menumasterapp.data.remote.api.response.LoginResponse
import com.example.menumasterapp.domain.model.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST

interface MenuMasterApi {

    @POST("User/Register")
    suspend fun registerUser(@Body userInfo: UserInfo) : LoginResponse

    @POST("User/Login")
    suspend fun loginUser(@Body loginBody : LoginBody): LoginResponse
}