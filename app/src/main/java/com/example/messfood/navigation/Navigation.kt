package com.example.messfood.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.messfood.views.Screens.HomeScreen
import com.example.messfood.views.Screens.MoreMenu
import com.example.messfood.vm.FoodViewModel

@Composable
fun Navigation(foodViewModel: FoodViewModel)
{
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                foodViewModel = foodViewModel
            )
        }
        composable(route = Screen.MoreMenuScreen.route) {
            MoreMenu(
                navController = navController,
                foodViewModel = foodViewModel
            )
        }
    }
}