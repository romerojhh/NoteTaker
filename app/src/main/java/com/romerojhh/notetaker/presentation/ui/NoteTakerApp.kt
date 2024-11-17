package com.romerojhh.notetaker.presentation.ui

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.romerojhh.notetaker.presentation.navigation.NavGraph
import com.romerojhh.notetaker.presentation.navigation.Screen
import com.romerojhh.notetaker.presentation.theme.AppTypography
import com.romerojhh.notetaker.presentation.theme.NoteTakerTheme

@Composable
fun NoteTakerApp() {
    NoteTakerTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute =
            navBackStackEntry?.destination?.route ?: Screen.Overview.route

        Scaffold(
            topBar = { TopBar(currentRoute) }
        ) { innerPadding ->
            NavGraph(
                modifier = Modifier.padding(innerPadding).consumeWindowInsets(innerPadding),
                navController = navController
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String
) {
    TopAppBar(
        title = {
            Text(text = title, style = AppTypography.headlineLarge)
        }
    )
}