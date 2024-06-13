package com.example.menumasterapp.presentation.meal_detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.domain.model.Meal
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun RecipeContent(
    meal: Meal
) {
    Spacer(modifier = Modifier.height(24.dp))
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(10.dp),
        text = meal.recipe.orEmpty(),
        style = Typography.bodyMedium
    )
}