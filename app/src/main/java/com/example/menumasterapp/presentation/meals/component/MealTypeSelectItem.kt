package com.example.menumasterapp.presentation.meals.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.presentation.ui.theme.DarkGreen
import com.example.menumasterapp.presentation.ui.theme.LightGreen
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun MealTypeSelectItem(
    imageResource: Int,
    label: String,
    onClick: () -> Unit,
    isSelected: Boolean,
    isGenerated: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(if (isSelected) LightGreen else Color.White)
            .clickable { onClick() }
            .border(
                width = 1.dp,
                color = if (isSelected) DarkGreen else Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "meal_image",
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = label,
                style = Typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = if(isSelected || isGenerated) "Tarif Hazır!" else "Öğünü ekle",
                style = Typography.bodySmall,
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        if (isSelected)
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "check_icon",
                modifier = Modifier.size(24.dp),
                tint = DarkGreen
            )
        if (isGenerated)
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = "arrow_icon"
            )
    }
}