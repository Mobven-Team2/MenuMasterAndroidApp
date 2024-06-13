package com.example.menumasterapp.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.R
import com.example.menumasterapp.presentation.profile.component.CustomInformationCard
import com.example.menumasterapp.presentation.profile.component.CustomProfileCard
import com.example.menumasterapp.presentation.ui.theme.Background
import com.example.menumasterapp.presentation.ui.theme.Grey
import com.example.menumasterapp.presentation.ui.theme.Primary
import com.example.menumasterapp.presentation.ui.theme.PurpleGrey80

@Composable
fun ProfileScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Background)
            .padding(32.dp, 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
       Box {
           Image(
               painterResource(id = R.drawable.profile_photo),
               contentDescription = "",
               Modifier.width(88.dp)
           )
           Icon(imageVector = Icons.Filled.Edit, contentDescription ="" , tint= Color.White,modifier = Modifier.align(Alignment.BottomEnd).width(28.dp)
               .height(28.dp)
               .clip(RoundedCornerShape(16.dp))
               .background(color = Primary)
               .padding(4.dp))
       }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Jane Doe")
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "@janedoe123")
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomInformationCard(title = "160cm", description = "Boy")
            CustomInformationCard(title = "65kg", description = "Kilo")
            CustomInformationCard(title = "22", description = "Yaş")
        }
        Spacer(modifier = Modifier.height(28.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(Grey)
                .padding(8.dp)
        ) {
            Column {
                CustomProfileCard(title = "Kişisel Bilgiler", icon = Icons.Filled.Person)
                CustomProfileCard(title = "Beslenme Geçmişi", icon = Icons.Filled.Delete)
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(Grey)
                .padding(8.dp)
        ) {
            Column {
                CustomProfileCard(title = "Pop-Up Bildirimler", icon = Icons.Filled.Notifications)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(Grey)
                .padding(8.dp)
        ) {
            Column {
                CustomProfileCard(title = "Ayarlar", icon = Icons.Filled.Settings)
                CustomProfileCard(title = "Çıkış Yap", icon = Icons.Filled.ExitToApp)

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewProfileScreen() {
    ProfileScreen()
}