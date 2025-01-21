package com.example.messfood.data

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class FoodRepository(context: Context) {

    private val foodDatabase = FoodDataBase.getInstance(context)
    private val foodDao = foodDatabase.dao

    private val predefinedFoodItems = listOf(
        FoodItem(day = "Monday", mealType = "Breakfast", dishes = "Dahibada, Aludam / Bread, Butter, Jam, Tea"),
        FoodItem(day = "Monday", mealType = "Lunch", dishes = "Rice, Roti, Dal, Piazi Aloo Curry, French Fry, Papad / Mixed Boiled vegetables"),
        FoodItem(day = "Monday", mealType = "Snacks", dishes = "Papdi Chaat, Coffee"),
        FoodItem(day = "Monday", mealType = "Dinner", dishes = "Rice, Roti, Dal, Matar Paneer, Rasgulla / Mixed Boiled vegetables"),

        FoodItem(day = "Tuesday", mealType = "Breakfast", dishes = "Bada-Ghugni / Corn Flakes "),
        FoodItem(day = "Tuesday", mealType = "Lunch", dishes = "Rice, Roti, Dal, Gobi Aloo Curry / Egg Curry, Aloo Bhaja"),
        FoodItem(day = "Tuesday", mealType = "Snacks", dishes = "Pasta, Tea"),
        FoodItem(day = "Tuesday", mealType = "Dinner", dishes = "Rice, Roti, Mung Dal, Veg Manchurian / Boiled Vegetables, Kulfi"),

        FoodItem(day = "Wednesday", mealType = "Breakfast", dishes = "Bread, Jam, Butter, Omlet / cutlet, Tea"),
        FoodItem(day = "Wednesday", mealType = "Lunch", dishes = "Rice, Roti, Dal, Fish Besar / Veg Manchurian, Aloo Chokha, Net Papad / Mixed Boiled Vegetables"),
        FoodItem(day = "Wednesday", mealType = "Snacks", dishes = "Bread Pakoda, Tea"),
        FoodItem(day = "Wednesday", mealType = "Dinner", dishes = "Rice, Roti, Dal, Chicken Hyderabadi / Paneer Hyderabadi, Papad, Mixed Boiled vegetables"),

        FoodItem(day = "Thursday", mealType = "Breakfast", dishes = "Pao - Bhaji, Coffee"),
        FoodItem(day = "Thursday", mealType = "Lunch", dishes = "Jira Rice, Roti, Mung Dal, Soyabean Aloo Masala, Dahikadi Pakodi / Mixed Boiled vegetables"),
        FoodItem(day = "Thursday", mealType = "Snacks", dishes = "Maggie, Tea"),
        FoodItem(day = "Thursday", mealType = "Dinner", dishes = "Rice, Roti, Dal Makhani, Cabbage Matar Aloo Curry, Rice Kheer / MIxed Boiled Vegetables"),

        FoodItem(day = "Friday", mealType = "Breakfast", dishes = "Bread, Butter, Jam, Boiled Egg / Cutlet, Veg Chowmein / Egg Chowmein, Tea"),
        FoodItem(day = "Friday", mealType = "Lunch", dishes = "Rice, Roti, Dal, Fish Masala, Malai Kofta, Aloo Karela Chips, Tomato Chutney / Mixed Boiled vegetables"),
        FoodItem(day = "Friday", mealType = "Snacks", dishes = "Biscuits, Tea"),
        FoodItem(day = "Friday", mealType = "Dinner", dishes = "Chicken Biriyani / Veg Biriyani"),

        FoodItem(day = "Saturday", mealType = "Breakfast", dishes = "Chole, Batura, Tea"),
        FoodItem(day = "Saturday", mealType = "Lunch", dishes = "Rice, Roti, Dal, Khechudi, Aloo Chookha, Veg Manchurian, Papad , Dahi / Mixed Boiled vegetables"),
        FoodItem(day = "Saturday", mealType = "Snacks", dishes = "Samosa, Coffee"),
        FoodItem(day = "Saturday", mealType = "Dinner", dishes = "Rice, Roti, Dal, Chicken Mughlai / Kadai Paneer, Malpoa"),

        FoodItem(day = "Sunday", mealType = "Breakfast", dishes = "Dosa, Sambar, Chutney, Coffee"),
        FoodItem(day = "Sunday", mealType = "Lunch", dishes = "Rice, Roti, Dal, Egg Masala / Chilli Sabji, Papad, Salad"),
        FoodItem(day = "Sunday", mealType = "Snacks", dishes = "Sandwitch, Tea"),
        FoodItem(day = "Sunday", mealType = "Dinner", dishes = "Fried Rice, Roti, Dal, Chilli Chicken, Chilli Paneer, Jalebi")
    )

    init {
        CoroutineScope(Dispatchers.IO).launch {

            val foodList = foodDao.getFoodItemsOrderedByDay().first()
            if (foodList.isEmpty()) {
                foodDao.insertAll(predefinedFoodItems)
            }
        }
    }

    fun getAllFoodItems() = foodDao.getFoodItemsOrderedByDay()

    suspend fun getFoodItemByDayAndMealType(day: String, mealType: String): FoodItem? {
        return foodDao.getFoodItemByDayAndMealType(day, mealType)
    }

    suspend fun updateFoodItem(foodItem: FoodItem) {
        foodDao.updateFoodItem(foodItem)
    }

    suspend fun resetMenuToDefault() {
        foodDao.clearAllFoodItems()
        foodDao.insertAll(predefinedFoodItems)
    }
}

