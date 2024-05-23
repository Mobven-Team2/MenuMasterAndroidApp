package com.example.menumasterapp.presentation.auth.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.menumasterapp.R
import com.example.menumasterapp.ui.theme.Typography

@Composable
fun WarningPart(
    warningLabel: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.warning),
            contentDescription = "warning_icon",
            tint = Color.Red
        )
        Text(
            text = if (warningLabel != "Şifre") "Lütfen geçerli bir $warningLabel giriniz" else "Girdiğiniz şifreler uyuşmuyor. Tekrar deneyiniz.",
            color = Color.Red,
            style = Typography.bodySmall
        )
    }
}