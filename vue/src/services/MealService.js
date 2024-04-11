import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

 getMeals() {
    return http.get('/meals');
  },

  getMealsForUser() {
    return http.get('/meals/mymeals')
  },

  getMealById(idmeal) {
    return http.get(`/meals/${idmeal}`)
  },
 
  createMeal(newMeal) {
    return http.post('/meals', newMeal);
  },

  updateMeal(meal) {
    return http.put(`/meals/${meal.idmeal}`, meal); // Not sure about this endpoint
  },

  deleteMeal(idmeal) {
    return http.delete(`/meals/${idmeal}`);
  }
  

}
