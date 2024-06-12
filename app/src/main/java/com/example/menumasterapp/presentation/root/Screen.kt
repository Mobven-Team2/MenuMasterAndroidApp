package com.example.menumasterapp.presentation.root


sealed class Screen(val route: String) {
    data object Welcoming: Screen("welcoming")
    data object Onboard : Screen("onboard")
    data object Login : Screen("login")
    data object Register : Screen("register")
    data object UserInformation: Screen("user_information")
    data object DietType: Screen("diet_type")
    data object GlobalCuisine: Screen("global_cuisine")
    data object Home : Screen("home")
    data object Meals : Screen("meal")
    data object Profile : Screen("profile")
    data object AiRecipes : Screen("ai_recipes")
}