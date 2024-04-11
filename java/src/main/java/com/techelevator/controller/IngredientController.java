package com.techelevator.controller;

import com.techelevator.dao.IngredientDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Ingredient;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ingredients") //maybe
public class IngredientController {

    private IngredientDao ingredientDao;


    public IngredientController(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }


    @RequestMapping(path = "/{idingredient}", method = RequestMethod.GET)
    public Ingredient getIngredientById(@PathVariable int idingredient) {
        Ingredient ingredient;
        try {
            ingredient = ingredientDao.getIngredientById(idingredient);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ingredient;
    }
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Ingredient> getIngredients() {
        try {
            return ingredientDao.getListOfAllIngredients();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Ingredient createIngredient(@Valid @RequestBody Ingredient newIngredient) {
        try {
            return ingredientDao.addIngredient(newIngredient);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{idingredient}", method = RequestMethod.PUT)
    public Ingredient updateIngredient(@Valid @RequestBody Ingredient ingredient, @PathVariable int idingredient) {
        // The id on the path takes precedence over the one in the request body, if any
        ingredient.setIdingredient(idingredient);
        try {
            Ingredient updatedIngredient = ingredientDao.updateIngredient(ingredient);
            return updatedIngredient;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found.");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{idingredient}", method = RequestMethod.DELETE)
    public void deleteIngredient(@PathVariable int idingredient) {
        ingredientDao.deleteIngredient(idingredient);
    }

}
