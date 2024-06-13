package com.example.menumasterapp.presentation.meal_detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.domain.model.Meal
import com.example.menumasterapp.presentation.auth.component.CustomButton

@Composable
fun IngredientsContent(
    meal: Meal,
    onAddShoppingListButtonClick: (List<String>) -> Unit
) {
    val selectedIngredients = remember { mutableStateListOf<String>() }
    val ingredients = meal.ingredients
    Spacer(modifier = Modifier.height(20.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        ingredients?.forEach {ingredient ->
            val isSelected = selectedIngredients.contains(ingredient)
            IngredientItem(
                text = ingredient,
                isSelected = isSelected,
                onClick = { if (isSelected) selectedIngredients.remove(ingredient) else selectedIngredients.add(ingredient) }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(
            text = "Alışveriş Listesine Ekle",
            onButtonClick = { onAddShoppingListButtonClick(selectedIngredients) }
        )
    }
}