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
    data object Meals : Screen("meals")
    data object MealDetail : Screen("meal_detail")
    data object Profile : Screen("profile")
    data object ShoppingList : Screen("shopping_list")
}