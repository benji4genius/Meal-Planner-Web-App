import axios from 'axios';


export default {

    getAllMealPlans() {
    return axios.get('/meal_plans');
  },

  getAllMealPlansForUser() {
    return axios.get('/meal_plans/mymealplans')
  },

  getMealPlanById(meal_plan_id) {
    return axios.get(`/meal_plans/${meal_plan_id}`)
  },
 
  createMeal(newMealPlans) {
    return axios.post('/meal_plans', newMealPlans);
  },

  updateMealPlan(meal_plan) {
    return axios.put(`/meal_plans/${meal_plan.meal_plan_id}`, meal_plan);
  },

  deleteMealPlan(meal_plan_id) {
    return axios.delete(`/meal_plans/${meal_plan_id}`);
  }
  

}