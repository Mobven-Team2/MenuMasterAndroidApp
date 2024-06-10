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
import com.example.menumasterapp.presentation.auth.component.CustomButton
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun MealSelectSection() {
    val mealItemList = listOf(
        MealItem(
            imageResource = R.drawable.breakfast,
            label = "Kahvaltı"
        ),
        MealItem(
            imageResource = R.drawable.lunch,
            label = "Öğle Yemeği"
        ),
        MealItem(
            imageResource = R.drawable.snack,
            label = "Ara Öğün"
        ),
        MealItem(
            imageResource = R.drawable.dinner,
            label = "Akşam Yemeği"
        )
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Öğün Seçimi Yap",
            style = Typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        mealItemList.forEach {mealItem ->
            MealSelectItem(
                imageResource = mealItem.imageResource,
                label = mealItem.label,
                onClick = {  }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(
            text = "Öğünleri Oluştur",
            onButtonClick = { /*TODO*/ },
            enabled = false
        )
    }
}

data class MealItem(
    val imageResource: Int,
    val label: String
)