package com.example.menumasterapp.presentation.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.menumasterapp.constant.Graph
import com.example.menumasterapp.presentation.auth.authNavGraph
import com.example.menumasterapp.presentation.bottom_nav.BottomNav

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    accessToken: String?
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = if (accessToken.isNullOrEmpty()) Graph.AUTHENTICATION else Graph.BOTTOM_NAV
    ) {
        authNavGraph(navController)
        composable(route = Graph.BOTTOM_NAV) {
            BottomNav()
        }
    }
}