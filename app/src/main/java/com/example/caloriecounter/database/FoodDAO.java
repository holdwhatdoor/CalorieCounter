package com.example.caloriecounter.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FoodDAO {

    @Query("SELECT * FROM food_table WHERE foodId = :id")
    FoodEntity getFoodById(int id);

    @Query("SELECT * FROM food_table ORDER BY foodId")
    LiveData<List<FoodEntity>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFood(FoodEntity foodEntity);

    @Delete
    void deleteFood(FoodEntity foodEntity);

}
