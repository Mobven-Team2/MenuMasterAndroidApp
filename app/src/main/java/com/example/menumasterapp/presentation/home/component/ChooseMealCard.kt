package com.example.menumasterapp.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import com.example.menumasterapp.presentation.ui.theme.Primary
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun ChooseMealCard(
    onClickChooseMealCard: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.choose_meal_background),
                contentDescription = "choose_meal_background",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = { /*TODO*/ },
                content = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.magic_wand),
                        contentDescription = "magic_wand",
                        tint = Color.White
                    )
                },
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .border(4.dp, Color.White, CircleShape)
                    .align(Alignment.Center),
                colors = IconButtonDefaults.iconButtonColors(containerColor = Primary)
            )
        }
        Column(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Öğün Seç & Tarifleri Al",
                style = Typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Öğünlerini seç, yapay zekanın sana özel hazırladığı tariflere göz at.",
                style = Typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(18.dp))
            Row {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Öğün Oluştur",
                    style = Typography.titleSmall,
                    color = Primary,
                    modifier = Modifier.clickable { onClickChooseMealCard() }
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                    contentDescription = "arrow_right",
                    tint = Primary
                )
            }
        }

    }
}