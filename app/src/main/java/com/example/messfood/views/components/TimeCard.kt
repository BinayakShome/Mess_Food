package com.example.messfood.views.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.messfood.R
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimeCard(
    onClick: () -> Unit
)
{
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    var currentTime = remember { getFormattedDate() }
    var currentHour by remember { mutableStateOf(getCurrentHour()) }
    var greet by remember { mutableStateOf("Hello") }

    //For current date
    LaunchedEffect(Unit) {
        while (true) {
            getFormattedDate()
            kotlinx.coroutines.delay(1000)
        }
    }

    //For current hour
    LaunchedEffect(currentHour) {
        greet = when {
            currentHour in 4..11 -> "Good Morning"
            currentHour in 12..16 -> "Good Afternoon"
            currentHour in 17..21 -> "Good Evening"
            else -> "Sweet Dreams"
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .size(250.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Cyan)
            .padding(16.dp)
            .clickable{onClick()}
            .animateContentSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieAnimation(
                composition = composition,
                progress = progress,
                modifier = Modifier
                    .size(250.dp) // Adjust size of the animation
            )
        }
        Text(text = greet,
            fontSize = 30.sp,
            color = Color.Black,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.TopEnd)
        )
        Text(
            text = "${currentTime}",
            fontSize = 30.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.BottomStart),
            lineHeight = 30.sp// Align text to bottom-left corner
        )
    }

}

@RequiresApi(Build.VERSION_CODES.O)
fun getFormattedDate(): String
{
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("EEEE,\nd MMMM, yyyy") // Format as: "Monday, November 10, 2024"
    return currentDate.format(formatter)
}

@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentHour(): Int {
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("HH") // Use "HH" for 24-hour format
    return currentDateTime.format(formatter).toInt() // Format to display only the hour
}