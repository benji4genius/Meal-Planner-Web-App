package com.techelevator.model;

import java.util.List;

public class MealPlan {
    private int mealPlanId;

    private String mealPlanName;

    private String mealPlanDescription;

    private List<Meal> mealList;

    public MealPlan(int mealPlanId, String mealPlanName, String mealPlanDescription, List<Meal> mealList) {
        this.mealPlanId = mealPlanId;
        this.mealPlanName = mealPlanName;
        this.mealPlanDescription = mealPlanDescription;
        this.mealList = mealList;
    }

    public int getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(int mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public String getMealPlanName() {
        return mealPlanName;
    }

    public void setMealPlanName(String mealPlanName) {
        this.mealPlanName = mealPlanName;
    }

    public String getMealPlanDescription() {
        return mealPlanDescription;
    }

    public void setMealPlanDescription(String mealPlanDescription) {
        this.mealPlanDescription = mealPlanDescription;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }
}
