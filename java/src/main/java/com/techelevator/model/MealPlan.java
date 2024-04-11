package com.techelevator.model;

import java.util.List;

public class MealPlan {
    private int meal_plan_id;

    private String name;

    private String description;

    private List<Meal> mealList;

    private int user_id;

    public MealPlan(){};

    public MealPlan(int meal_plan_id, String name, String description, List<Meal> mealList, int user_id) {
        this.meal_plan_id = meal_plan_id;
        this.name = name;
        this.description = description;
        this.mealList = mealList;
        this.user_id = user_id;
    }

    public int getMeal_plan_id() {
        return meal_plan_id;
    }

    public void setMeal_plan_id(int meal_plan_id) {
        this.meal_plan_id = meal_plan_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Meal> getMealList() { //do we need this, it hasn't been called
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    public int getUser_id() {
        return user_id;
    }
}
