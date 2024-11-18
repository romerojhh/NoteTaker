package com.romerojhh.notetaker.presentation.ui.overview.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
    modifier: Modifier = Modifier,
    noteTeaserUiModelList: List<NoteTeaserUiModel>
) {
    val padding = AppSize.largePadding
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(padding),
    ) {
        itemsIndexed(noteTeaserUiModelList) { index, currTeaser ->
            NoteTeaser(currTeaser)

            if (index < noteTeaserUiModelList.lastIndex) {
                Spacer(Modifier.padding(top = padding))
                HorizontalDivider(thickness = Dp.Hairline)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteLazyListPreview() {
    val noteTeaserUiModel = NoteTeaserUiModel(
        dateCreated = "11/12/2024",
        noteTitle = "Note title",
        noteContentTeaser = "This is a content teaser",
    )

    val noteTeaserUiModelList =
        listOf(noteTeaserUiModel.copy(), noteTeaserUiModel.copy(), noteTeaserUiModel.copy())

    NoteTakerTheme {
        NoteLazyList(
            noteTeaserUiModelList = noteTeaserUiModelList
        )
    }
}