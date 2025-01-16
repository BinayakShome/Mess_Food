package com.example.messfood.navigation

sealed class Screen(val route: String)
{
    object HomeScreen: Screen("HomeScreen")
    object MoreMenuScreen: Screen("MoreMenuScreen")
}