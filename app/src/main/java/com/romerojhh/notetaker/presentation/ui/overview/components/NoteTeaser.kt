package com.romerojhh.notetaker.presentation.ui.overview.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.romerojhh.notetaker.model.NoteTeaserUiModel
import com.romerojhh.notetaker.presentation.theme.AppSize
import com.romerojhh.notetaker.presentation.theme.AppTypography
import com.romerojhh.notetaker.presentation.theme.NoteTakerTheme

@Composable
fun NoteTeaser(
    noteTeaserUiModel: NoteTeaserUiModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(AppSize.mediumPadding)
    ) {
        Text(noteTeaserUiModel.noteTitle, style = AppTypography.titleMedium)
        NoteContentTeaser(noteTeaserUiModel.dateCreated, noteTeaserUiModel.noteContentTeaser)
    }
}

@Composable
fun NoteContentTeaser(
    date: String,
    contentTeaser: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth().wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(AppSize.largePadding)
    ) {
        Text(date, style = AppTypography.bodyMedium)
        Text(contentTeaser, style = AppTypography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
private fun NoteTeaserPreview() {
    val noteTeaserUiModel =
        NoteTeaserUiModel(
            dateCreated = "11/12/2024",
            noteTitle = "Note title",
            noteContentTeaser = "This is a content teaser",
        )

    NoteTakerTheme {
        NoteTeaser(
            noteTeaserUiModel
        )
    }
}
