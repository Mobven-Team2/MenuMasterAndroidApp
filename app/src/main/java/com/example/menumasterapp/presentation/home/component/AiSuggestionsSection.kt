package com.example.menumasterapp.presentation.home.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.R
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun AiSuggestionsSection() {
    val suggestionList = listOf(
        AiSuggestion(
            iconResource = R.drawable.recipe_photo,
            iconColor = Color(0xFF0299DA),
            suggestionLabel = "Fotoğraftan Yemek Tarifi Al",
            suggestionDescription = "Yemek fotoğraflarını analiz ederek, benzer tarifler sunar."
        ),
        AiSuggestion(
            iconResource = R.drawable.shopping_list,
            iconColor = Color(0xFF7373AB),
            suggestionLabel = "Alışveriş Listesi ve Sepet",
            suggestionDescription = "Tariflerinizdeki malzemeleri listeler, sizi market alışverişine yönlendirir."
        ),
        AiSuggestion(
            iconResource = R.drawable.refrigerator_alternatives,
            iconColor = Color(0xFFEE714A),
            suggestionLabel = "Buzdolabından Alternatifler",
            suggestionDescription = "Malzemelerinizin analizini yaparak tariflerinizi ve öğünlerinizi oluşturur."
        )
    )
    Text(text = "Menu Master AI Önerileri", style = Typography.bodyLarge)
    Spacer(modifier = Modifier.height(16.dp))
    suggestionList.forEach { suggestion ->
        SuggestionItem(
            iconResource = suggestion.iconResource,
            iconColor = suggestion.iconColor,
            suggestionLabel = suggestion.suggestionLabel,
            suggestionDescription = suggestion.suggestionDescription,
            onClick = { /* Handle suggestion click */ }
        )
        Spacer(Modifier.height(20.dp))
    }
}

data class AiSuggestion(
    val iconResource: Int,
    val iconColor: Color,
    val suggestionLabel: String,
    val suggestionDescription: String
)