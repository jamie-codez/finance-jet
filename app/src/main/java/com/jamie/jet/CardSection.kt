package com.jamie.jet

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jamie.jet.data.Card
import com.jamie.jet.ui.theme.BlueEnd
import com.jamie.jet.ui.theme.BlueStart
import com.jamie.jet.ui.theme.GreenEnd
import com.jamie.jet.ui.theme.GreenStart
import com.jamie.jet.ui.theme.OrangeEnd
import com.jamie.jet.ui.theme.OrangeStart
import com.jamie.jet.ui.theme.PurpleEnd
import com.jamie.jet.ui.theme.PurpleStart
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

val cardItems = listOf(
    Card(
        cartType = "VISA",
        cardNumber = "3664 7865 3786 3976",
        cardName = "Business",
        balance = 345434354.42343,
        color = getGradient(
            PurpleStart, PurpleEnd
        )
    ),
    Card(
        cartType = "MASTER CARD",
        cardNumber = "3664 7865 3786 3976",
        cardName = "Savings",
        balance = 345434354.42343,
        color = getGradient(
            BlueStart, BlueEnd
        )
    ),
    Card(
        cartType = "VISA",
        cardNumber = "3664 7865 3786 3976",
        cardName = "School",
        balance = 345434354.42343,
        color = getGradient(
            OrangeStart, OrangeEnd
        )
    ),
    Card(
        cartType = "MASTER CARD",
        cardNumber = "3664 7865 3786 3976",
        cardName = "Trips",
        balance = 345434354.42343,
        color = getGradient(
            GreenStart, GreenEnd
        )
    )
)

fun getGradient(startColor: Color, endColor: Color): Brush =
    Brush.horizontalGradient(colors = listOf(startColor, endColor))


@RequiresApi(Build.VERSION_CODES.N)
@Preview
@Composable
fun CardSection() {
    LazyRow {
        items(cardItems.size) { index ->
            CardItem(index)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun CardItem(index: Int) {
    val card = cardItems[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cardItems.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_launcher_foreground)
    if (card.cartType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_launcher_foreground)
    }
    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)) {
        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(card.color)
            .width(250.dp)
            .height(160.dp)
            .clickable { }
            .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.formatBalance()}",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}






