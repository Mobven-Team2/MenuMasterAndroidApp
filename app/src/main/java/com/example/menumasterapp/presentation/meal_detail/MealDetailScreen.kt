package com.example.menumasterapp.presentation.meal_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.menumasterapp.domain.model.Meal
import com.example.menumasterapp.presentation.meal_detail.component.MealLabelSection
import com.example.menumasterapp.presentation.meal_detail.component.MealTypeSelectField
import com.example.menumasterapp.presentation.meal_detail.component.TabSection

@Composable
fun MealDetailScreen(
    viewModel: MealDetailViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.mealsState.collectAsState()
    var mealType by remember { mutableStateOf("") }
    val selectedMeal by remember(state, mealType) {
        derivedStateOf {
            state.meals.find { it.mealType == mealType }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 10.dp)
    ) {
        IconButton(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray)
                .size(32.dp),
            onClick = { navController.popBackStack() },
            content = {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                    contentDescription = "back_icon"
                )
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
        MealTypeSelectField(
            mealType = mealType,
            onMealTypeChange = { mealType = it }
        )
        Spacer(modifier = Modifier.height(20.dp))
        selectedMeal?.let {meal ->
            MealLabelSection(mealName = meal.name ?: "")
            Spacer(modifier = Modifier.height(22.dp))
            TabSection(
                meal = meal,
                onAddShoppingList = { viewModel.addShoppingList(mealType, it) }
            )
        }
    }
}