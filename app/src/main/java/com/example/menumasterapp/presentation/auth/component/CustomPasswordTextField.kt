package com.example.menumasterapp.presentation.auth.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.R
import com.example.menumasterapp.presentation.ui.theme.Grey
import com.example.menumasterapp.presentation.ui.theme.Primary
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun CustomPasswordTextField(
    modifier: Modifier = Modifier,
    text: String,
    onChangeText: (String) -> Unit,
    labelText: String,
    errorMessage: String? = null,
    shape: Shape = RoundedCornerShape(10.dp),
    textStyle: TextStyle = Typography.bodyMedium,
) {
    val isError = errorMessage != null
    var passwordVisibility by remember { mutableStateOf(false) }
    val icon: Painter = if (passwordVisibility)
        painterResource(id = R.drawable.visibility_on)
    else
        painterResource(id = R.drawable.visibility_off)
    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(labelText, style = Typography.titleSmall)
        OutlinedTextField(
            value = text,
            onValueChange = { onChangeText(it) },
            shape = shape,
            modifier = modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Grey,
                focusedBorderColor = Primary,
                unfocusedBorderColor = Color.Transparent
            ),
            textStyle = textStyle,
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
            singleLine = true,
            isError = isError
        )
        if (isError)
            Text(text = errorMessage ?: "", style = Typography.bodySmall, color = MaterialTheme.colorScheme.error)
    }
}