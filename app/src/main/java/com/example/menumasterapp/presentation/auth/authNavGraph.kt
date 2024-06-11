package com.example.menumasterapp.presentation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.menumasterapp.constant.Graph
import com.example.menumasterapp.presentation.auth.login.LoginScreen
import com.example.menumasterapp.presentation.auth.register.RegisterScreen
import com.example.menumasterapp.presentation.onboard.OnboardScreen
import com.example.menumasterapp.presentation.root.Screen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = Screen.Onboard.route
    ) {
        composable(route = Screen.Onboard.route) {
            OnboardScreen(navController = navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Register.route) {
            RegisterScreen(navController = navController)
        }
    }
}