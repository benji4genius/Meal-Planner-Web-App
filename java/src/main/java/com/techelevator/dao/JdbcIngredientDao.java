package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Ingredient;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcIngredientDao implements IngredientDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcIngredientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Ingredient getIngredientById(int idingredient) {
        Ingredient ingredient = null;
        String sql = "SELECT idingredient, stringredient, strdescription, strtype FROM ingredients WHERE idingredient = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, idingredient);
            if (results.next()) {
                ingredient = mapRowToIngredient(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return ingredient;
    }

    @Override
    public List<Ingredient> getListOfAllIngredients() {

            List<Ingredient> ingredients = new ArrayList<>();
            String sql = "SELECT idingredient, stringredient, strdescription, strtype " +
                    "FROM ingredients;";
            try {
                SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
                while (results.next()) {
                    Ingredient ingredient =  mapRowToIngredient(results);
                    ingredients.add(ingredient);
                }
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            }

            return ingredients;
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {



            Ingredient newIngredient = null;
            String sql = "INSERT INTO ingredients(" +
                    "stringredient, strdescription, strtype)" +
                    "VALUES (?, ?, ?); RETURNING idingredient;";
            try {
                int newIngredientId = jdbcTemplate.queryForObject(sql, int.class,ingredient.getStrdescription(),
                        ingredient.getStringredient(),ingredient.getStrtype());

                // might need some extra code here?

                newIngredient = getIngredientById(newIngredientId);
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            } catch (DataIntegrityViolationException e) {
                throw new DaoException("Data integrity violation", e);
            }
            return newIngredient;


    }

    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {

            Ingredient updatedIngredient = null;
            String sql = "UPDATE public.ingredients" +
                    "SET idingredient=?, stringredient=?, strdescription=?, strtype=?" +
                    "WHERE idingredient =?;";

            try {
                int numberOfRows = jdbcTemplate.update(sql, ingredient.getStrdescription(),
                        ingredient.getStringredient(),ingredient.getStrtype(), ingredient.getIdingredient());


                if (numberOfRows == 0) {
                    throw new DaoException("Zero rows affected, expected at least one");
                } else {
                    updatedIngredient = getIngredientById(ingredient.getIdingredient());
                }
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            } catch (DataIntegrityViolationException e) {
                throw new DaoException("Data integrity violation", e);
            }
            return updatedIngredient;

    }

    @Override
    public int deleteIngredient(int idingredient) {

            int numberOfRows = 0;
            String sql = "DELETE FROM ingredients WHERE idingredient = ?;";
            try {
                numberOfRows = jdbcTemplate.update(sql, idingredient);
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            } catch (DataIntegrityViolationException e) {
                throw new DaoException("Data integrity violation", e);
            }
            return numberOfRows;

    }


    private Ingredient mapRowToIngredient(SqlRowSet results){
        Ingredient ingredient = new Ingredient();
        ingredient.setIdingredient(results.getInt("idingredient"));
        ingredient.setStringredient(results.getString("stringredient"));
        ingredient.setStrdescription(results.getString("strdescription"));
        ingredient.setStrtype(results.getString("strtype"));

        return ingredient;
    }
}


      /* public Hero updateHero(Hero hero, int user_id) {
    Hero updatedHero = null;

    String sql = "UPDATE heroes SET hero_name = ?, " +
            "hero_health = ?, hero_defense = ?, hero_profession_id = ? WHERE hero_id = ? AND user_id=?;";
    try {
        int rowsAffected = jdbcTemplate.update(sql, hero.getName(), hero.getHealth(),
                hero.getDefense(), hero.getProfession().getProfessionId(), hero.getId(), user_id);

        if (rowsAffected == 0) {
            throw new DaoException("Zero rows affected, expected at least one");
        } else {
            updatedHero = getHeroById(hero.getId(), user_id);
        }
    } catch (CannotGetJdbcConnectionException e) {
        throw new DaoException("Unable to connect to server or database", e);
    } catch (DataIntegrityViolationException e) {
        throw new DaoException("Data integrity violation", e);
    }

    return updatedHero;*/