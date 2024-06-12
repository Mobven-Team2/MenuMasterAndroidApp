package com.example.menumasterapp.presentation.auth.register

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.menumasterapp.domain.model.UserInfo
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

    private val _userInfo = mutableStateOf(UserInfo())

    private val _registerState = MutableStateFlow(AuthState())
    val registerState: StateFlow<AuthState> get() = _registerState

    private val _registerFormState = MutableStateFlow(RegisterFormState())
    val registerFormState: StateFlow<RegisterFormState> get() = _registerFormState

    fun register() = viewModelScope.launch {
        try {
            println(_userInfo)
            authRepository.registerUser(_userInfo.value)
            _registerState.value = AuthState(success = true)
        } catch (e : Exception) {
            _registerState.value = AuthState(error = e.localizedMessage.orEmpty())
        }
    }

    fun applyPersonalInformation(age : Int, weight : Int, height : Int, gender : String, activityStatus : String) {
        val newUserInfo = _userInfo.value.copy(
            age = age,
            weight = weight,
            height = height,
            gender = gender,
            activityStatus = activityStatus
        )
        _userInfo.value = newUserInfo
    }

    fun applyDietType(dietTypes: List<String>) {
        val newUserInfo = _userInfo.value.copy(dietTypes = dietTypes)
        _userInfo.value = newUserInfo
    }

    fun applyCuisineNames(cuisines : List<String>) {
        val newUserInfo = _userInfo.value.copy(cuisineNames = cuisines)
        _userInfo.value = newUserInfo
    }

    fun applyEmailPassword(name: String, email: String, password: String, passwordConfirm: String) {
        val newUserInfo = _userInfo.value.copy(
            fullName = name,
            email = email,
            password = password,
            passwordConfirm = passwordConfirm
        )
        _userInfo.value = newUserInfo
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