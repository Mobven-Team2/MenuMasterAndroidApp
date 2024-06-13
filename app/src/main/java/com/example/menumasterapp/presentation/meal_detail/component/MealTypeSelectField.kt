package com.example.menumasterapp.presentation.meal_detail.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.presentation.meals.component.MealType
import com.example.menumasterapp.presentation.ui.theme.Grey
import com.example.menumasterapp.presentation.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealTypeSelectField(
    mealType: String,
    onMealTypeChange: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val mealTypeList = listOf(
        MealType("Kahvaltı","Breakfast"),
        MealType("Öğle Yemeği","Lunch"),
        MealType("Ara Öğün","Snack"),
        MealType("Akşam Yemeği","Dinner")
    )
    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it }
    ) {
        OutlinedTextField(
            value = mealType,
            onValueChange = { onMealTypeChange(it) },
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            modifier = Modifier.fillMaxWidth().menuAnchor(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Primary,
                unfocusedBorderColor = Color.LightGray
            ),
            shape = RoundedCornerShape(10.dp)
        )
        ExposedDropdownMenu(
            expanded = isExpanded, 
            onDismissRequest = { isExpanded = false }
        ) {
            mealTypeList.forEach {mealType ->
                DropdownMenuItem(
                    text = { Text(text = mealType.trLabel) },
                    onClick = {
                        onMealTypeChange(mealType.ingLabel)
                        isExpanded = false
                    }
                )
            }
        }
    }
}