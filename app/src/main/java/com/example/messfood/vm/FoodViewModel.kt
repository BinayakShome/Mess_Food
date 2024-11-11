package com.example.messfood.vm

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

    init {
        viewModelScope.launch {
            repository.getAllFoodItems().collect { foodList ->
                _foodItems.value = foodList
            }
        }
    }
}
