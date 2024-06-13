package com.example.menumasterapp.presentation.meal_detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.presentation.ui.theme.DarkGreen
import com.example.menumasterapp.presentation.ui.theme.LightGreen
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun IngredientItem(
    text: String,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) LightGreen else Color.White)
            .clickable { onClick() }
            .border(
                width = 1.dp,
                color = if (isSelected) DarkGreen else Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(10.dp)
    ) {
        Text(
            text = text,
            style = Typography.labelMedium
        )
        Spacer(modifier = Modifier.weight(1f))
        if (isSelected)
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "check_icon",
                tint = DarkGreen
            )
    }
}