package com.example.messfood.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FoodItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // Unique ID
    val day: String, // Monday, Tuesday, etc.
    val mealType: String, // Breakfast, Lunch, Dinner, Snacks
    val dishes: String // The dish served
)
