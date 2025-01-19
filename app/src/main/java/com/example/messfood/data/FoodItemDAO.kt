package com.example.messfood.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
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

    // Query to get a specific food item by day and meal type
    @Query("SELECT * FROM FoodItem WHERE day = :day AND mealType = :mealType LIMIT 1")
    suspend fun getFoodItemByDayAndMealType(day: String, mealType: String): FoodItem?

    // Update an existing food item by its ID
    @Update
    suspend fun updateFoodItem(foodItem: FoodItem)

    @Query("DELETE FROM FoodItem")
    suspend fun clearAllFoodItems()
}


