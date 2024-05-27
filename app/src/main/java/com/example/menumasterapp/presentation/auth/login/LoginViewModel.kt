package com.example.menumasterapp.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.menumasterapp.data.remote.repository.AuthRepositoryImpl
import com.example.menumasterapp.domain.repository.AuthRepository
import com.example.menumasterapp.presentation.auth.AuthState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository = AuthRepositoryImpl()
) : ViewModel() {

    private val _loginState = MutableStateFlow(AuthState())
    val loginState : StateFlow<AuthState> get() =  _loginState

    fun login(email: String, password: String) = viewModelScope.launch {
        authRepository.loginUser(email, password).onSuccess {
            _loginState.value = AuthState(success = it)
        }.onFailure {t ->
            _loginState.value = AuthState(error = t.localizedMessage.orEmpty())
        }
    }

}