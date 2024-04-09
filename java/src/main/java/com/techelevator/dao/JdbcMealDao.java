package com.techelevator.dao;
import com.techelevator.model.Meal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcMealDao implements MealDao{

    private final JdbcTemplate jdbcTemplate;
    //private static final String SQL_SELECT_MEAL="";

    public JdbcMealDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Meal> getAllMeals() {
        String sql = "SELECT * FROM meals";
        return jdbcTemplate.query(sql, newMealMapper());
    }

    @Override
    public Meal getMealById(int idmeal) {
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
    private static class MealMapper implements RowMapper<Meal> {
        @Override
        public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
            Meal meal = new Meal();
            meal.setIdmeal(rs.getInt("idmeal"));
            meal.setStrmeal(rs.getString("strmeal"));
            meal.setStrcategory(rs.getString("strcategory"));
            meal.setStrinstructions(rs.getString("strinstructions"));
            meal.setStrtags(rs.getString("strtags"));
            meal.setStryoutube(rs.getString("stryoutube"));
            return meal;
        }
    }
}
}
