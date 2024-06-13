package com.example.menumasterapp.presentation.meals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.menumasterapp.presentation.meals.component.CalendarSection
import com.example.menumasterapp.presentation.meals.component.MealTypeSelectSection
import com.example.menumasterapp.presentation.meals.component.SuccessDialog
import com.example.menumasterapp.presentation.root.Screen
import com.example.menumasterapp.presentation.ui.theme.Background
import com.example.menumasterapp.presentation.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsScreen(
    viewModel: MealsViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state by viewModel.mealsState.collectAsState()
    val selectedMealTypeList = remember { mutableStateListOf<String>() }
    val isMealGenerated by remember { derivedStateOf { state.meals.isNotEmpty() } }
    var showDialog by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = state.success) {
        if (state.success)
            showDialog = true
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Öğün Oluştur",
                        style = Typography.titleMedium
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        containerColor = Background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            CalendarSection(
                dayOfMonth = viewModel.getDayOfMonth(),
                dayList = viewModel.getDayList()
            )
            Spacer(modifier = Modifier.height(20.dp))
            MealTypeSelectSection(
                isMealGenerated = isMealGenerated,
                generatedMealList = state.meals,
                selectedMealTypeList = selectedMealTypeList,
                onGenerateMealsButtonClick = {
                    viewModel.generateMeals(selectedMealTypeList)
                },
                onClickMealTypeItem = { navController.navigate(Screen.MealDetail.route) }
            )
        }
    }
    if (showDialog) {
        SuccessDialog(
            title = "Öğünler Oluşturuldu!",
            description = "Seçtiğiniz öğünler başarıyla oluşturuldu! Tariflerinize göz atabilirsiniz.",
            onSeeMealButtonClick = {
                viewModel.getGeneratedMeals()
                showDialog = false
            },
            onDismiss = { showDialog = false }
        )
    }
}