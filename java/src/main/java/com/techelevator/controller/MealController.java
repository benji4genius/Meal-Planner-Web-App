package com.techelevator.controller;

import com.techelevator.dao.MealDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Meal;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/meals")
@PreAuthorize("isAuthenticated()") // For user Authentication?
public class MealController {
    private MealDao mealDao;

    // Might need to add userDao Here but not completely sure
    // Also might need to add int user_id to our JDBCmealDao and maybe JDBCmealPlanDao as well

    public MealController(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET) //Not completely sure about this path here
    public List<Meal> getMeals() {
        try {
            return mealDao.getAllMeals();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{/idmeal}", method = RequestMethod.GET)
    public Meal getMealById(@PathVariable int idmeal) {
        Meal meal;
        try {
            meal = mealDao.getMealById(idmeal);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return meal;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    //Might need to add Principal principal(Needed to extract user information) here but not completely sure
    public Meal createMeal(@Valid @RequestBody Meal newMeal) {
        try {

           // int user_id = getCurrentUserId(principal);
            return mealDao.addMeal(newMeal);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(path = "/{idmeal}", method = RequestMethod.PUT)
    public Meal update(@Valid @RequestBody Meal meal, @PathVariable int idmeal) {
        // The id on the path takes precedence over the one in the request body, if any
        meal.setIdmeal(idmeal);
        try {
            Meal updatedMeal = mealDao.updateMeal(meal);
            return updatedMeal;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meal not found.");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{idmeal}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int idmeal) {

        mealDao.deleteMeal(idmeal);
    }
}
