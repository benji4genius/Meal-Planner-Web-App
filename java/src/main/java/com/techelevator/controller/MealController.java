package com.techelevator.controller;

import com.techelevator.dao.MealDao;
import com.techelevator.dao.UserDao;
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
@PreAuthorize("isAuthenticated()")
public class MealController {
    private MealDao mealDao;
    private UserDao userDao;

    public MealController(MealDao mealDao, UserDao userDao) {
        this.mealDao = mealDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Meal> getMeals() {
        try {
            return mealDao.getAllMeals();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/mymeals", method = RequestMethod.GET)
    public List<Meal> getMealsForUser(Principal principal) {
        try {
            int userId = userDao.getUserByUsername(principal.getName()).getId();
            return mealDao.getAllMealsForUser(userId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{idmeal}", method = RequestMethod.GET)
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
    public Meal createMeal(@Valid @RequestBody Meal newMeal) {
        try {
            return mealDao.addMeal(newMeal);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(path = "/{idmeal}", method = RequestMethod.PUT)
    public Meal updateMeal(@Valid @RequestBody Meal meal, @PathVariable int idmeal) {
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
    public void deleteMeal(@PathVariable int idmeal) {

        mealDao.deleteMeal(idmeal);
    }
}
