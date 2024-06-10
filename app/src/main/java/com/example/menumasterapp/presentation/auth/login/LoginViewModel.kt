package com.example.menumasterapp.presentation.auth.login

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.menumasterapp.domain.repository.AuthRepository
import com.example.menumasterapp.presentation.auth.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    private val _loginState = MutableStateFlow(AuthState())
    val loginState : StateFlow<AuthState> get() =  _loginState

    fun login(email: String, password: String) = viewModelScope.launch {
        try {
            val response = authRepository.loginUser(email, password)
            sharedPreferences.edit().putString("access_token", response.accessToken).apply()
            _loginState.value = AuthState(success = true)
        } catch (e: Exception) {
            _loginState.value = AuthState(error = e.localizedMessage.orEmpty())
            println(e.message)
        }
    }

}