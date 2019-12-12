package com.example.caloriecounter.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MealDAO {

    @Query("SELECT * FROM meal_table WHERE mealId = :id")
    MealEntity getMealById(int id);

    @Query("SELECT * FROM meal_table ORDER BY mealId")
    LiveData<List<MealEntity>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMeal(MealEntity mealEntity);

    @Delete
    void deleteMeal(MealEntity mealEntity);

}
