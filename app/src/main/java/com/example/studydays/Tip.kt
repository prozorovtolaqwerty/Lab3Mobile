package com.example.studydays

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    val day: Int,
    @StringRes val titleRes: Int,
    @StringRes val summaryRes: Int,
    @StringRes val bodyRes: Int,
    @DrawableRes val imageRes: Int,
)
