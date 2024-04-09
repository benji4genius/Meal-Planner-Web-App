package com.techelevator.dao;
import com.techelevator.model.Meal;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class JdbcMealDao implements MealDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcMealDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Meal> getAllMeals() {
        List<Meal> allMeals = new ArrayList<>();
        String sql = "SELECT idmeal, strmeal, strcategory, strinstructions, strtags, stryoutube FROM meals";
        try {
            RowMapper<Meal> rowMapper = new MealMapper();
            allMeals = jdbcTemplate.query(sql, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allMeals;
    }

    @Override
    public Meal getMealById(int mealId) {
        Meal meal = null;
        String sql = "SELECT idmeal, strmeal, strinstructions, strtags, stryoutube FROM meals " +
                "WHERE idmeal = ?;";
        try {
            RowMapper<Meal> rowMapper = new MealMapper();
            meal = jdbcTemplate.queryForObject(sql, rowMapper, mealId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return meal;
    }

    @Override
    public Meal addMeal(Meal meal) {
        String sql = "INSERT INTO meals (strmeal, strinstructions, strtags, stryoutube) " +
                "VALUES (?, ?, ?, ?, ?);";
            jdbcTemplate.update(sql, meal.getStrmeal(), meal.getStrinstructions(),
                    meal.getStrtags(), meal.getStryoutube());

            return meal;
    }

 //void since it doesn't return any value
    public void deleteMeal(Meal meal) {
       String sql = "DELETE FROM meals WHERE idmeal = ?;";
           jdbcTemplate.update(sql, meal.getIdmeal());
       }

        public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
            Meal meal = new Meal();
            meal.setIdmeal(rs.getInt("idmeal"));
            meal.setStrmeal(rs.getString("strmeal"));
            meal.setStrinstructions(rs.getString("strinstructions"));
            meal.setStrtags(rs.getString("strtags"));
            meal.setStryoutube(rs.getString("stryoutube"));
            return meal;
        }
    }