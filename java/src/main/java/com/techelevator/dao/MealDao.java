package com.techelevator.dao;

import com.techelevator.model.Meal;

public interface MealDao {

Meal getMealById( int mealId);


Meal getAllMeals();

Meal addMeal(Meal meal);

Meal deleteMeal( int mealId);






}
