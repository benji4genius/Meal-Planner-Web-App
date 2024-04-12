import axios from 'axios';


export default {

    getAllMealPlans() {
    return axios.get('/mealplans');
  },

  getAllMealPlansForUser() {
    return axios.get('/mealplans/mymealplans')
  },

  getMealPlanById(meal_plan_id) {
    return axios.get(`/mealplans/${meal_plan_id}`)
  },
 
  createMeal(newMealPlans) {
    return axios.post('/mealplans', newMealPlans);
  },

  updateMealPlan(mealplan) {
    return axios.put(`/meals/${mealplan.meal_plan_id}`, mealplan);
  },

  deleteMealPlan(meal_plan_id) {
    return axios.delete(`/meals/${meal_plan_id}`);
  }
  

}