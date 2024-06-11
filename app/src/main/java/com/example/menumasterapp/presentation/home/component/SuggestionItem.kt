package com.example.menumasterapp.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun SuggestionItem(
    iconResource: Int,
    iconColor: Color,
    suggestionLabel: String,
    suggestionDescription: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(iconColor.copy(alpha = 0.4f))
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = iconResource),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(46.dp),
                tint = iconColor
            )
        }
        Spacer(modifier = Modifier.width(18.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = suggestionLabel,
                style = Typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = suggestionDescription,
                style = Typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.width(6.dp))
        Icon(
            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
            contentDescription = "arrow_right"
        )
    }
}