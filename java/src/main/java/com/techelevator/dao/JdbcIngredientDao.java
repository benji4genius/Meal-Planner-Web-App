package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Ingredient;
import com.techelevator.model.User;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcIngredientDao implements IngredientDao {
    private final JdbcTemplate jdbcTemplate;
    public jdbcIngredientDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Ingredient getIngredientById(int idIngredient) {
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


    private Ingredient mapRowToIngredient(SqlRowSet result){
        Ingredient ingredient = new Ingredient();
        ingredient.setIdingredient(result.getInt("idingredient"));
        ingredient.setStringredient(result.getString("stringredient"));
        ingredient.setStrdescription(result.getString("strdescription"));

        return ingredient;
    }
}
