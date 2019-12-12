package com.example.caloriecounter.database;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "portioned_table")
public class PortionedEntity {

    //Table Key Columns
    @PrimaryKey(autoGenerate = true)
    private int portionedId = 0;
    @ForeignKey(entity = FoodEntity.class, parentColumns = "foodId", childColumns = "portionedId")
    private int foodId;
    // Table Columns
    private String measureType;
    private Double quantity;
    private String description;
    private Double pCals;
    private Double pCarbs;
    private Double pPro;
    private Double pFat;

    // Empty constructor
    @Ignore
    public PortionedEntity(){}

    // Constructor, no primary key id
    @Ignore
    public PortionedEntity(int foodID, String measureType, Double quantity, String description, Double pCals,
                           Double pCarbs, Double pPro, Double pFat){
        this.foodId = foodID;
        this.measureType = measureType;
        this.quantity = quantity;
        this.description = description;
        this.pCals = pCals;
        this.pCarbs = pCarbs;
        this.pPro = pPro;
        this.pFat = pFat;
    }

    // Constructor with primary key id
    public PortionedEntity(int portionedId, int foodId, String measureType, Double quantity, String description,
                           Double pCals, Double pCarbs, Double pPro, Double pFat){
        this.portionedId = portionedId;
        this.foodId = foodId;
        this.measureType = measureType;
        this.quantity = quantity;
        this.description = description;
        this.pCals = pCals;
        this.pCarbs = pCarbs;
        this.pPro = pPro;
        this.pFat = pFat;
    }

    // Getters
    public int getPortionedId(){
        return portionedId;
    }

    public int getFoodId(){
        return foodId;
    }

    public String getMeasureType(){
        return measureType;
    }

    public Double getQuantity(){
        return quantity;
    }

    public String getDescription(){
        return description;
    }

    public Double getPCals(){
        return pCals;
    }

    public Double getPCarbs(){
        return pCarbs;
    }

    public Double getPPro(){
        return pPro;
    }

    public Double getPFat(){
        return pFat;
    }

    // Setters
    public void setPortionedId(int portionedId) {
        this.portionedId = portionedId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPCals(Double pCals) {
        this.pCals = pCals;
    }

    public void setPCarbs(Double pCarbs) {
        this.pCarbs = pCarbs;
    }

    public void setPPro(Double pPro) {
        this.pPro = pPro;
    }

    public void setPFat(Double pFat) {
        this.pFat = pFat;
    }

}
