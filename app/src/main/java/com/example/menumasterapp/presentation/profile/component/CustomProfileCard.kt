package com.example.menumasterapp.presentation.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.presentation.ui.theme.Background
import com.example.menumasterapp.presentation.ui.theme.Primary
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun CustomProfileCard(
    title: String,
    icon: ImageVector
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(
            icon, contentDescription = "", tint = Primary,
            modifier = Modifier
                .width(28.dp)
                .height(28.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Background)
                .padding(4.dp),
        )
        Text(modifier = Modifier.width(200.dp), text = title, style = Typography.bodyMedium)
        Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "")
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewCustomProfileCard() {
    //CustomProfileCard()
}