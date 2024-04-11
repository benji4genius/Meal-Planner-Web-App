package com.techelevator.dao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Meal;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
public class JdbcMealDao implements MealDao {
    private final JdbcTemplate jdbcTemplate;
    /*private String MEAL_SELECTION = "SELECT idmeal, strmeal, strdrinkalternate, strcategory, strarea, strinstructions, strmealthumb, " +
            "strtags, stryoutube, stringredient1, stringredient2, stringredient3, stringredient4, stringredient5, stringredient6, stringredient7, " +
            "stringredient8, stringredient9, stringredient10, stringredient11, stringredient12, stringredient13, stringredient14, stringredient15," +
            " stringredient16, stringredient17, stringredient18, stringredient19, stringredient20, strmeasure1, strmeasure2, strmeasure3, strmeasure4, strmeasure5," +
            " strmeasure6, strmeasure7, strmeasure8, strmeasure9, strmeasure10, strmeasure11, strmeasure12, strmeasure13, strmeasure14, strmeasure15, strmeasure16, " +
            "strmeasure17, strmeasure18, strmeasure19, strmeasure20, strsource, strimagesource, strcreativecommonsconfirmed, datemodified, user_id" +
            "FROM public.meals";

    private String MEAL_UPDATE_SELECTION = "UPDATE meals" +
            "SET strmeal=?, strdrinkalternate=?, strcategory=?, strarea=?, strinstructions=?, strmealthumb=?, strtags=?, " +
            "stryoutube=?, stringredient1=?, stringredient2=?, stringredient3=?, stringredient4=?, stringredient5=?, stringredient6=?, " +
            "stringredient7=?, stringredient8=?, stringredient9=?, stringredient10=?, stringredient11=?, stringredient12=?, stringredient13=?, " +
            "stringredient14=?, stringredient15=?, stringredient16=?, stringredient17=?, stringredient18=?, stringredient19=?, stringredient20=?, " +
            "strmeasure1=?, strmeasure2=?, strmeasure3=?, strmeasure4=?, strmeasure5=?, strmeasure6=?, strmeasure7=?, strmeasure8=?, strmeasure9=?, strmeasure10=?," +
            " strmeasure11=?, strmeasure12=?, strmeasure13=?, strmeasure14=?, strmeasure15=?, strmeasure16=?, strmeasure17=?, strmeasure18=?, strmeasure19=?, strmeasure20=?," +
            " strsource=?, strimagesource=?, strcreativecommonsconfirmed=?, datemodified=?, user_id=?";

    private String MEAL_INSERT_SELECTION = "INSERT INTO public.meals(" +
            "idmeal, strmeal, strdrinkalternate, strcategory, strarea, strinstructions, strmealthumb, strtags, stryoutube, stringredient1, stringredient2, stringredient3, stringredient4, stringredient5, stringredient6, stringredient7, stringredient8, stringredient9, stringredient10, stringredient11, stringredient12, stringredient13, stringredient14, stringredient15, stringredient16, stringredient17, stringredient18, stringredient19, stringredient20, strmeasure1, strmeasure2, strmeasure3, strmeasure4, strmeasure5, strmeasure6, strmeasure7, strmeasure8, strmeasure9, strmeasure10, strmeasure11, strmeasure12, strmeasure13, strmeasure14, strmeasure15, strmeasure16, strmeasure17, strmeasure18, strmeasure19, strmeasure20, strsource, strimagesource, strcreativecommonsconfirmed, datemodified, user_id)\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"*/


    public JdbcMealDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Meal> getAllMeals() {
        List<Meal> allMeals = new ArrayList<>();
        String sql = "SELECT idmeal, strmeal, strinstructions, strtags, strmealthumb, stryoutube FROM meals";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()){
                Meal newMeal= mapRowToMeal(results);
                allMeals.add(newMeal);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);

        }
        return allMeals;
    }
    //getAllMealsForUSer(userId)
    @Override
    public List<Meal> getAllMealsForUser(int userId) {
        List<Meal> allMeals = new ArrayList<>();
        String sql = "SELECT idmeal, strmeal, strinstructions, strtags, strmealthumb, stryoutube FROM meals " +
                    "WHERE userId = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while(results.next()){
                Meal newMeal= mapRowToMeal(results);
                allMeals.add(newMeal);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);

        }
        return allMeals;
    }
    @Override
    public Meal getMealById(int mealId) {
        Meal meal = null;
        String sql = "SELECT idmeal, strmeal, strinstructions, strtags, strmealthumb, stryoutube FROM meals " +
                "WHERE idmeal = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, mealId);
            if(results.next()){
                meal = mapRowToMeal(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return meal;
    }

    @Override
    public Meal addMeal(Meal meal) {
        Meal newMeal = null;
        String sql = "INSERT INTO meals (strmeal, strinstructions, strtags, strmealthumb, stryoutube) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING idMeal";
        try {
            int mealId = jdbcTemplate.queryForObject(sql, int.class, meal.getStrmeal(), meal.getStrinstructions(),
                         meal.getStrtags(), meal.getStrmealthumb(), meal.getStryoutube());
            newMeal = getMealById(mealId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return newMeal;
    }

    @Override
    public Meal updateMeal(Meal meal) {
        Meal newMeal = null;
        String sql = "UPDATE meals SET strmeal=?, strinstructions=?, strtags=?, strmealthumb=?, stryoutube=?" +
                "WHERE idmeal=?";
        try {
            int numberOfRows = jdbcTemplate.update(sql, meal.getIdmeal(), meal.getStrmeal(), meal.getStrinstructions(),
                               meal.getStrtags(), meal.getStrmealthumb(), meal.getStryoutube());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                newMeal = getMealById(meal.getIdmeal());
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return newMeal;
    }

    @Override
    public void deleteMeal(int id) {
        String sql = "DELETE FROM meals WHERE idmeal = ?;";
        try {
            jdbcTemplate.update(sql, id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
    }


    public Meal mapRowToMeal(SqlRowSet results) {
        Meal meal = new Meal();
        meal.setIdmeal(results.getInt("idmeal"));
        meal.setStrmeal(results.getString("strmeal"));
        meal.setStrinstructions(results.getString("strinstructions"));
        meal.setStrtags(results.getString("strtags"));
        meal.setStrmealthumb(results.getString("strmealthumb"));
        meal.setStryoutube(results.getString("stryoutube"));
        return meal;
    }

}
