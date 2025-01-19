package com.example.messfood.navigation

sealed class Screen(val route: String)
{
    object HomeScreen: Screen("HomeScreen")
    object MoreMenuScreen: Screen("MoreMenuScreen")
    object FullWeekScreen: Screen("FullWeekScreen")
    object DevScreen: Screen("DevScreen")
    object UpdateScreen: Screen("UpdateScreen")
}