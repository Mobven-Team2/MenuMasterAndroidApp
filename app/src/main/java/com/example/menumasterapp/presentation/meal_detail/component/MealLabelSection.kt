package com.example.menumasterapp.presentation.meal_detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.R
import com.example.menumasterapp.presentation.ui.theme.Primary
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun MealLabelSection(
    mealName: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = mealName,
            modifier = Modifier.weight(1f),
            style = Typography.titleMedium
        )
        IconButton(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Primary)
                .size(48.dp),
            onClick = { /*TODO*/ },
            content = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.refresh),
                    contentDescription = "refresh_icon",
                    tint = Color.White
                )
            }
        )
    }
}