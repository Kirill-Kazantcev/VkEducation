package com.practicum.vkeducation.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.practicum.vkeducation.presentation.appdetails.AppDetailsScreen
import com.practicum.vkeducation.presentation.home.HomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME.name,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(Routes.HOME.name) {
            HomeScreen(
                onAppClick = { navController.navigate(Routes.APP_DETAILS.name) }
            )
        }

        composable(Routes.APP_DETAILS.name) {
            AppDetailsScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
