package com.example.menumasterapp.presentation.auth.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.presentation.ui.theme.Primary
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun CustomButton(
    text: String,
    onButtonClick: () -> Unit,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Primary,
        disabledContainerColor = Primary.copy(alpha = 0.5f),
        disabledContentColor = Color.White
    )
) {
    Button(
        onClick = { onButtonClick() },
        colors = colors,
        modifier = Modifier.fillMaxWidth(),
        enabled = enabled,
        contentPadding = PaddingValues(vertical = 15.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = text, style = Typography.bodyMedium)
    }
}