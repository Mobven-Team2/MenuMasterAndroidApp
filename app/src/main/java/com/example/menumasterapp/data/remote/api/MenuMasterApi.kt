package com.example.menumasterapp.data.remote.api

import com.example.menumasterapp.data.remote.api.body.LoginBody
import com.example.menumasterapp.data.remote.api.body.RegisterBody
import com.example.menumasterapp.data.remote.api.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface MenuMasterApi {

    @POST("User/Register")
    suspend fun registerUser(@Body registerBody : RegisterBody)

    @POST("User/Login")
    suspend fun loginUser(@Body loginBody : LoginBody): LoginResponse
}