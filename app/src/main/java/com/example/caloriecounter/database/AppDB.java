package com.example.caloriecounter.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.caloriecounter.utilities.DataConverter;


@Database(entities = {FoodEntity.class, PortionedEntity.class,  MealEntity.class,
        ConsumedMeal.class},
        version = 1, exportSchema = false)
@TypeConverters(DataConverter.class)
public abstract class AppDB extends RoomDatabase {

    public static final String NUTRITION_DB = "AppDatabase.db";

    private static AppDB instance;
    private static final Object LOCK = new Object();


    public abstract FoodDAO foodDAO();

    public abstract PortionDAO portionDAO();

    public abstract MealDAO mealDAO();

    public abstract ConsumedMealDAO consumedMealDAO();

    public static synchronized AppDB getInstance(Context context){
        if(instance == null){
            synchronized (LOCK){
                if(instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(), AppDB.class,
                            NUTRITION_DB)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }

}
