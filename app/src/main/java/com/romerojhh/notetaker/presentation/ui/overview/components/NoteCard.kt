package com.romerojhh.notetaker.presentation.ui.overview.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.romerojhh.notetaker.model.NoteTeaserUiModel
import com.romerojhh.notetaker.presentation.theme.AppSize
import com.romerojhh.notetaker.presentation.theme.NoteTakerTheme

@Composable
fun NoteCard(
    noteTeaserUiModelList: List<NoteTeaserUiModel>,
    modifier: Modifier = Modifier
) {
    val paddedModifier = Modifier.padding(
        horizontal = AppSize.xLargePadding,
        vertical = AppSize.largePadding
    )
    Column(modifier) {
        Text(
            modifier = paddedModifier,
            text = "Month / Year"
        )
        Card {
            NoteLazyList(
                modifier = paddedModifier,
                noteTeaserUiModelList = noteTeaserUiModelList
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NoteCardPreview() {
    val noteTeaserUiModel =
        NoteTeaserUiModel(
            dateCreated = "11/12/2024",
            noteTitle = "Note title",
            noteContentTeaser = "This is a content teaser"
        )

    val noteTeaserUiModelList =
        listOf(noteTeaserUiModel.copy(), noteTeaserUiModel.copy(), noteTeaserUiModel.copy())

    NoteTakerTheme {
        NoteCard(noteTeaserUiModelList = noteTeaserUiModelList)
    }
}
