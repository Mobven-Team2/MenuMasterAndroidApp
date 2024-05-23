package com.example.menumasterapp.presentation.auth.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.ui.theme.Primary
import com.example.menumasterapp.ui.theme.Typography

@Composable
fun CustomTextField(
    text: String,
    onChangeText: (String) -> Unit,
    labelText: String,
    errorState: Boolean = false
) {
    val borderColor = if (!errorState) Color.Transparent else Color.Red
    Column {
        OutlinedTextField(
            value = text,
            onValueChange = { onChangeText(it) },
            shape = RoundedCornerShape(25.dp),
            label = { Text(labelText, style = Typography.titleSmall) },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Primary,
                unfocusedBorderColor = borderColor,
                focusedLabelColor = Color.Black
            ),
            textStyle = Typography.bodyMedium,
            singleLine = true
        )
        if (errorState)
            WarningPart(warningLabel = labelText)
    }
}