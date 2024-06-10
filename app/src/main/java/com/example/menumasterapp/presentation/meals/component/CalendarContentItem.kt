package com.example.menumasterapp.presentation.meals.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CalendarContentItem(
    day: String,
    date: Int,
    onItemClick: () -> Unit = {},
    isSelect: Boolean = false
) {
    Card(
        modifier = Modifier.size(width = 60.dp, height = 80.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelect) Color(0xFF34A853) else Color.White,
            contentColor = if (isSelect) Color.White else Color.Black
        ),
        onClick = { onItemClick() }
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = day,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = date.toString(),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
private fun PrevCalendarContentItem() {
    CalendarContentItem("Mon", 14)
}