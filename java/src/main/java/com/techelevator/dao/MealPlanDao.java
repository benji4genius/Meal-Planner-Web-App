package com.techelevator.dao;
import com.techelevator.model.MealPlan;
import java.util.List;

public interface MealPlanDao {
    List<MealPlan> getAllMealPlans();

    List<MealPlan> getAllMealPlansForUser(int userId);

    MealPlan getMealPlanById(int mealPlanId);

    MealPlan addMealPlan(MealPlan mealPlan);

    MealPlan updateMealPlan(MealPlan mealPlan);

    void deleteMealPlan(int mealPlanId);
}
