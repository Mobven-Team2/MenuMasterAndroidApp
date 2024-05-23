package com.example.menumasterapp.presentation.auth.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.R
import com.example.menumasterapp.ui.theme.Primary
import com.example.menumasterapp.ui.theme.Typography

@Composable
fun CustomPasswordTextField(
    text: String,
    onChangeText: (String) -> Unit,
    labelText: String,
    errorState: Boolean = false
) {
    val borderColor = if (!errorState) Color.Transparent else Color.Red
    var passwordVisibility by remember { mutableStateOf(false) }
    val icon: Painter = if (passwordVisibility)
        painterResource(id = R.drawable.visibility_on)
    else
        painterResource(id = R.drawable.visibility_off)
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
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "visibility_icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            singleLine = true
        )
        if (errorState)
            WarningPart(warningLabel = labelText)
    }
}