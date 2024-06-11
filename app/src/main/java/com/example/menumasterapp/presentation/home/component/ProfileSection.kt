package com.example.menumasterapp.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.R
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier,
    hourOfDay: Int
) {
    Image(
        modifier = modifier.height(80.dp),
        painter = painterResource(id = if (hourOfDay in 6..18) R.drawable.morning_background else R.drawable.evening_background),
        contentDescription = "morning_background",
        contentScale = ContentScale.Crop
    )
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .size(48.dp),
            painter = painterResource(id = R.drawable.profile_photo),
            contentDescription = "profile_image",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Merhaba, hoşgeldin",
                style = Typography.labelMedium
            )
            Text(
                text = "Jane Doe",
                style = Typography.bodyLarge
            )
        }
        IconButton(
            onClick = { /*TODO*/ },
            content = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.notification),
                    contentDescription = "notification_icon",
                    tint = Color.Black
                )
            }
        )
    }
}