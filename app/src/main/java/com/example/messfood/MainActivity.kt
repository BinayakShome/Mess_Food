package com.example.messfood

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.messfood.data.FoodRepository
import com.example.messfood.navigation.Navigation
import com.example.messfood.ui.theme.MessFoodTheme
import com.example.messfood.vm.FoodViewModel
import com.example.messfood.vm.FoodViewModelFactory

class MainActivity : ComponentActivity() {

    private lateinit var foodRepository: FoodRepository
    private lateinit var foodViewModel: FoodViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        foodRepository = FoodRepository(applicationContext)

        foodViewModel = ViewModelProvider(this, FoodViewModelFactory(foodRepository)).get(FoodViewModel::class.java)

        enableEdgeToEdge()
        setContent {
            MessFoodTheme {
                Navigation(foodViewModel)
            }
        }
    }
}

