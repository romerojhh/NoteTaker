package com.romerojhh.notetaker.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.romerojhh.notetaker.model.NoteOverviewUiModel
import com.romerojhh.notetaker.model.NoteTeaserUiModel
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
            val noteTeaserUiModel =
                NoteTeaserUiModel(
                    dateCreated = "11/12/2024",
                    noteTitle = "Note title",
                    noteContentTeaser = "This is a content teaser"
                )

            val noteTeaserUiModelList =
                listOf(
                    noteTeaserUiModel.copy(),
                    noteTeaserUiModel.copy(),
                    noteTeaserUiModel.copy(),
                    noteTeaserUiModel.copy()
                )

            val noteOverviewUiModel =
                NoteOverviewUiModel(
                    noteTeaserUiModelList = noteTeaserUiModelList,
                    date = "November, 2024"
                )

            val noteOverviewUiModelList =
                listOf(
                    noteOverviewUiModel.copy(),
                    noteOverviewUiModel.copy(),
                    noteOverviewUiModel.copy()
                )

            OverviewScreen(noteOverviewUiModelList, modifier)
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
