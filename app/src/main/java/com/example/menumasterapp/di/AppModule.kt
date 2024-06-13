package com.example.menumasterapp.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.menumasterapp.constant.Constants
import com.example.menumasterapp.data.local.MealsDao
import com.example.menumasterapp.data.local.MealsDatabase
import com.example.menumasterapp.data.local.ShoppingListDao
import com.example.menumasterapp.data.remote.api.MenuMasterApi
import com.example.menumasterapp.data.remote.repository.AuthRepositoryImpl
import com.example.menumasterapp.data.remote.repository.MealRepositoryImpl
import com.example.menumasterapp.domain.repository.AuthRepository
import com.example.menumasterapp.domain.repository.MealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
            .client(OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
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
    fun provideMealRepository(api : MenuMasterApi, sharedPreferences: SharedPreferences) : MealRepository {
        return MealRepositoryImpl(api, sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideMealsDatabase(@ApplicationContext context: Context) : MealsDatabase {
        return Room.databaseBuilder(context, MealsDatabase::class.java, "universities").allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideMealsDao(mealsDatabase: MealsDatabase) : MealsDao {
        return mealsDatabase.mealsDao()
    }

    @Provides
    @Singleton
    fun provideShoppingListDao(mealsDatabase: MealsDatabase) : ShoppingListDao {
        return mealsDatabase.shoppingListDao()
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