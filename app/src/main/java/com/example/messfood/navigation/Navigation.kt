package com.example.messfood.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.messfood.views.Screens.DevScreen
import com.example.messfood.views.Screens.FullWeekScreen
import com.example.messfood.views.Screens.HomeScreen
import com.example.messfood.views.Screens.MoreMenu
import com.example.messfood.views.Screens.UpdateScreen
import com.example.messfood.vm.FoodViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(foodViewModel: FoodViewModel)
{
    val navController = rememberNavController()

    AnimatedNavHost(navController = navController, startDestination = Screen.HomeScreen.route){

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
        composable(route = Screen.FullWeekScreen.route) {
            FullWeekScreen(
                navController = navController,
                foodViewModel = foodViewModel
            )
        }
        composable(route = Screen.DevScreen.route) {
            DevScreen(
                navController = navController
            )
        }
        composable(route = Screen.UpdateScreen.route) {
            UpdateScreen(
                navController = navController,
                foodViewModel = foodViewModel
            )
        }
    }
}