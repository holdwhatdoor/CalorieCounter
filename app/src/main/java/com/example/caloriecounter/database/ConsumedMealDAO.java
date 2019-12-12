package com.example.caloriecounter.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.caloriecounter.database.ConsumedMeal;

import java.util.List;

@Dao
public interface ConsumedMealDAO {

    @Query("SELECT * FROM consumed_meal WHERE consumedId = :id")
    ConsumedMeal getConsumedMealById(int id);

    @Query("SELECT * FROM consumed_meal ORDER BY consumedId")
    LiveData<List<ConsumedMeal>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertConsumed(ConsumedMeal consumedMealEntity);

    @Delete
    void deleteConsumed(ConsumedMeal consumedMealEntity);

}
