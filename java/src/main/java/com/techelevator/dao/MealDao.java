package com.techelevator.dao;

import com.techelevator.model.Meal;

import java.util.List;

public interface MealDao {

    List<Meal> getAllMeals();

    List<Meal> getAllMealsForUser(int userId);

    Meal getMealById(int idmeal);

    Meal addMeal(Meal meal);

    void deleteMeal(int idmeal);

    Meal updateMeal(Meal meal);

}
