package com.example.menumasterapp.presentation.shopping_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.menumasterapp.presentation.meal_detail.component.IngredientItem
import com.example.menumasterapp.presentation.ui.theme.Primary
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun ShoppingListScreen(
    viewModel: ShoppingListViewModel = hiltViewModel()
) {
    val state by viewModel.shoppingListState.collectAsState()
    val tabs = listOf("Breakfast", "Lunch", "Snack", "Dinner")
    var tabIndex by remember { mutableIntStateOf(0) }
    Column {
        TabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = tabIndex
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title, style = Typography.titleSmall) },
                    selected = tabIndex == index,
                    onClick = {
                        viewModel.getShoppingItemsByCategory(title)
                        tabIndex = index
                    },
                    selectedContentColor = Primary,
                    unselectedContentColor = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(state) { value ->
                IngredientItem(text = value) {

                }
            }
        }
    }
}