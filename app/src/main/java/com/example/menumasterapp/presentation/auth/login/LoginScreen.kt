package com.example.menumasterapp.presentation.auth.login

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.menumasterapp.presentation.auth.component.CustomButton
import com.example.menumasterapp.presentation.auth.component.CustomPasswordTextField
import com.example.menumasterapp.presentation.auth.component.CustomTextField
import com.example.menumasterapp.presentation.root.Screen
import com.example.menumasterapp.presentation.ui.theme.LightBlack
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state by viewModel.loginState.collectAsState()
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    LaunchedEffect(key1 = state) {
        if (state.success.isNotEmpty())
            Toast.makeText(context, state.success, Toast.LENGTH_SHORT).show()
        else if (state.error.isNotEmpty())
            Toast.makeText(context, state.error, Toast.LENGTH_SHORT).show()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
    ) {
        Text(text = "Giriş Yap", style = Typography.titleLarge)
        Spacer(modifier = Modifier.height(10.dp))
        CustomTextField(
            text = email,
            onChangeText = { email = it },
            labelText = "E-posta"
        )
        CustomPasswordTextField(
            text = password,
            onChangeText = { password = it },
            labelText = "Şifre"
        )
        Text(
            text = "Şifreni mi Unuttun?",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            style = Typography.bodySmall,
            color = LightBlack,
            textDecoration = TextDecoration.Underline
        )
        CustomButton(
            text = "Giriş Yap",
            onButtonClick = {  viewModel.login(email, password) }
        )
        Row {
            Text(
                text = "Hesabın yok mu? ",
                style = Typography.titleSmall
            )
            Text(
                text = "Kaydol",
                textDecoration = TextDecoration.Underline,
                style = Typography.titleSmall,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.Register.route)
                }
            )
        }
        Text(
            text = "Şartlar & Koşullar ve Gizlilik Politikası",
            style = Typography.bodySmall,
            textDecoration = TextDecoration.Underline
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevLoginScreen() {
    LoginScreen(rememberNavController())
}