package com.example.messfood.views.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.messfood.views.components.TimeCard
import com.example.messfood.vm.FoodViewModel
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(foodViewModel: FoodViewModel,
               navController: NavController) {
    // Collect the food items from the ViewModel
    val foodItems by foodViewModel.foodItems.collectAsState(initial = emptyList())

    // Get the current day of the week
    val currentDay = LocalDate.now().dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())

    // Filter the food items to display only those for the current day
    val filteredFoodItems = foodItems.filter { it.day == currentDay }

    // Scaffold layout with a top bar
    Scaffold(
        topBar = {
            TopAppBar(
                    title = {
                        Row (
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(
                                text = "Mess Menu",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(10.dp),
                                fontSize = 30.sp
                            )
                            IconButton(onClick = { navController.navigate("MoreMenuScreen") }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Menu Icon"
                                )
                            }
                        }

                        },
                        colors =
                            TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)


            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Time card
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TimeCard()
                Spacer(modifier = Modifier.height(10.dp))
            }

            // Lazy column to display filtered food items
            LazyColumn {
                items(filteredFoodItems) { foodItem ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        // Meal type with larger font and bold styling
                        Text(
                            text = "${foodItem.mealType}\n",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(bottom = 8.dp) // Spacing below the meal type text
                        )
                        // Dish description with slightly smaller font and lighter color for emphasis
                        Text(
                            text = "Dish: ${foodItem.dishes}",
                            fontSize = 18.sp,
                            lineHeight = 24.sp // Improves readability for multi-line dishes
                        )
                        // Horizontal divider with consistent padding and spacing
                        Spacer(modifier = Modifier.height(12.dp))
                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            thickness = 1.dp,
                            color = Color.LightGray
                        )
                    }
                }
//                item {
//                    Text(text = "Don't ask again\uD83D\uDE0A\n", modifier = Modifier.padding(start = 20.dp))
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth(),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Text(
//                            text = "App Designed and Developed by\nBinayak",
//                            textAlign = TextAlign.Center, // Center-align the text within the Text composable
//                            fontSize = 16.sp, // Optional: adjust font size if needed
//                            fontWeight = FontWeight.Medium, // Optional: adjust font weight for emphasis
//                        )
//                    }
//                }
            }
        }
    }
}
