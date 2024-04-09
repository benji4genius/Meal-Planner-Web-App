package com.techelevator.dao;
import java.util.List;
import java.util.ArrayList;

import com.techelevator.model.Meal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class JdbcMealDao implements MealDao{

    private final JdbcTemplate jdbcTemplate;
    //private static final String SQL_SELECT_MEAL="";

    public JdbcMealDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Meal> getAllMeals() {
        List<Meal> allMeals = new ArrayList<>();
        String sql = "";
    }

    @Override
    public Meal getMealById(int mealId) {
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