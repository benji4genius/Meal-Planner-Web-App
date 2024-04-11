package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.MealPlan;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMealPlanDao implements MealPlanDao {
    private final JdbcTemplate jdbcTemplate;
    public JdbcMealPlanDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MealPlan> getAllMealPlans() {
        List<MealPlan> allMealPlans = new ArrayList<>();
        String sql = "SELECT meal_plan_id, user_id, name, description FROM meal_plans";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()){
                MealPlan newMealPlan = mapRowToMealPlans(results);
                allMealPlans.add(newMealPlan);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return allMealPlans;
    }

    @Override
    public List<MealPlan> getAllMealPlansForUser(int userId) {
        List<MealPlan> allMealPlans = new ArrayList<>();
        String sql = "SELECT meal_plan_id, user_id, name, description FROM meal_plans " +
                     "WHERE user_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while(results.next()){
                MealPlan newMealPlan = mapRowToMealPlans(results);
                allMealPlans.add(newMealPlan);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return allMealPlans;
    }

    @Override
    public MealPlan getMealPlanById(int mealPlanId) {
        MealPlan mealPlan = null;
        String sql = "SELECT meal_plan_id, user_id, name, description FROM meal_plans " +
                "WHERE meal_plan_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, mealPlanId);
            if(results.next()){
                mealPlan = mapRowToMealPlans(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return mealPlan;
    }

    @Override
    public MealPlan addMealPlan(MealPlan mealPlan) {
        if (mealPlan == null) {
            throw new IllegalArgumentException("mealPlan cannot be null"); //might be a better way to do this
        }

        String sql = "INSERT INTO meal_plans (user_id, name, description) " +
                "VALUES (?, ?, ?) RETURNING meal_plan_id";
        try {
            int newMealPlanId = jdbcTemplate.queryForObject(sql, int.class, mealPlan.getUser_id(), mealPlan.getName(),
                                mealPlan.getDescription()); //may produce null pointer exception
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return mealPlan;
    }

    @Override
    public MealPlan updateMealPlan(MealPlan mealPlan) {
        if (mealPlan == null || mealPlan.getMeal_plan_id() == 0) {
            //handle invalid input(null mealPlan or missing meal_plan_id)
            return null;
        }

        String sql = "UPDATE meal_plans SET name = ?, description = ? WHERE meal_plan_id = ?";
        try {
            int rowsUpdated = jdbcTemplate.update(sql, mealPlan.getName(), mealPlan.getDescription(), mealPlan.getMeal_plan_id());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return mealPlan;
    }

    @Override
    public void deleteMealPlan(int mealPlanId) {
        String sql = "DELETE FROM meal_plans WHERE meal_plan_id = ?";
        try {
            int rowsDeleted = jdbcTemplate.update(sql, mealPlanId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
    }

    public MealPlan mapRowToMealPlans(SqlRowSet results) {
        MealPlan mealPlan = new MealPlan();
        mealPlan.setMeal_plan_id(results.getInt("meal_plan_id"));
        mealPlan.setDescription(results.getString("description"));
        mealPlan.setName(results.getString("name"));
        return mealPlan;
    }

}
