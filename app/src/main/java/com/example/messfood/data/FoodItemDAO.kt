package com.example.messfood.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodItemDAO {
    // Query to get food items ordered by day (Monday, Tuesday, etc.)
    @Query("SELECT * FROM FoodItem ORDER BY day ASC")
    fun getFoodItemsOrderedByDay(): Flow<List<FoodItem>>

    // Query to get food items ordered by meal type (Breakfast, Lunch, etc.)
    @Query("SELECT * FROM FoodItem ORDER BY mealType ASC")
    fun getFoodItemsOrderedByMealType(): Flow<List<FoodItem>>

    // Query to get food items ordered by dish name
    @Query("SELECT * FROM FoodItem ORDER BY dishes ASC")
    fun getFoodItemsOrderedByDescription(): Flow<List<FoodItem>>

    // Insert food items into the database
    @Insert
    suspend fun insertAll(foodItems: List<FoodItem>)
}

