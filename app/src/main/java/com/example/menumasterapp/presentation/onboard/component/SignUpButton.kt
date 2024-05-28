package com.example.menumasterapp.presentation.onboard.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.presentation.ui.theme.Primary
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun SignUpButton(
    onButtonClick: () -> Unit,
) {
    OutlinedButton(
        onClick = { onButtonClick() },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Primary.copy(0.15f),
            contentColor = Primary
        ),
        border = BorderStroke(
            width = 1.dp,
            color = Primary
        ),
        contentPadding = PaddingValues(vertical = 15.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = "Kaydol", style = Typography.bodyMedium)
    }
}