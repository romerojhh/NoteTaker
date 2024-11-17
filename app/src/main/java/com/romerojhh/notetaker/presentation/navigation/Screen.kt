package com.romerojhh.notetaker.presentation.navigation

sealed class Screen(val route: String) {
    data object Overview : Screen("Overview")
    data object Details: Screen("Details")
}