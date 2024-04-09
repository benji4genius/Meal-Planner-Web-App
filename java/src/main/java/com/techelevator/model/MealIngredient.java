package com.techelevator.model;
public class MealIngredient extends Ingredient{

    private int mealId;
    private String measurement;

    public MealIngredient(){};

    public MealIngredient(int ingredientId, String ingredientName, String ingredientDescription, int mealId, String measurement){
        super(ingredientId, ingredientName, ingredientDescription);
        this.mealId = mealId;
        this.measurement = measurement;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
}
