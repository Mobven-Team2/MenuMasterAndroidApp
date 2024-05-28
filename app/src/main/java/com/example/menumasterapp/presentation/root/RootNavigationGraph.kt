package com.example.menumasterapp.presentation.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.menumasterapp.presentation.auth.login.LoginScreen
import com.example.menumasterapp.presentation.auth.register.RegisterScreen
import com.example.menumasterapp.presentation.onboard.OnboardScreen

@Composable
fun RootNavigationGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Onboard.route) {
        composable(route = Screen.Onboard.route) {
            OnboardScreen(navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.Register.route) {
            RegisterScreen(navController)
        }
    }
}