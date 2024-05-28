package com.example.menumasterapp.presentation.root

sealed class Screen(val route: String) {
    data object Onboard : Screen("onboard")
    data object Login : Screen("login")
    data object Register : Screen("register")
}