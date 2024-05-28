package com.example.menumasterapp.di

import com.example.menumasterapp.data.remote.repository.AuthRepositoryImpl
import com.example.menumasterapp.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthRepository() : AuthRepository {
        return AuthRepositoryImpl()
    }

}