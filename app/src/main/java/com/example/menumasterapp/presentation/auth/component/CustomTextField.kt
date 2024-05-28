package com.example.menumasterapp.presentation.auth.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.R
import com.example.menumasterapp.presentation.ui.theme.Grey
import com.example.menumasterapp.presentation.ui.theme.Primary
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    onChangeText: (String) -> Unit,
    labelText: String,
    errorMessage: String? = null,
    shape: Shape = RoundedCornerShape(10.dp),
    textStyle: TextStyle = Typography.bodyMedium
) {
    val isError = errorMessage != null
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
            singleLine = true,
            isError = isError,
            trailingIcon = {
                if (isError)
                    Icon(
                        painter = painterResource(id = R.drawable.warning),
                        contentDescription = "warning_icon"
                    )
            },
            keyboardOptions = KeyboardOptions(keyboardType = if (labelText == "E-posta") KeyboardType.Email else KeyboardType.Text)
        )
        if (isError)
            Text(text = errorMessage ?: "", style = Typography.bodySmall, color = MaterialTheme.colorScheme.error)
    }
}