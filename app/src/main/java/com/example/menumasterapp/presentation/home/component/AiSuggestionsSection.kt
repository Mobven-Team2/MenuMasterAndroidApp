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
fun AiSuggestionsSection(
    onSuggestionItemClick: () -> Unit
) {
    val suggestionList = listOf(
        AiSuggestion(
            imageResource = R.drawable.suggestion1,
            description = "Yemeğinizi pişirirken süreyi dikkatlice takip etmeyi unutmayın",
            backgroundColor = Color(0xFFFFEEE5)
        ),
        AiSuggestion(
            imageResource = R.drawable.suggestion2,
            description = "Yemeğinizi pişirirken süreyi dikkatlice takip etmeyi unutmayın",
            backgroundColor = Color(0xFFDDEFDD)
        )
    )
    Text(text = "Yemek Tarifleri İçin Püf Noktalar", style = Typography.bodyLarge)
    Spacer(modifier = Modifier.height(16.dp))
    suggestionList.forEach { suggestion ->
        SuggestionItem(
            imageResource = suggestion.imageResource,
            description = suggestion.description,
            backGroundColor = suggestion.backgroundColor
        )
        Spacer(Modifier.height(20.dp))
    }
}

data class AiSuggestion(
    val imageResource: Int,
    val description: String,
    val backgroundColor: Color
)