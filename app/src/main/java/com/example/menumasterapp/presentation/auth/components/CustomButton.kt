package com.example.menumasterapp.presentation.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.menumasterapp.ui.theme.Primary
import com.example.menumasterapp.ui.theme.Typography

@Composable
fun CustomButton(
    text: String,
    onButtonClick: () -> Unit
) {
    Button(
        onClick = { onButtonClick() },
        colors = ButtonDefaults.buttonColors(containerColor = Primary),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text, style = Typography.bodyMedium)
    }
}