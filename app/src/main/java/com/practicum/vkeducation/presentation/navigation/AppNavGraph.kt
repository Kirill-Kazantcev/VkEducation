package com.practicum.vkeducation.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.practicum.vkeducation.presentation.appdetails.AppDetailsScreen
import com.practicum.vkeducation.presentation.home.HomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable<Routes.HOME> {
            HomeScreen(
                onAppClick = { id ->
                    navController.navigate(Routes.APP_DETAILS(id))
                }
            )
        }

        composable<Routes.APP_DETAILS> { backStackEntry ->
            val args = backStackEntry.toRoute<Routes.APP_DETAILS>()
            AppDetailsScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}