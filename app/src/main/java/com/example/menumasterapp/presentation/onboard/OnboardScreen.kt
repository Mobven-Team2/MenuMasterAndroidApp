package com.example.menumasterapp.presentation.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.menumasterapp.R
import com.example.menumasterapp.presentation.auth.component.CustomButton
import com.example.menumasterapp.presentation.onboard.component.SignUpButton
import com.example.menumasterapp.presentation.root.Screen
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun OnboardScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Hoşgeldin",
            style = Typography.titleLarge
        )
        Text(
            text = "Tercihlerine göre beslenmenin tadını çıkar!",
            style = Typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.onboard_image),
            contentDescription = "onboard_image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(40.dp))
        CustomButton(
            text = "Giriş Yap",
            onButtonClick = {
                navController.navigate(Screen.Login.route)
            }
        )
        SignUpButton {
            navController.navigate(Screen.Register.route)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevOnboardScreen() {
    OnboardScreen(rememberNavController())
}