package com.romerojhh.notetaker.presentation.ui.overview

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.romerojhh.notetaker.model.NoteOverviewUiModel
import com.romerojhh.notetaker.model.NoteTeaserUiModel
import com.romerojhh.notetaker.presentation.theme.AppSize
import com.romerojhh.notetaker.presentation.theme.AppTypography
import com.romerojhh.notetaker.presentation.theme.NoteTakerTheme
import com.romerojhh.notetaker.presentation.ui.overview.components.NoteCard

@Composable
fun OverviewScreen(
    noteOverviewUiModelList: List<NoteOverviewUiModel>,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopBar(
                topBarTitle = "Your Notes",
                dropdownMenuItem = {
                    DropdownMenuItemRomero()
                }
            )
        },
        floatingActionButton = { Fab() }
    ) { innerPadding ->
        Content(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = AppSize.xxLargePadding),
            noteOverviewUiModelList = noteOverviewUiModelList
        )
    }
}

@Composable
private fun DropdownMenuItemRomero() {
    Column {
        DropdownMenuItem(
            text = { Text("Edit") },
            onClick = { /* Handle edit! */ },
            leadingIcon = { Icon(Icons.Outlined.Edit, contentDescription = null) }
        )
        DropdownMenuItem(
            text = { Text("Settings") },
            onClick = { /* Handle settings! */ },
            leadingIcon = { Icon(Icons.Outlined.Settings, contentDescription = null) }
        )
    }
}

@Composable
private fun Content(
    noteOverviewUiModelList: List<NoteOverviewUiModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(AppSize.largePadding)
    ) {
        items(noteOverviewUiModelList) { currNoteOverviewUiModel ->
            NoteCard(
                noteTeaserUiModelList = currNoteOverviewUiModel.noteTeaserUiModelList,
                date = currNoteOverviewUiModel.date
            )
        }
    }
}

@Composable
private fun Fab() {
    FloatingActionButton(
        onClick = {
            TODO()
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Edit,
            contentDescription = "edit"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    topBarTitle: String,
    modifier: Modifier = Modifier,
    backNavigation: @Composable () -> Unit = {},
    dropdownMenuItem: @Composable () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = topBarTitle,
                style = AppTypography.headlineSmall,
                modifier = Modifier.padding(start = AppSize.xLargePadding)
            )
        },
        actions = { DropdownMenu(Modifier, dropdownMenuItem) },
        navigationIcon = backNavigation
    )
}

@Composable
fun DropdownMenu(
    modifier: Modifier = Modifier,
    dropdownMenuItem: @Composable () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier) {
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            dropdownMenuItem()
        }
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "more")
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    backgroundColor = Color.BLACK.toLong()
)
private fun OverviewScreenPreview() {
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
        listOf(noteOverviewUiModel.copy(), noteOverviewUiModel.copy(), noteOverviewUiModel.copy())

    NoteTakerTheme {
        OverviewScreen(
            noteOverviewUiModelList = noteOverviewUiModelList
        )
    }
}
