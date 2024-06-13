package com.example.menumasterapp.presentation.meals.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.menumasterapp.presentation.auth.component.CustomButton
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun SuccessDialog(
    title: String,
    description: String,
    onSeeMealButtonClick: () -> Unit,
    onDismiss: () -> Unit,
) {
    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Card(
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = title,
                    style = Typography.titleMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = description,
                    style = Typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomButton(
                    text = "Öğünleri Gör",
                    onButtonClick = { onSeeMealButtonClick() }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevSuccessDialog() {
    SuccessDialog(
        title = "Öğünler Oluşturuldu!",
        description = "Seçtiğiniz öğünler başarıyla oluşturuldu! Tariflerinize göz atabilirsiniz.",
        onSeeMealButtonClick = { },
        onDismiss = { }
    )
}