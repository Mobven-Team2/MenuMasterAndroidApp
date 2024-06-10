package com.example.menumasterapp.presentation.bottom_nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.menumasterapp.constant.Graph
import com.example.menumasterapp.presentation.ProfileScreen
import com.example.menumasterapp.presentation.ai_recipes.AiRecipesScreen
import com.example.menumasterapp.presentation.home.HomeScreen
import com.example.menumasterapp.presentation.meals.MealsScreen
import com.example.menumasterapp.presentation.root.Screen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    innerPaddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        route = Graph.BOTTOM_NAV,
        startDestination = Screen.Home.route,
        modifier = Modifier.padding(innerPaddingValues)
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
        composable(route = Screen.Meals.route) {
            MealsScreen()
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }
        composable(route = Screen.AiRecipes.route) {
            AiRecipesScreen()
        }
    }
}