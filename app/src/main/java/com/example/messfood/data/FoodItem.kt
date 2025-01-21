package com.example.messfood.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FoodItem")
data class FoodItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val day: String,
    val mealType: String,
    val dishes: String
)
