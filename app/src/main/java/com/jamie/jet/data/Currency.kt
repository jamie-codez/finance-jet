package com.jamie.jet.data

import androidx.compose.ui.graphics.vector.ImageVector
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

data class Currency(
    val name: String,
    val buy: Float,
    val sell: Float,
    val icon: ImageVector
) {
    fun formatFloat(float: Float): String =
        DecimalFormat("#,###.##", DecimalFormatSymbols.getInstance(Locale.getDefault())).format(
            float
        )
}
