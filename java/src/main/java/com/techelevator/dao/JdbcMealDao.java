package com.techelevator.dao;

import com.techelevator.model.Meal;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcMealDao implements MealDao{

    private JdbcTemplate jdbcTemplate;


    private static final String SQL_SELECT_MEAL="";


    @Override
    public Meal getMealById(int mealId) {
        return null;
    }

    @Override
    public Meal getAllMeals() {
        return null;
    }

    @Override
    public Meal addMeal(Meal meal) {
        return null;
    }

    @Override
    public Meal deleteMeal(int mealId) {
        return null;
    }
}
