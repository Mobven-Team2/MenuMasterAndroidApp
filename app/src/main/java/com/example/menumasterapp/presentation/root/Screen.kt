package com.example.menumasterapp.presentation.root

sealed class Screen(val route: String) {
    data object Onboard : Screen("onboard")
    data object Login : Screen("login")
    data object Register : Screen("register")
    data object Home : Screen("home")
    data object Meals : Screen("meal")
    data object Profile : Screen("profile")
    data object AiRecipes : Screen("ai_recipes")

    data object Welcoming: Screen("welcoming")
}