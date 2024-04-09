package com.techelevator.dao;

import com.techelevator.model.Ingredient;

import java.util.List;

public interface IngredientDao {
    public Ingredient getIngredientById(int ingredientId);

    public List<Ingredient> getListOfAllIngredients();

    public Ingredient addIngredient (Ingredient ingredient);

    public Ingredient updateIngredient (Ingredient ingredient);

    public Ingredient deleteIngredient (int ingredientID);

}
