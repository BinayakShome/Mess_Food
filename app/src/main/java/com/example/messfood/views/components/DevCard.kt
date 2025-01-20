package com.example.messfood.views.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DevCard() {
    var isFlipped by remember { mutableStateOf(false) }
    val rotation = remember { Animatable(0f) }

    LaunchedEffect(isFlipped) {
        rotation.animateTo(
            targetValue = if (isFlipped) 180f else 0f,
            animationSpec = tween(durationMillis = 1600)
        )
    }

    val scale = if (rotation.value < 90f) 1f else -1f

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .size(height = 200.dp, width = 350.dp)
                .graphicsLayer(
                    rotationY = rotation.value,
                    scaleX = scale
                )
                .clickable { isFlipped = !isFlipped },
            elevation = CardDefaults.cardElevation(16.dp),
        ) {
            if (rotation.value < 90f) {
                FrontContent()
            } else {
                BackContent()
            }
        }
    }
}

@Composable
fun FrontContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
    ) {
        Text("Hi there,\nBinayak this side.\n\nI'm grateful for the opportunity to share this project this project",
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun BackContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        contentAlignment = Alignment.Center
    ) {
        Text("Stay tuned for more projects",
            color = Color.Black,
            fontSize = 36.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp))
    }
}
