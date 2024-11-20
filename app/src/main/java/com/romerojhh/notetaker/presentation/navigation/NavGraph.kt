package com.romerojhh.notetaker.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.romerojhh.notetaker.presentation.ui.details.DetailsScreen
import com.romerojhh.notetaker.presentation.ui.overview.OverviewScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Overview.route
    ) {
        composable(route = Screen.Overview.route) {
            OverviewScreen(modifier) {
                navController.navigate(Screen.Details.route) {
                    popUpTo(Screen.Overview.route) {
                        inclusive = true
                    }
                }
            }
        }
        composable(route = Screen.Details.route) {
            DetailsScreen(modifier) {
                navController.navigate(Screen.Overview.route) {
                    popUpTo(Screen.Overview.route) {
                        inclusive = true
                    }
                }
            }
        }
    }
}
