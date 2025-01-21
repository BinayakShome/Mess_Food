package com.example.messfood.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(
    entities = [FoodItem::class],
    version = 1
)
abstract class FoodDataBase : RoomDatabase() {
    abstract val dao: FoodItemDAO

    companion object {
        @Volatile
        private var INSTANCE: FoodDataBase? = null

        fun getInstance(context: Context): FoodDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodDataBase::class.java,
                    "food_database"
                )
                    .addCallback(FoodDatabaseCallback())
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    // Callback to populate the database on first creation with predefined SQL insertions
    private class FoodDatabaseCallback : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            // Insert predefined data using SQL statements that match the FoodItem schema
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Monday', 'Breakfast', 'Dahibada, Aludam / Bread, Butter, Jam, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Monday', 'Lunch', 'Rice, Roti, Dal, Piazi Aloo Curry, French Fry, Papad / Mixed Boiled vegetables')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Monday', 'Snacks', 'Papdi Chaat, Coffee')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Monday', 'Dinner', 'Rice, Roti, Dal, Matar Paneer, Rasgulla / Mixed Boiled vegetables')")

            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Tuesday', 'Breakfast', 'Bada-Ghugni / Corn Flakes')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Tuesday', 'Lunch', 'Rice, Roti, Dal, Gobi Aloo Curry / Egg Curry, Aloo Bhaja')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Tuesday', 'Snacks', 'Pasta, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Tuesday', 'Dinner', 'Rice, Roti, Mung Dal, Veg Manchurian / Boiled Vegetables, Kulfi')")

            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Wednesday', 'Breakfast', 'Bread, Jam, Butter, Omlet / cutlet, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Wednesday', 'Lunch', 'Rice, Roti, Dal, Fish Besar / Veg Manchurian, Aloo Chokha, Net Papad / Mixed Boiled Vegetables')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Wednesday', 'Snacks', 'Bread Pakoda, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Wednesday', 'Dinner', 'Rice, Roti, Dal, Chicken Hyderabadi / Paneer Hyderabadi, Papad, Mixed Boiled vegetables')")

            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Thursday', 'Breakfast', 'Pao - Bhaji, Coffee')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Thursday', 'Lunch', 'Jira Rice, Roti, Mung Dal, Soyabean Aloo Masala, Dahikadi Pakodi / Mixed Boiled vegetables')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Thursday', 'Snacks', 'Maggie, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Thursday', 'Dinner', 'Rice, Roti, Dal Makhani, Cabbage Matar Aloo Curry, Rice Kheer / Mixed Boiled Vegetables')")

            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Friday', 'Breakfast', 'Bread, Butter, Jam, Boiled Egg / Cutlet, Veg Chowmein / Egg Chowmein, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Friday', 'Lunch', 'Rice, Roti, Dal, Fish Masala, Malai Kofta, Aloo Karela Chips, Tomato Chutney / Mixed Boiled vegetables')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Friday', 'Snacks', 'Biscuits, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Friday', 'Dinner', 'Chicken Biriyani / Veg Biriyani')")

            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Saturday', 'Breakfast', 'Chole, Batura, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Saturday', 'Lunch', 'Rice, Roti, Dal, Khechudi, Aloo Chookha, Veg Manchurian, Papad , Dahi / Mixed Boiled vegetables')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Saturday', 'Snacks', 'Samosa, Coffee')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Saturday', 'Dinner', 'Rice, Roti, Dal, Chicken Mughlai / Kadai Paneer, Malpoa')")

            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Sunday', 'Breakfast', 'Dosa, Sambar, Chutney, Coffee')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Sunday', 'Lunch', 'Rice, Roti, Dal, Egg Masala / Chilli Sabji, Papad, Salad')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Sunday', 'Snacks', 'Sandwitch, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Sunday', 'Dinner', 'Fried Rice, Roti, Dal, Chilli Chicken, Chilli Paneer, Jalebi')")
        }
    }
}


