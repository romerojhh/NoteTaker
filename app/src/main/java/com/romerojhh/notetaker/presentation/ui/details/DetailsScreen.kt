package com.romerojhh.notetaker.presentation.ui.details

import androidx.compose.foundation.clickable
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    navigateToOverview: () -> Unit
) {
    Surface(modifier = modifier) {
        Text(
            "Details Screen",
            modifier = Modifier.clickable {
                navigateToOverview()
            }
        )
    }
}
