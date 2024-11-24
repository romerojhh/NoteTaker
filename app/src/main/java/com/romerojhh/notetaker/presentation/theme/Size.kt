package com.romerojhh.notetaker.presentation.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Size(
    val smallPadding: Dp,
    val mediumPadding: Dp,
    val largePadding: Dp,
    val xLargePadding: Dp,
    val xxLargePadding: Dp
)

private val defaultAppSize =
    Size(
        smallPadding = 2.dp,
        mediumPadding = 4.dp,
        largePadding = 8.dp,
        xLargePadding = 10.dp,
        xxLargePadding = 18.dp
    )

val AppSize = defaultAppSize
