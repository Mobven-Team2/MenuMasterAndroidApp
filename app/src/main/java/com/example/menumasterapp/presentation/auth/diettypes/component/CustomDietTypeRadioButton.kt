package com.example.menumasterapp.presentation.auth.diettypes.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.R
import com.example.menumasterapp.presentation.ui.theme.DarkGreen
import com.example.menumasterapp.presentation.ui.theme.LightGreen
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun CustomDietTypeRadioButton(
    drawable: Int,
    title: String,
    description: String,
) {

    var isSelected by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(72.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                1.dp,
                color = if (isSelected) DarkGreen else Color.LightGray,
                RoundedCornerShape(16.dp)
            )
            .background(if (isSelected) LightGreen else Color.White),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.width(72.dp),
                tint = Color.Unspecified,
                painter = painterResource(id = drawable),
                contentDescription = ""
            )
            Column(
                modifier = Modifier.height(72.dp), verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    color = if (isSelected) DarkGreen else Color.Black,
                    style = Typography.bodySmall,
                    fontWeight = FontWeight.Bold
                )
                if (description != "") Text(
                    text = description,
                    color = if (isSelected) DarkGreen else Color.Black,
                    style = Typography.bodySmall
                )
            }
        }

        RadioButton(
            selected = isSelected, onClick = {
                isSelected = !isSelected
            }, colors = RadioButtonDefaults.colors(
                selectedColor = if (isSelected) DarkGreen else Color.LightGray
            )
        )
    }


}

@Preview
@Composable
fun preview() {
    Column {
        CustomDietTypeRadioButton(
            drawable = R.drawable.vegan, title = "Vegan", description = "Sadece Bitkisel"
        )
        CustomDietTypeRadioButton(
            drawable = R.drawable.vegeterian,
            title = "Vejeteryan",
            description = "Bitkisel Temelli, Etsiz"
        )
        CustomDietTypeRadioButton(
            drawable = R.drawable.ketogenic, title = "Ketojenik", description = "Yağ Temelli"
        )
        CustomDietTypeRadioButton(
            drawable = R.drawable.paleo, title = "Paleo", description = "İlkel Doğal Beslenme"
        )
        CustomDietTypeRadioButton(
            drawable = R.drawable.nodiet, title = "Beslenme Yok", description = ""
        )
    }

}