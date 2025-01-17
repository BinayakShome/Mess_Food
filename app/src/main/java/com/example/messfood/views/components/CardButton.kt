package com.example.messfood.views.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardButton(
    text: String,
    icon: ImageVector,
    buttonColor: Color = Color.Transparent,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 16.dp, // Smooth elevation
                shape = RoundedCornerShape(16.dp), // Match the shape
                clip = true)
            .clip(RoundedCornerShape(16.dp)) // Clip after shadow for rounded corners
            .background(buttonColor) // Apply background color
            .clickable(onClick = onClick)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Icon(
                imageVector = icon,
                contentDescription = "NULL", // Add meaningful content description for accessibility
                modifier = Modifier
                    .size(56.dp) // Adjust the size of the icon
                    .padding(16.dp), // Add spacing between the icon and other content
                tint = MaterialTheme.colorScheme.primary // Use theme color for tint
            )

            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp),
                color = Color.White
            )
        }
    }
}