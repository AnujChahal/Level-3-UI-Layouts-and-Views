package com.synac.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.synac.bmicalculator.domain.model.BMIRecord
import com.synac.bmicalculator.presentation.historyscreen.HistoryScreen
import com.synac.bmicalculator.presentation.homescreen.HomeScreen
import com.synac.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMICalculatorTheme {
                val navController = rememberNavController()
                val history = remember { mutableListOf<BMIRecord>() }

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController, history) }
                    composable("history") { HistoryScreen(navController, history) }
                }
            }
        }
    }
}
