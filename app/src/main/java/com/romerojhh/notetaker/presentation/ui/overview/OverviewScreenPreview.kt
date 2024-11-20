package com.romerojhh.notetaker.presentation.ui.overview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.romerojhh.notetaker.presentation.theme.NoteTakerTheme

@Composable
@Preview(
    showBackground = true
)
private fun OverviewScreenPreview() {
    NoteTakerTheme {
        OverviewScreen(
            navigateToDetails = {}
        )
    }
}
