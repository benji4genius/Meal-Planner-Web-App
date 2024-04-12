import axios from 'axios';


export default {

 getMeals() {
    return axios.get('/meals');
  },

  getMealsForUser() {
    return axios.get('/meals/mymeals')
  },

  getMealById(idmeal) {
    return axios.get(`/meals/${idmeal}`)
  },
 
  createMeal(newMeal) {
    return axios.post('/meals', newMeal);
  },

  updateMeal(meal) {
    return axios.put(`/meals/${meal.idmeal}`, meal);
  },

  deleteMeal(idmeal) {
    return axios.delete(`/meals/${idmeal}`);
  }
  

}
