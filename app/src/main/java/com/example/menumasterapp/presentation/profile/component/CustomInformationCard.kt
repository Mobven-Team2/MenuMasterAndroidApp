package com.example.menumasterapp.presentation.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.presentation.ui.theme.Background
import com.example.menumasterapp.presentation.ui.theme.LightPrimary
import com.example.menumasterapp.presentation.ui.theme.Primary
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun CustomInformationCard(
    title: String,
    description: String
) {
    Box(
        modifier = Modifier
            .width(98.dp)
            .height(65.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Color.White)

    ) {
        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = title, color= Primary, style = Typography.bodySmall)
            Text(text = description, style = Typography.bodySmall)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewofCard() {
    CustomInformationCard("160cm", "Kilo")
}