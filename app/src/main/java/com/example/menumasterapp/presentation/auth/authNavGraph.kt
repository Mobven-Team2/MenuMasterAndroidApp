package com.example.menumasterapp.presentation.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.menumasterapp.constant.Graph
import com.example.menumasterapp.presentation.auth.diettypes.DietTypesScreen
import com.example.menumasterapp.presentation.auth.globalcuisine.GlobalCuisineScreen
import com.example.menumasterapp.presentation.auth.login.LoginScreen
import com.example.menumasterapp.presentation.auth.onboard.OnboardScreen
import com.example.menumasterapp.presentation.auth.register.RegisterScreen
import com.example.menumasterapp.presentation.auth.register.RegisterViewModel
import com.example.menumasterapp.presentation.auth.userinformations.UserInformationsScreen
import com.example.menumasterapp.presentation.auth.welcoming.WelcomingScreen
import com.example.menumasterapp.presentation.root.Screen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = Screen.Welcoming.route
    ) {
        composable(route= Screen.Welcoming.route){
            WelcomingScreen(navController)
        }
        composable(route = Screen.Onboard.route) {
            OnboardScreen(navController = navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Register.route) {entry ->
            val viewModel = entry.sharedViewModel<RegisterViewModel>(navController)
            RegisterScreen(viewModel = viewModel, onNavigate = { navController.navigate(Screen.Login.route) })
        }
        composable(route = Screen.UserInformation.route) {entry ->
            val viewModel = entry.sharedViewModel<RegisterViewModel>(navController)
            UserInformationsScreen(viewModel = viewModel, onNavigate = { navController.navigate(Screen.DietType.route) })
        }
        composable(route = Screen.DietType.route) {entry ->
            val viewModel = entry.sharedViewModel<RegisterViewModel>(navController)
            DietTypesScreen(viewModel = viewModel, onNavigate = { navController.navigate(Screen.GlobalCuisine.route) })
        }
        composable(route = Screen.GlobalCuisine.route) {entry ->
            val viewModel = entry.sharedViewModel<RegisterViewModel>(navController)
            GlobalCuisineScreen(viewModel = viewModel, onNavigate = { navController.navigate(Screen.Register.route)})
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavHostController,
): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) { navController.getBackStackEntry(navGraphRoute) }
    return hiltViewModel(parentEntry)
}