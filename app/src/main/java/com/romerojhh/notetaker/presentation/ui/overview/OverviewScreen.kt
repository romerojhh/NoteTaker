package com.romerojhh.notetaker.presentation.ui.overview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OverviewScreen(
    modifier: Modifier = Modifier,
    navigateToDetails: () -> Unit
) {
    Surface(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            item {
                Text(
                    "Overview Screen",
                    modifier =
                        Modifier.clickable {
                            navigateToDetails()
                        }
                )
            }
            item {
                Text(
                    "Overview Screen",
                    modifier = Modifier.clickable { navigateToDetails() }
                )
            }
            item {
                Text(
                    "Overview Screen",
                    modifier = Modifier.clickable { navigateToDetails() }
                )
            }
        }
    }
}
