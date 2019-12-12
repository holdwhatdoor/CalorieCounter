package com.example.caloriecounter.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "food_table")
public class FoodEntity {

    // Table Key Columns
    @PrimaryKey(autoGenerate = true)
    private int foodId = 0;
    // Table Columns
    private String foodName;
    private double calories;
    private double carbs;
    private double protein;
    private double fat;
    private String baseMeasure;

    // Empty constructor
    @Ignore
    public FoodEntity(){}

    // Constructor, no primary key id
    @Ignore
    public FoodEntity(String foodName, Double calories, Double carbs, Double protein, Double fat, String baseMeasure){
        this.foodName = foodName;
        this.calories = calories;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.baseMeasure = baseMeasure;
    }

    // Constructor with primary key id
    public FoodEntity(int foodId, String foodName, Double calories, Double carbs, Double protein, Double fat,
                      String baseMeasure){
        this.foodId = foodId;
        this.foodName = foodName;
        this.calories = calories;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.baseMeasure = baseMeasure;
    }

    // Getters
    public int getFoodId(){
        return foodId;
    }

    public String getFoodName(){
        return foodName;
    }

    public double getCalories(){
        return calories;
    }

    public double getCarbs(){
        return carbs;
    }

    public double getProtein(){
        return protein;
    }

    public double getFat(){
        return fat;
    }

    public String getBaseMeasure(){
        return baseMeasure;
    }

    // Setters
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setBaseMeasure(String baseMeasure) {
        this.baseMeasure = baseMeasure;
    }
}
