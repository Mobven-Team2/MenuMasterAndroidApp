package com.example.menumasterapp.data.remote.api

import com.example.menumasterapp.data.remote.api.body.GenerateRecipesBody
import com.example.menumasterapp.data.remote.api.body.LoginBody
import com.example.menumasterapp.data.remote.api.response.LoginResponse
import com.example.menumasterapp.domain.model.Meal
import com.example.menumasterapp.domain.model.UserInfo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MenuMasterApi {

    @POST("User/Register")
    suspend fun registerUser(@Body userInfo: UserInfo) : LoginResponse

    @POST("User/Login")
    suspend fun loginUser(@Body loginBody : LoginBody): LoginResponse

    @POST("User/PostRecipes")
    suspend fun generateMeals(@Header("Authorization") accessToken: String, @Body generateRecipesBody: GenerateRecipesBody): List<Meal>

    @GET("User/GetSavedRecipes")
    suspend fun getGeneratedMeals(@Header("Authorization") accessToken: String, @Query("Id") id : Int = 30) : List<Meal>

}