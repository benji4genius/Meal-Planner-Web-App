package com.techelevator.controller;

import com.techelevator.dao.MealPlanDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.MealPlan;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/mealplans")
@PreAuthorize("isAuthenticated()")
public class MealPlanController {

    private MealPlanDao mealPlanDao;
    private UserDao userDao;

    public MealPlanController(MealPlanDao mealPlanDao, UserDao userDao) {
        this.mealPlanDao = mealPlanDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<MealPlan> getMealPlans() {

        try {
            return mealPlanDao.getAllMealPlans();

        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/mymealplans", method = RequestMethod.GET)
    public List<MealPlan> getMealPlansForUser(Principal principal) {
        try {
            int userId = userDao.getUserByUsername(principal.getName()).getId();
            return mealPlanDao.getAllMealPlansForUser(userId);

        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{meal_plan_id}", method = RequestMethod.GET)
    public MealPlan getMealPlanById(@PathVariable int meal_plan_id) {
        MealPlan mealPlan;

        try {
            mealPlan = mealPlanDao.getMealPlanById(meal_plan_id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return mealPlan;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public MealPlan createMealPlan(@Valid @RequestBody MealPlan newMealPlan) {
        try {

            return mealPlanDao.addMealPlan(newMealPlan);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{meal_plan_id}", method = RequestMethod.PUT)
    public MealPlan update(@Valid @RequestBody MealPlan mealPlan, @PathVariable int meal_plan_id) {
        mealPlan.setMeal_plan_id(meal_plan_id);
        try {
            MealPlan updatedMealPlan = mealPlanDao.updateMealPlan(mealPlan);
            return updatedMealPlan;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meal not found.");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{meal_plan_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int meal_plan_id) {

        mealPlanDao.deleteMealPlan(meal_plan_id);

    }
}
