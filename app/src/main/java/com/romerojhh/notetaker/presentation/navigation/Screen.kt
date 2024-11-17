package com.romerojhh.notetaker.presentation.navigation

sealed class Screen(val route: String) {
    data object Overview : Screen("overview")
    data object Details: Screen("details")
}