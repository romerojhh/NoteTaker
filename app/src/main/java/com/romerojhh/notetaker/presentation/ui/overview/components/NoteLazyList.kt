package com.romerojhh.notetaker.presentation.ui.overview.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.romerojhh.notetaker.model.NoteTeaserUiModel
import com.romerojhh.notetaker.presentation.theme.AppSize
import com.romerojhh.notetaker.presentation.theme.NoteTakerTheme

@Composable
fun NoteLazyList(
    noteTeaserUiModelList: List<NoteTeaserUiModel>,
    modifier: Modifier = Modifier
) {
    val padding = AppSize.largePadding
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(padding)
    ) {
        noteTeaserUiModelList.forEachIndexed { index, currNoteTeaserUiModel ->
            NoteTeaser(currNoteTeaserUiModel)

            if (index < noteTeaserUiModelList.lastIndex) {
                HorizontalDivider(thickness = Dp.Hairline)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NoteLazyListPreview() {
    val noteTeaserUiModel =
        NoteTeaserUiModel(
            dateCreated = "11/12/2024",
            noteTitle = "Note title",
            noteContentTeaser = "This is a content teaser"
        )

    val noteTeaserUiModelList =
        listOf(noteTeaserUiModel.copy(), noteTeaserUiModel.copy(), noteTeaserUiModel.copy())

    NoteTakerTheme {
        NoteLazyList(
            noteTeaserUiModelList = noteTeaserUiModelList
        )
    }
}
