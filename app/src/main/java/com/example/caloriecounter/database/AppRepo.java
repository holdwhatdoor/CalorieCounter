package com.example.caloriecounter.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepo {
    // Repository instance variable
    private static AppRepo repoInstance;
    // Live Data variables
    public LiveData<List<FoodEntity>> mFoods;
    public LiveData<List<PortionedEntity>> mPortions;
    public LiveData<List<MealEntity>> mMeals;
    public LiveData<List<ConsumedMeal>> mConsumed;

    // Database variable and executor
    private AppDB mDb;
    private Executor executor = Executors.newSingleThreadExecutor();

    // Returns instance of app repository
    public static AppRepo getInstance(Context context) {
        if (repoInstance == null) {
            repoInstance = new AppRepo(context);
        }
        return repoInstance;
    }

    // Gets all database repository information
    private AppRepo(Context context) {
        mDb = AppDB.getInstance(context);
        mFoods = getAllFoods();
        mPortions = getAllPortions();
        mMeals = getAllMeals();
        mConsumed = getAllConsumed();
    }

    // LiveData List getAllEntity methods
    public LiveData<List<FoodEntity>> getAllFoods() {
        return mDb.foodDAO().getAll();
    }

    public LiveData<List<PortionedEntity>> getAllPortions() {
        return mDb.portionDAO().getAll();
    }

    public LiveData<List<MealEntity>> getAllMeals() {
        return mDb.mealDAO().getAll();
    }

    public LiveData<List<ConsumedMeal>> getAllConsumed() {
        return mDb.consumedMealDAO().getAll();
    }

    public ConsumedMeal getConsumedById(int consumedId) { return mDb.consumedMealDAO().getConsumedMealById(consumedId); }
    public FoodEntity getFoodById(int foodId) { return mDb.foodDAO().getFoodById(foodId); }
    public MealEntity getMealById(int mealId) { return mDb.mealDAO().getMealById(mealId); }
    public PortionedEntity getPortionById(int portionedId){ return mDb.portionDAO().getPortionById(portionedId); }

    public void insertFood(final FoodEntity food){
        executor.execute(new Runnable() {
            @Override
            public void run() { mDb.foodDAO().insertFood(food);}
        });
    }

    public void deleteFood(final FoodEntity food){
        executor.execute(new Runnable() {
            @Override
            public void run() { mDb.foodDAO().deleteFood(food);}
        });
    }

    public void insertPortions(final PortionedEntity portion){
        executor.execute(new Runnable() {
            @Override
            public void run() { mDb.portionDAO().insertPortion(portion);}
        });
    }
}
