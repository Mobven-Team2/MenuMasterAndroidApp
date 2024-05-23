package com.example.menumasterapp.presentation.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.presentation.auth.components.CustomButton
import com.example.menumasterapp.presentation.auth.components.CustomPasswordTextField
import com.example.menumasterapp.presentation.auth.components.CustomTextField
import com.example.menumasterapp.ui.theme.Background
import com.example.menumasterapp.ui.theme.LightBlack
import com.example.menumasterapp.ui.theme.Primary
import com.example.menumasterapp.ui.theme.Typography

@Composable
fun RegisterScreen() {
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordAgain by rememberSaveable { mutableStateOf("") }
    var checked by rememberSaveable { mutableStateOf(false) }
    var registerButtonClicked by rememberSaveable { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = "Kaydol", style = Typography.titleLarge)
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                text = name,
                onChangeText = { name = it },
                labelText = "İsim Soyisim",
                errorState = registerButtonClicked && name.isEmpty()
            )
            CustomTextField(
                text = email,
                onChangeText = { email = it },
                labelText = "E-posta",
                errorState = registerButtonClicked && email.isEmpty()
            )
            CustomPasswordTextField(
                text = password,
                onChangeText = { password = it },
                labelText = "Şifre",
                errorState = registerButtonClicked && (password != passwordAgain || password.isEmpty() || passwordAgain.isEmpty())
            )
            CustomPasswordTextField(
                text = passwordAgain,
                onChangeText = { passwordAgain = it },
                labelText = "Şifre tekrar"
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    colors = CheckboxDefaults.colors(checkedColor = Primary)
                )
                Text(
                    text = "Şartlar & Koşullar ve Gizlilik Politikasını kabul ediyorum.",
                    style = Typography.bodySmall,
                    color = LightBlack
                )
            }
            CustomButton(
                text = "Hesap Oluştur",
                onButtonClick = { if (!registerButtonClicked) registerButtonClicked = true }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevRegisterScreen() {
    RegisterScreen()
}