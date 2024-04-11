import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

    getAllMealPlans() {
    return http.get('/mealplans');
  },

  getAllMealPlansForUser() {
    return http.get('/mealplans/mymealplans')
  },

  getMealPlanById(meal_plan_id) {
    return http.get(`/mealplans/${meal_plan_id}`)
  },
 
  createMeal(newMealPlans) {
    return http.post('/mealplans', newMealPlans);
  },

  updateMealPlan(mealplan) {
    return http.put(`/meals/${mealplan.meal_plan_id}`, mealplan);
  },

  deleteMealPlan(meal_plan_id) {
    return http.delete(`/meals/${meal_plan_id}`);
  }
  

}