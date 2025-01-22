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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.messfood.vm.FoodViewModel
import kotlinx.coroutines.launch

@Composable
fun WeekViewCard(
    foodViewModel: FoodViewModel
) {

    val foodItems by foodViewModel.foodItems.collectAsState(initial = emptyList())

    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    var currentIndex by remember { mutableStateOf(0) }
    val offsetX = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()
    val filteredFoodItems = foodItems.filter { it.day == daysOfWeek[currentIndex] }

    Box(
        Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(296.dp, 504.dp)
                .offset(x = offsetX.value.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .offset(x = 8.dp, y = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Cyan.copy(alpha = 0.6f))
            )

        Card(
            Modifier
                .size(304.dp, 496.dp)
                .offset(x = offsetX.value.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(16.dp),
                    ambientColor = Color.Red,
                    spotColor = Color.Red
                )
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

                                    offsetX.animateTo(300f, tween(300))
                                    currentIndex =
                                        (currentIndex - 1 + daysOfWeek.size) % daysOfWeek.size
                                } else if (offsetX.value < -150) {

                                    offsetX.animateTo(-300f, tween(300))
                                    currentIndex = (currentIndex + 1) % daysOfWeek.size
                                }

                                offsetX.animateTo(0f, tween(300))
                            }
                        }
                    )
                },
            shape = RoundedCornerShape(16.dp),
            backgroundColor = Color.Cyan,
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    daysOfWeek[currentIndex],
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    fontFamily = FontFamily.Cursive,
                    color = Color(0xFFFFA500)
                )
                Spacer(modifier = Modifier.height(32.dp))
                filteredFoodItems.forEach { foodItem ->
                    Text(
                        foodItem.mealType,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        color = Color(0xFFDC143C)
                    )
                    Text(
                        text = foodItem.dishes,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
    }
}