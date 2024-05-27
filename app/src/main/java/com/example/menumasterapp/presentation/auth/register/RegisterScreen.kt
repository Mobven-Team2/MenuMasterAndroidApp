package com.example.menumasterapp.presentation.auth.register

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.menumasterapp.presentation.auth.component.CustomButton
import com.example.menumasterapp.presentation.auth.component.CustomPasswordTextField
import com.example.menumasterapp.presentation.auth.component.CustomTextField
import com.example.menumasterapp.presentation.auth.register.component.AcceptedTermsSection
import com.example.menumasterapp.presentation.root.Screen
import com.example.menumasterapp.ui.theme.Typography

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = viewModel()
) {
    val state by viewModel.registerState.collectAsState()
    val registerFormState by viewModel.registerFormState.collectAsState()
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordAgain by rememberSaveable { mutableStateOf("") }
    var termsChecked by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current
    LaunchedEffect(key1 = registerFormState.successful) {
        if (registerFormState.successful)
            viewModel.register(name, email, password)
    }
    LaunchedEffect(key1 = state) {
        if (state.success.isNotEmpty()) {
            Toast.makeText(context, state.success, Toast.LENGTH_SHORT).show()
            navController.navigate(Screen.Login.route)
        } else if (state.error.isNotEmpty()) {
            Toast.makeText(context, state.error, Toast.LENGTH_SHORT).show()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
    ) {
        Text(text = "Kaydol", style = Typography.titleLarge)
        Spacer(modifier = Modifier.height(20.dp))
        CustomTextField(
            text = name,
            onChangeText = { name = it },
            labelText = "İsim Soyisim",
            errorMessage = registerFormState.nameError
        )
        CustomTextField(
            text = email,
            onChangeText = { email = it },
            labelText = "E-posta",
            errorMessage = registerFormState.emailError
        )
        CustomPasswordTextField(
            text = password,
            onChangeText = { password = it },
            labelText = "Şifre",
            errorMessage = registerFormState.passwordError
        )
        CustomPasswordTextField(
            text = passwordAgain,
            onChangeText = { passwordAgain = it },
            labelText = "Şifre tekrar",
            errorMessage = registerFormState.repeatedPasswordError
        )
        Spacer(modifier = Modifier.height(20.dp))
        AcceptedTermsSection(
            checked = termsChecked,
            onCheckedChange = { termsChecked = it }
        )
        CustomButton(
            text = "Hesap Oluştur",
            enabled = name.isNotBlank() && email.isNotBlank() && password.isNotBlank() && passwordAgain.isNotBlank() && termsChecked,
            onButtonClick = {
                viewModel.submitValidation(name, email, password, passwordAgain)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevRegisterScreen() {
    RegisterScreen(rememberNavController())
}