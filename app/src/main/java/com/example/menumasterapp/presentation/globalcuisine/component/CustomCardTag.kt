package com.example.menumasterapp.presentation.globalcuisine.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.presentation.ui.theme.DarkGreen
import com.example.menumasterapp.presentation.ui.theme.LightGreen

@Composable
fun CustomCardTag(
    title: String,
    isSelected: Boolean,
    onSelectionChanged: (String, Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .height(44.dp)
            .background(if (isSelected) LightGreen else Color.White, RoundedCornerShape(12.dp))
            .border(1.dp, DarkGreen, RoundedCornerShape(12.dp))
            .clickable {
                onSelectionChanged(title, !isSelected)
            }.padding(32.dp, 8.dp)
            ,
        contentAlignment = Alignment.Center
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isSelected) Text(title, color = DarkGreen) else Text(
                modifier = Modifier.padding(12.dp, 0.dp),
                text = title,
                color = DarkGreen
            )
            Spacer(modifier = Modifier.height(4.dp))

            if (isSelected) Icon(Icons.Filled.Done, title, tint = DarkGreen)
        }
    }
}
