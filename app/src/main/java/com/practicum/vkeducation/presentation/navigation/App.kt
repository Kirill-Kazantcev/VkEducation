package com.practicum.vkeducation.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.practicum.vkeducation.presentation.theme.VkEducationTheme

@Composable
fun App() {
    VkEducationTheme {
        val navController = rememberNavController()
        AppNavGraph(navController = navController)
    }
}