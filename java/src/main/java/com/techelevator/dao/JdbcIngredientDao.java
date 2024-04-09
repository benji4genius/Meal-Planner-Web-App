package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcIngredientDao implements IngredientDao {


    private Ingredient mapRowToIngredient(SqlRowSet result){
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(result.getInt("idingredient"));
        ingredient.setIngredientName(result.getString("stringredient"));
        ingredient.setIngredientDescription(result.getString("strdescription"));

        return ingredient;
    }
}
