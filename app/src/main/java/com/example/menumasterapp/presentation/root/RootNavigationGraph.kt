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
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.BOTTOM_NAV
    ) {
        authNavGraph(navController = navController)
        composable(route = Graph.BOTTOM_NAV) {
            BottomNav()
        }
    }
}