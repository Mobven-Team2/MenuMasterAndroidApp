package com.example.menumasterapp.presentation.auth.register

import android.util.Patterns
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
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _registerState = MutableStateFlow(AuthState())
    val registerState: StateFlow<AuthState> get() = _registerState

    private val _registerFormState = MutableStateFlow(RegisterFormState())
    val registerFormState: StateFlow<RegisterFormState> get() = _registerFormState

    fun register(name: String, email: String, password: String) = viewModelScope.launch {
        authRepository.registerUser(name, email, password).onSuccess {
            _registerState.value = AuthState(success = it)
        }.onFailure {
            _registerState.value = AuthState(error = it.localizedMessage.orEmpty())
        }
    }

    fun submitValidation(name: String, email: String, password: String, repeatedPassword: String) {
        val nameResult = validateName(name)
        val emailResult = validateEmail(email)
        val passwordResult = validatePassword(password)
        val repeatedPasswordResult = validateRepeatedPassword(password, repeatedPassword)
        val hasError = listOf(
            nameResult,
            emailResult,
            passwordResult,
            repeatedPasswordResult
        ).any { !it.isSuccess }
        if (hasError)
            _registerFormState.value = RegisterFormState(
                nameError = nameResult.errorMessage,
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatedPasswordError = repeatedPasswordResult.errorMessage
            )
        else
            _registerFormState.value = RegisterFormState(successful = true)
    }

    private fun validateName(name: String): ValidationResult {
        return if (name.length < 5 || name.length > 24)
            ValidationResult(errorMessage = "Lütfen geçerli bir isim soyisim giriniz")
        else
            ValidationResult(isSuccess = true)
    }

    private fun validateEmail(email: String): ValidationResult {
        return if (Patterns.EMAIL_ADDRESS.matcher(email).matches().not())
            ValidationResult(errorMessage = "Lütfen geçerli bir e-posta adresi giriniz")
        else
            ValidationResult(isSuccess = true)
    }

    private fun validatePassword(password: String): ValidationResult {
        return if (password.length < 6)
            ValidationResult(errorMessage = "Şifre en az 6 karakterden oluşmalıdır")
        else
            ValidationResult(isSuccess = true)
    }

    private fun validateRepeatedPassword(password: String, repeatedPassword: String): ValidationResult {
        return if (password != repeatedPassword)
            ValidationResult(errorMessage = "Girdiğiniz şifreler uyuşmuyor. Tekrar deneyiniz")
        else
            ValidationResult(isSuccess = true)
    }

}