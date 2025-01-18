package com.example.messfood.views.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun SwipingDaysOfWeek(
    Content: String
) {
    // List of days of the week
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    var currentIndex by remember { mutableStateOf(0) }
    val offsetX = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        // Current card
        Card(
            Modifier
                .size(300.dp, 500.dp)
                .offset(x = offsetX.value.dp)
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onHorizontalDrag = { _, dragAmount ->
                            scope.launch {
                                offsetX.snapTo(offsetX.value + dragAmount)
                            }
                        },
                        onDragEnd = {
                            scope.launch {
                                if (offsetX.value > 150) {
                                    // Swipe to the left (Previous card)
                                    offsetX.animateTo(300f, tween(300))
                                    currentIndex = (currentIndex - 1 + daysOfWeek.size) % daysOfWeek.size
                                } else if (offsetX.value < -150) {
                                    // Swipe to the right (Next card)
                                    offsetX.animateTo(-300f, tween(300))
                                    currentIndex = (currentIndex + 1) % daysOfWeek.size
                                }
                                // Reset the position
                                offsetX.animateTo(0f, tween(300))
                            }
                        }
                    )
                },
            shape = RoundedCornerShape(16.dp),
            elevation = 8.dp,
            backgroundColor = Color.Cyan,
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = Content)
            }
        }
    }
}

