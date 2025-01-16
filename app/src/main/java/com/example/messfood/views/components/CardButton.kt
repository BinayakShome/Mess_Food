package com.example.messfood.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardButton(
    text: String,
    buttonColor: Color = Color.Cyan, // Default color
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(buttonColor), // Use buttonColor directly
        onClick = onClick // Pass the onClick lambda here
    ) {
        Text(
            text = "Hello",
            modifier = Modifier.padding(16.dp) // Add some padding for better UI
        )
    }
}
