package com.romerojhh.notetaker.presentation.ui.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.romerojhh.notetaker.model.NoteContentUiModel
import com.romerojhh.notetaker.presentation.theme.AppSize
import com.romerojhh.notetaker.presentation.theme.AppTypography
import com.romerojhh.notetaker.presentation.theme.NoteTakerTheme
import com.romerojhh.notetaker.presentation.ui.overview.TopBar

@Composable
fun ContentScreen(
    noteContentUiModel: NoteContentUiModel,
    modifier: Modifier = Modifier,
    navigateToOverview: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(
                topBarTitle = noteContentUiModel.title,
                dropdownMenuItem = { DropdownMenuItem() },
                backNavigation = { BackNavigation(navigateToOverview) }
            )
        }
    ) { innerPadding ->
        NoteContent(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = AppSize.xxLargePadding),
            content = noteContentUiModel.content,
            dateModified = noteContentUiModel.dateModified
        )
    }
}

@Composable
private fun BackNavigation(onBackClick: () -> Unit) {
    IconButton(onClick = onBackClick) {
        Icon(Icons.AutoMirrored.Filled.ArrowBack, "back")
    }
}

@Composable
private fun DropdownMenuItem() {
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
private fun NoteContent(
    content: String,
    dateModified: String,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxSize()) {
        Text(
            text = content,
            style = AppTypography.bodyLarge
        )
        Spacer(Modifier.height(AppSize.xxLargePadding))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Modified: $dateModified",
            textAlign = TextAlign.End,
            fontStyle = FontStyle.Italic,
            style = AppTypography.labelSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ContentScreenPreview() {
    val noteContentUiModel = NoteContentUiModel(
        title = "Note title",
        content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
        dateModified = "11/29/2024"
    )
    NoteTakerTheme {
        ContentScreen(
            noteContentUiModel = noteContentUiModel,
            navigateToOverview = {}
        )
    }
}
