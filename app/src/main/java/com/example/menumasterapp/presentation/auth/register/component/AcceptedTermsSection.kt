package com.example.menumasterapp.presentation.auth.register.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.menumasterapp.ui.theme.LightBlack
import com.example.menumasterapp.ui.theme.Primary
import com.example.menumasterapp.ui.theme.Typography

@Composable
fun AcceptedTermsSection(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange(it) },
            colors = CheckboxDefaults.colors(checkedColor = Primary)
        )
        Text(
            text = "Şartlar & Koşullar ve Gizlilik Politikasını kabul ediyorum.",
            style = Typography.bodySmall,
            color = LightBlack
        )
    }
}