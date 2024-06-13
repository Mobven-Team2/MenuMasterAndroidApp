package com.example.menumasterapp.presentation.meals.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.R
import com.example.menumasterapp.domain.model.Meal
import com.example.menumasterapp.presentation.auth.component.CustomButton
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun MealTypeSelectSection(
    isMealGenerated: Boolean,
    generatedMealList : List<Meal>,
    selectedMealTypeList: MutableList<String>,
    onGenerateMealsButtonClick: () -> Unit,
    onClickMealTypeItem: () -> Unit
) {
    val mealTypeItemLists = listOf(
        MealTypeItem(
            imageResource = R.drawable.breakfast,
            mealType = MealType(trLabel = "Kahvaltı", ingLabel = "Breakfast")
        ),
        MealTypeItem(
            imageResource = R.drawable.lunch,
            mealType = MealType(trLabel = "Öğle Yemeği", ingLabel = "Lunch")
        ),
        MealTypeItem(
            imageResource = R.drawable.snack,
            mealType = MealType(trLabel = "Ara Öğün", ingLabel = "Snack")
        ),
        MealTypeItem(
            imageResource = R.drawable.dinner,
            mealType = MealType(trLabel = "Akşam Yemeği", ingLabel = "Dinner")
        )
    )
    println(generatedMealList)
    val filteredMealTypeItemLists = if (isMealGenerated) {
        mealTypeItemLists.filter { mealTypeItem ->
            generatedMealList.any { meal -> meal.mealType == mealTypeItem.mealType.ingLabel }
        }
    } else {
        mealTypeItemLists
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = if (isMealGenerated) "Öğünler" else "Öğün Seçimi Yap",
            style = Typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        filteredMealTypeItemLists.forEach { mealItem ->
            val isSelected = selectedMealTypeList.contains(mealItem.mealType.ingLabel)
            MealTypeSelectItem(
                imageResource = mealItem.imageResource,
                label = mealItem.mealType.trLabel,
                onClick = {
                    if (isMealGenerated)
                        onClickMealTypeItem()
                    else
                        if (isSelected)
                            selectedMealTypeList.remove(mealItem.mealType.ingLabel)
                        else
                            selectedMealTypeList.add(mealItem.mealType.ingLabel)
                },
                isSelected = if (isMealGenerated) false else isSelected,
                isGenerated = isMealGenerated
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        if (!isMealGenerated)
            CustomButton(
                text = "Öğünleri Oluştur",
                onButtonClick = { onGenerateMealsButtonClick() },
                enabled = selectedMealTypeList.size > 0
            )
    }
}

data class MealTypeItem(
    val imageResource: Int,
    val mealType: MealType
)

data class MealType(
    val trLabel: String,
    val ingLabel: String
)