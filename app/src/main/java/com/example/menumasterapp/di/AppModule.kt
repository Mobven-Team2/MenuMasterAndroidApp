package com.example.menumasterapp.di

import android.content.Context
import android.content.SharedPreferences
import com.example.menumasterapp.constant.Constants
import com.example.menumasterapp.data.remote.api.MenuMasterApi
import com.example.menumasterapp.data.remote.repository.AuthRepositoryImpl
import com.example.menumasterapp.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Calendar
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMenuMasterApi() : MenuMasterApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MenuMasterApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(api : MenuMasterApi) : AuthRepository {
        return AuthRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context) : SharedPreferences {
        return context.getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideCalendar() : Calendar = Calendar.getInstance()

}