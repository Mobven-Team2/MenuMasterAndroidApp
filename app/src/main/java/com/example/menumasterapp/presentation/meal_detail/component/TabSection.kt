package com.example.menumasterapp.presentation.meal_detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.domain.model.Meal
import com.example.menumasterapp.presentation.ui.theme.DarkGreen
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun TabSection(
    meal: Meal,
    onAddShoppingList: (List<String>) -> Unit
) {
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("İçindekiler", "Tarif")
    TabRow(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
        selectedTabIndex = tabIndex,
        indicator = { TabRowDefaults.SecondaryIndicator(color = Color.Transparent) },
        divider = { }
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = { Text(title, style = Typography.titleSmall) },
                selected = tabIndex == index,
                onClick = { tabIndex = index },
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = if (tabIndex == index) DarkGreen else Color.White),
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Black
            )
        }
    }
    when (tabIndex) {
        0 -> IngredientsContent(
            meal = meal,
            onAddShoppingListButtonClick = { onAddShoppingList(it) }
        )
        1 -> RecipeContent(meal)
    }
}