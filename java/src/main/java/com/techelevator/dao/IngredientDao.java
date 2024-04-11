package com.techelevator.dao;

import com.techelevator.model.Ingredient;

import java.util.List;

public interface IngredientDao {
    Ingredient getIngredientById(int idingredient);

    List<Ingredient> getListOfAllIngredients();

    Ingredient addIngredient (Ingredient ingredient);

    Ingredient updateIngredient (Ingredient ingredient);

    int deleteIngredient(int idingredient);

}
