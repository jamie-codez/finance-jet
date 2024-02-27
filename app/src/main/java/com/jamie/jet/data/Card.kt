package com.jamie.jet.data

import android.icu.text.DecimalFormat
import android.icu.text.DecimalFormatSymbols
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Brush

data class Card(
    val cartType:String,
    val cardNumber:String,
    val cardName:String,
    val balance:Double,
    val color:Brush
){
    @RequiresApi(Build.VERSION_CODES.N)
    fun formatBalance():String= DecimalFormat("#,###.##").format(this.balance)
}
