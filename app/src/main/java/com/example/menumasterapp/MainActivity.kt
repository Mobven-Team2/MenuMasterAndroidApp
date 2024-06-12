package com.example.menumasterapp

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.menumasterapp.presentation.root.RootNavigationGraph
import com.example.menumasterapp.presentation.ui.theme.MenuMasterAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            MenuMasterAppTheme {
                val navController = rememberNavController()
                RootNavigationGraph(navController = navController)
            }
        }
    }
}