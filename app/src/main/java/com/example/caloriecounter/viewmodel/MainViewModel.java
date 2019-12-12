package com.example.caloriecounter.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.caloriecounter.database.AppRepo;
import com.example.caloriecounter.database.ConsumedMeal;
import com.example.caloriecounter.database.FoodEntity;
import com.example.caloriecounter.database.MealEntity;
import com.example.caloriecounter.database.PortionedEntity;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainViewModel extends AndroidViewModel {

    // Mutable live data variables
    public MutableLiveData<FoodEntity> mLiveFood = new MutableLiveData<>();
    public MutableLiveData<List<FoodEntity>> mLiveFoods = new MutableLiveData<>();
    public LiveData<FoodEntity> mFood;
    public LiveData<List<FoodEntity>> mFoods;

    public MutableLiveData<ConsumedMeal> mLiveConsume = new MutableLiveData<>();
    public MutableLiveData<List<ConsumedMeal>> mLiveConsumed = new MutableLiveData<>();
    public LiveData<ConsumedMeal> mConsume;
    public LiveData<List<ConsumedMeal>> mConsumed;

    public MutableLiveData<MealEntity> mLiveMeal = new MutableLiveData<>();
    public MutableLiveData<List<MealEntity>> mLiveMeals = new MutableLiveData<>();
    public LiveData<MealEntity> mMeal;
    public LiveData<List<MealEntity>> mMeals;

    public MutableLiveData<PortionedEntity> mLivePortion = new MutableLiveData<>();
    public MutableLiveData<List<PortionedEntity>> mLivePortions = new MutableLiveData<>();
    public LiveData<PortionedEntity> mPortion;
    public LiveData<List<PortionedEntity>> mPortions;

    public static AppRepo mRepo;
    public Executor executor = Executors.newSingleThreadExecutor();

    public MainViewModel(@NonNull Application application) {
        super(application);

        mRepo = AppRepo.getInstance(getApplication());
        mConsumed = mRepo.mConsumed;
        mFoods = mRepo.mFoods;
        mMeals = mRepo.mMeals;
        mPortions = mRepo.mPortions;

    }

    // Method to get ids of portioned meal items from a string of ids separated by a colon(:)
    public static int[] getMealItemIds(String portionedIds){
        int[] mealItemIdArray = null;
        String[] stringIdArray = null;
        if(portionedIds != null) {
            stringIdArray = portionedIds.split(":");
            mealItemIdArray = new int[stringIdArray.length];
            for(int i = 0; i < stringIdArray.length; i++){
                mealItemIdArray[i] = Integer.parseInt(stringIdArray[i]);
            }
        }
        return mealItemIdArray;
    }

    // Method to return PortionedEntity variable from an integer array of portion ids that comprise a meal
    public static PortionedEntity getPortionedEntity(int[] mealItemIdArray){
        PortionedEntity item = null;

        if(mealItemIdArray != null){
            for(int i = 0; i < mealItemIdArray.length; i++){
                item = mRepo.getPortionById(mealItemIdArray[i]);
            }
        }

        return item;
    }
}
