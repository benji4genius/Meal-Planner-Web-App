import axios from "axios";


export default {
    getIngredients() {
        return axios.get('/ingredients');  
    },

    getIngredientById(idingredient) {
        return axios.get(`/ingredients/${idingredient}`); 
    },

    createIngredient(newIngredient) {
        return axios.post('/ingredients', newIngredient);
    },


    // updateIngredient(ingredient) {
    //     return http.put(`/ingredients/${ingredient.id}`, ingredient); //not sure?
    // },

    deleteIngredient(idingredient) {
        return axios.delete(`/ingredients/${idingredient}`);
    }


}