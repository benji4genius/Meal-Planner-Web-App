import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    getIngredients() {
        return http.get('/ingredients');
    },

    getIngredientById(idingredient) {
        return http.get(`/ingredients/${idingredient}`);
    },

    createIngredient(newIngredient) {
        return http.post('/ingredients', newIngredient); //just ingredient or newIngredient? 
    },

    // updateIngredient(ingredient) {
    //     return http.put(`/ingredients/${ingredient.id}`, ingredient); //not sure?
    // },

    deleteIngredient(idingredient) {
        return http.delete(`/ingredients/${idingredient}`);
    }


}