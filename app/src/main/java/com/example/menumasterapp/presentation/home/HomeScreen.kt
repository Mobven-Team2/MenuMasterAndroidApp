package com.example.menumasterapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.presentation.home.component.AiSuggestionsSection
import com.example.menumasterapp.presentation.home.component.ChooseMealCard
import com.example.menumasterapp.presentation.home.component.ProfileSection
import com.example.menumasterapp.presentation.home.component.SeeMealsButton
import java.util.Calendar

@Composable
fun HomeScreen(

) {
    val hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    val screenHeightDp = LocalConfiguration.current.screenHeightDp
    val screenHeightPx = with(LocalDensity.current) { screenHeightDp.dp.toPx() }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = if (hourOfDay in 6..18)
                        listOf(Color(0xFF58BBE5), Color(0xFFF4F4F4))
                    else
                        listOf(Color(0xFF006D9C), Color(0xFFF4F4F4)),
                    end = Offset(x = 0f, y = screenHeightPx / 3)
                )
            )
            .padding(horizontal = 20.dp)
    ) {
        item { Spacer(Modifier.height(10.dp)) }
        item { ProfileSection(modifier = Modifier.fillMaxWidth(), hourOfDay = hourOfDay) }
        item { Spacer(Modifier.height(30.dp)) }
        item { ChooseMealCard() }
        item { Spacer(Modifier.height(16.dp)) }
        item { SeeMealsButton() }
        item { Spacer(Modifier.height(16.dp)) }
        item { AiSuggestionsSection() }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevHomeScreen() {
    HomeScreen()
}