package com.romerojhh.notetaker.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.romerojhh.notetaker.presentation.navigation.NavGraph
import com.romerojhh.notetaker.presentation.theme.NoteTakerTheme

@Suppress("ktlint:compose:modifier-missing-check")
@Composable
fun NoteTakerApp() {
    NoteTakerTheme {
        val navController = rememberNavController()
        NavGraph(
            navController = navController
        )
    }
}
