package com.example.messfood.vm

import android.util.Log
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.messfood.data.FoodItem
import com.example.messfood.data.FoodRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FoodViewModel(private val repository: FoodRepository) : ViewModel() {

    // Expose food items as LiveData/State
    private val _foodItems = MutableStateFlow<List<FoodItem>>(emptyList())
    val foodItems: StateFlow<List<FoodItem>> get() = _foodItems
    private val _snackbarMessage = MutableStateFlow<String?>(null)
    val snackbarMessage: StateFlow<String?> = _snackbarMessage

    init {
        viewModelScope.launch {
            repository.getAllFoodItems().collect { foodList ->
                _foodItems.value = foodList
            }
        }
    }

    fun updateMenu(day: String, mealType: String, newDishes: String) {
        viewModelScope.launch {
            try {
                val foodItem = repository.getFoodItemByDayAndMealType(day, mealType)
                if (foodItem != null) {
                    val updatedFoodItem = foodItem.copy(dishes = newDishes)
                    repository.updateFoodItem(updatedFoodItem)
                    _snackbarMessage.value = "Hurray!! Menu updated successfully!"
                    Log.d("FoodViewModel", "Found FoodItem: $foodItem, updating dishes to: $newDishes")
                }else{
                    Log.d("FoodViewModel", "FoodItem not found for $day - $mealType")
                    _snackbarMessage.value = "Oh no!! Something wrong happened"
                }
            } catch (e: Exception) {
                // Handle any potential errors
                e.printStackTrace()
                Log.e("FoodViewModel", "Error while updating: ${e.message}")
            }
        }
    }

    fun resetMenu() {
        viewModelScope.launch {
            try {
                repository.resetMenuToDefault()
                _snackbarMessage.value = "Menu reset successfully!"
                Log.e("Reset", "Success")
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("Reset","Error")
            }
        }
    }

    fun clearSnackbarMessage() {
        _snackbarMessage.value = null
    }
}
