package com.example.messfood.Screens.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimeCard()
{
    var currentTime = remember {
        getFormattedDate()
    }

    LaunchedEffect(Unit) {
        while (true) {
            getFormattedDate()
            kotlinx.coroutines.delay(1000) // update every second
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .size(250.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Cyan)
            .padding(16.dp) // Padding for the content inside the box
    ) {
        Text(text = "KP 25 E",
            fontSize = 20.sp,
            color = Color.Black,
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