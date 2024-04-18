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
        String sql = "SELECT idmeal, strmeal, strinstructions, strtags, strmealthumb, stryoutube, " +
                "stringredient1, stringredient2, stringredient3, stringredient4, stringredient5, stringredient6, " +
                "stringredient7, stringredient8, stringredient9, stringredient10, stringredient11, stringredient12, " +
                "stringredient13, stringredient14, stringredient15, stringredient16, stringredient17, stringredient18, " +
                "stringredient19, stringredient20, strmeasure1, strmeasure2, strmeasure3, strmeasure4, strmeasure5, " +
                "strmeasure6, strmeasure7, strmeasure8, strmeasure9, strmeasure10, strmeasure11, strmeasure12, strmeasure13, " +
                "strmeasure14, strmeasure15, strmeasure16, strmeasure17, strmeasure18, strmeasure19, strmeasure20 FROM meals";
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
        String sql = "SELECT idmeal, user_id, strmeal,strinstructions, strmealthumb, strtags, stryoutube, " +
                "stringredient1, stringredient2, stringredient3, stringredient4, stringredient5, stringredient6, " +
                "stringredient7, stringredient8, stringredient9, stringredient10, stringredient11, stringredient12, " +
                "stringredient13, stringredient14, stringredient15, stringredient16, stringredient17, stringredient18, " +
                "stringredient19, stringredient20, strmeasure1, strmeasure2, strmeasure3, strmeasure4, strmeasure5, " +
                "strmeasure6, strmeasure7, strmeasure8, strmeasure9, strmeasure10, strmeasure11, strmeasure12, strmeasure13, " +
                "strmeasure14, strmeasure15, strmeasure16, strmeasure17, strmeasure18, strmeasure19, strmeasure20 " +
                "FROM meals WHERE user_id = ?;";
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
    // switched this to idmeal from mealID
    public Meal getMealById(int idmeal) {
        Meal meal = null;
        String sql = "SELECT idmeal, strmeal, strinstructions, strtags, strmealthumb, stryoutube," +
                "stringredient1, stringredient2, stringredient3, stringredient4, stringredient5, stringredient6, " +
                "stringredient7, stringredient8, stringredient9, stringredient10, stringredient11, stringredient12, " +
                "stringredient13, stringredient14, stringredient15, stringredient16, stringredient17, stringredient18, " +
                "stringredient19, stringredient20, strmeasure1, strmeasure2, strmeasure3, strmeasure4, strmeasure5, " +
                "strmeasure6, strmeasure7, strmeasure8, strmeasure9, strmeasure10, strmeasure11, strmeasure12, strmeasure13, " +
                "strmeasure14, strmeasure15, strmeasure16, strmeasure17, strmeasure18, strmeasure19, strmeasure20 " +
                "FROM meals WHERE idmeal = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, idmeal);
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
        String sql = "INSERT INTO meals (user_id,strmeal, strinstructions, strtags, strmealthumb, stryoutube, " +
                "stringredient1, stringredient2, stringredient3, stringredient4, stringredient5, stringredient6, " +
                "stringredient7, stringredient8, stringredient9, stringredient10, stringredient11, stringredient12, " +
                "stringredient13, stringredient14, stringredient15, stringredient16, stringredient17, stringredient18, " +
                "stringredient19, stringredient20, strmeasure1, strmeasure2, strmeasure3, strmeasure4, strmeasure5, " +
                "strmeasure6, strmeasure7, strmeasure8, strmeasure9, strmeasure10, strmeasure11, strmeasure12, strmeasure13, " +
                "strmeasure14, strmeasure15, strmeasure16, strmeasure17, strmeasure18, strmeasure19, strmeasure20 " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING idMeal";

            try {
                int mealId = jdbcTemplate.queryForObject(sql, int.class, meal.getUser_id(), meal.getStrmeal(), meal.getStrinstructions(),
                        meal.getStrtags(), meal.getStrmealthumb(), meal.getStryoutube(), meal.getStringredient1(),
                        meal.getStringredient2(), meal.getStringredient3(), meal.getStringredient4(), meal.getStringredient5(),
                        meal.getStringredient6(), meal.getStringredient7(), meal.getStringredient8(), meal.getStringredient9(),
                        meal.getStringredient10(), meal.getStringredient11(), meal.getStringredient12(), meal.getStringredient13(),
                        meal.getStringredient14(), meal.getStringredient15(), meal.getStringredient16(), meal.getStringredient17(),
                        meal.getStringredient18(), meal.getStringredient19(), meal.getStringredient20(), meal.getStrmeasure1(),
                        meal.getStrmeasure2(), meal.getStrmeasure3(), meal.getStrmeasure4(), meal.getStrmeasure5(), meal.getStrmeasure6(),
                        meal.getStrmeasure7(), meal.getStrmeasure8(), meal.getStrmeasure9(), meal.getStrmeasure10(), meal.getStrmeasure11(),
                        meal.getStrmeasure12(), meal.getStrmeasure13(), meal.getStrmeasure14(), meal.getStrmeasure15(), meal.getStrmeasure16(),
                        meal.getStrmeasure17(), meal.getStrmeasure18(), meal.getStrmeasure19(), meal.getStrmeasure20());
                newMeal = getMealById(mealId);
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            }
        return newMeal;
    }

    @Override
    public Meal updateMeal(Meal meal) {
        Meal newMeal = null;
        String sql = "UPDATE meals SET idmeal=?, strmeal=?, strinstructions=?, strtags=?, strmealthumb=?, stryoutube=?, " +
                "stringredient1=?, stringredient2=?, stringredient3=?, stringredient4=?, stringredient5=?, stringredient6=?, " +
                "stringredient7=?, stringredient8=?, stringredient9=?, stringredient10=?, stringredient11=?, stringredient12=?, " +
                "stringredient13=?, stringredient14=?, stringredient15=?, stringredient16=?, stringredient17=?, stringredient18=?, " +
                "stringredient19=?, stringredient20=?, strmeasure1=?, strmeasure2=?, strmeasure3=?, strmeasure4=?, strmeasure5=?, " +
                "strmeasure6=?, strmeasure7=?, strmeasure8=?, strmeasure9=?, strmeasure10=?, strmeasure11=?, strmeasure12=?, strmeasure13=?, " +
                "strmeasure14=?, strmeasure15=?, strmeasure16=?, strmeasure17=?, strmeasure18=?, strmeasure19=?, strmeasure20=? " +
                "WHERE idmeal=?";
        try {
            int numberOfRows = jdbcTemplate.update(sql, meal.getStrmeal(), meal.getStrinstructions(), meal.getStrtags(),
                    meal.getStrmealthumb(), meal.getStryoutube(), meal.getStringredient1(), meal.getStringredient2(),
                    meal.getStringredient3(), meal.getStringredient4(), meal.getStringredient5(), meal.getStringredient6(),
                    meal.getStringredient7(), meal.getStringredient8(), meal.getStringredient9(), meal.getStringredient10(),
                    meal.getStringredient11(), meal.getStringredient12(), meal.getStringredient13(), meal.getStringredient14(),
                    meal.getStringredient15(), meal.getStringredient16(), meal.getStringredient17(), meal.getStringredient18(),
                    meal.getStringredient19(), meal.getStringredient20(), meal.getStrmeasure1(), meal.getStrmeasure2(),
                    meal.getStrmeasure3(), meal.getStrmeasure4(), meal.getStrmeasure5(), meal.getStrmeasure6(), meal.getStrmeasure7(),
                    meal.getStrmeasure8(), meal.getStrmeasure9(), meal.getStrmeasure10(), meal.getStrmeasure11(), meal.getStrmeasure12(),
                    meal.getStrmeasure13(), meal.getStrmeasure14(), meal.getStrmeasure15(), meal.getStrmeasure16(), meal.getStrmeasure17(),
                    meal.getStrmeasure18(), meal.getStrmeasure19(), meal.getStrmeasure20(), meal.getIdmeal());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                newMeal = getMealById(meal.getIdmeal());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return newMeal;
    }

    @Override
    // changed this from id to idmeal
    public void deleteMeal(int idmeal) {
        String sql = "DELETE FROM meals WHERE idmeal = ?;";
        try {
            jdbcTemplate.update(sql, idmeal);
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
        meal.setStringredient1(results.getString("stringredient1"));
        meal.setStringredient2(results.getString("stringredient2"));
        meal.setStringredient3(results.getString("stringredient3"));
        meal.setStringredient4(results.getString("stringredient4"));
        meal.setStringredient5(results.getString("stringredient5"));
        meal.setStringredient6(results.getString("stringredient6"));
        meal.setStringredient7(results.getString("stringredient7"));
        meal.setStringredient8(results.getString("stringredient8"));
        meal.setStringredient9(results.getString("stringredient9"));
        meal.setStringredient10(results.getString("stringredient10"));
        meal.setStringredient11(results.getString("stringredient11"));
        meal.setStringredient12(results.getString("stringredient12"));
        meal.setStringredient13(results.getString("stringredient13"));
        meal.setStringredient14(results.getString("stringredient14"));
        meal.setStringredient15(results.getString("stringredient15"));
        meal.setStringredient16(results.getString("stringredient16"));
        meal.setStringredient17(results.getString("stringredient17"));
        meal.setStringredient18(results.getString("stringredient18"));
        meal.setStringredient19(results.getString("stringredient19"));
        meal.setStringredient20(results.getString("stringredient20"));

        meal.setStrmeasure1(results.getString("strmeasure1"));
        meal.setStrmeasure2(results.getString("strmeasure2"));
        meal.setStrmeasure3(results.getString("strmeasure3"));
        meal.setStrmeasure4(results.getString("strmeasure4"));
        meal.setStrmeasure5(results.getString("strmeasure5"));
        meal.setStrmeasure6(results.getString("strmeasure6"));
        meal.setStrmeasure7(results.getString("strmeasure7"));
        meal.setStrmeasure8(results.getString("strmeasure8"));
        meal.setStrmeasure9(results.getString("strmeasure9"));
        meal.setStrmeasure10(results.getString("strmeasure10"));
        meal.setStrmeasure11(results.getString("strmeasure11"));
        meal.setStrmeasure12(results.getString("strmeasure12"));
        meal.setStrmeasure13(results.getString("strmeasure13"));
        meal.setStrmeasure14(results.getString("strmeasure14"));
        meal.setStrmeasure15(results.getString("strmeasure15"));
        meal.setStrmeasure16(results.getString("strmeasure16"));
        meal.setStrmeasure17(results.getString("strmeasure17"));
        meal.setStrmeasure18(results.getString("strmeasure18"));
        meal.setStrmeasure19(results.getString("strmeasure19"));
        meal.setStrmeasure20(results.getString("strmeasure20"));

        return meal;
    }

}
