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

    private class FoodDatabaseCallback : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Monday', 'Breakfast', 'Dahibada, Aludam / Bread, Butter, Jam, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Monday', 'Lunch', 'Rice, Roti, Dal, Piazi Aloo Curry, French Fry, Papad')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Monday', 'Snacks', 'Papdi Chaat, Coffee')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Monday', 'Dinner', 'Rice, Roti, Dal, Matar Paneer, Rasgulla')")

            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Tuesday', 'Breakfast', 'Bada-Ghugni / Uttapam Sambar, Coffee')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Tuesday', 'Lunch', 'Rice, Roti, Dal, Gobi Aloo Curry / Egg Curry, Aloo Bhaja')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Tuesday', 'Snacks', 'Pasta, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Tuesday', 'Dinner', 'Rice, Roti, Mung Dal, Veg Manchurian, Jalebi')")

            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Wednesday', 'Breakfast', 'Bread, Jam, Butter, Omlet / Cutlet, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Wednesday', 'Lunch', 'Rice, Roti, Dal, Fish Besar / Veg Manchurian, Aloo Chokha, Net Papad')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Wednesday', 'Snacks', 'Bread Pakoda, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Wednesday', 'Dinner', 'Rice, Roti, Dal, Chicken Hyderabadi / Paneer Hyderabadi, Papad')")

            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Thursday', 'Breakfast', 'Pao-Bhaji, Coffee')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Thursday', 'Lunch', 'Jira Rice, Roti, Mung Dal, Soyabean, Aloo Masala, Dahikadi Pakodi')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Thursday', 'Snacks', 'Maggie, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Thursday', 'Dinner', 'Rice, Roti, Dal Makhani, Chili-Gobi, Gajar ka Halwa')")

            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Friday', 'Breakfast', 'Veg Chowmin / Egg Chowmin / Bread, Butter, Jam, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Friday', 'Lunch', 'Rice, Roti, Dal, Fish Masala / Malai Kofta, Aloo Karela Chips, Tomato Chutney')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Friday', 'Snacks', 'Biscuits, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Friday', 'Dinner', 'Chicken Biriyani / Veg Biriyani, Dahi Raita')")

            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Saturday', 'Breakfast', 'Chole, Batura / Bread, Butter, Jam, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Saturday', 'Lunch', 'Rice, Roti, Dal, Khechudi, Aloo Chokha, Veg Manchurian, Papad , Dahi')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Saturday', 'Snacks', 'Samosa, Coffee')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Saturday', 'Dinner', 'Rice, Roti, Dal, Chicken Mughlai / Kadai Paneer, Malpua')")

            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Sunday', 'Breakfast', 'Dosa, Sambar / Bread, Butter, Jam, Coffee')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Sunday', 'Lunch', 'Rice, Roti, Dal, Egg Masala / Chilli Soyabean, Papad, Salad')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Sunday', 'Snacks', 'Sandwitch, Tea')")
            db.execSQL("INSERT INTO FoodItem (day, mealType, dishes) VALUES ('Sunday', 'Dinner', 'Fried Rice, Roti, Dal, Chilli Chicken / Chilli Paneer, Kulfi')")
        }
    }
}