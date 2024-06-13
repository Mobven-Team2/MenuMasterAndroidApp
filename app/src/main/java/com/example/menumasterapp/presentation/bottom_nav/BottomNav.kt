package com.example.menumasterapp.presentation.bottom_nav

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.menumasterapp.R
import com.example.menumasterapp.presentation.root.Screen
import com.example.menumasterapp.presentation.ui.theme.Background
import com.example.menumasterapp.presentation.ui.theme.Primary
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable
fun BottomNav(
    navController: NavHostController = rememberNavController(),
) {
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    val navigationItems = listOf(
        BottomNavigationItem(
            route = Screen.Home.route,
            title = "Anasayfa",
            icon = ImageVector.vectorResource(id = R.drawable.home)
        ),
        BottomNavigationItem(
            route = Screen.Meals.route,
            title = "Öğünler",
            icon = ImageVector.vectorResource(id = R.drawable.meals)
        ),
        BottomNavigationItem(
            route = Screen.ShoppingList.route,
            title = "Alışveriş",
            icon = ImageVector.vectorResource(id = R.drawable.shopping_list_small)
        ),
        BottomNavigationItem(
            route = Screen.Profile.route,
            title = "Profilim",
            icon = ImageVector.vectorResource(id = R.drawable.profile)
        )
    )
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFFF4F4F4)
            ) {
                navigationItems.forEachIndexed { index, bottomNavigationItem ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(bottomNavigationItem.route)
                        },
                        icon = {
                            Icon(
                                imageVector = bottomNavigationItem.icon,
                                contentDescription = "navigation_icon",
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        label = {
                            Text(
                                text = bottomNavigationItem.title,
                                style = Typography.bodySmall
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Primary,
                            selectedTextColor = Primary,
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        },
        containerColor = Background
    ) { paddingValues ->
        BottomNavGraph(navController = navController, innerPaddingValues = paddingValues)
    }
}

data class BottomNavigationItem(
    val route: String,
    val title: String,
    val icon: ImageVector
)