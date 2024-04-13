import axios from "axios";


export default {
    getAllMeals() {
        return axios.get('/meals');  
    },

    getMealById(idmeal) {
        return axios.get(`/meals/${idmeal}`); 
    },

    createMeal(newMeal) {
        return axios.post('/meals', newMeal);
    },


    // updateIngredient(ingredient) {
    //     return http.put(`/ingredients/${ingredient.id}`, ingredient); //not sure?
    // },

    deleteMeal(idmeal) {
        return axios.delete(`/ingredients/${idmeal}`);
    }


}