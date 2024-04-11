import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    getIngredients() {
        return http.get('/ingredients');  //works
    },

    getIngredientById(idingredient) {
        return http.get(`/ingredients/${idingredient}`); 
    },

    createIngredient(newIngredient) {
        return http.post('/ingredients', newIngredient);
    },

<<<<<<< HEAD
    // updateIngredient(ingredient) {
    //     return http.put(`/ingredients/${ingredient.id}`, ingredient); //not sure?
    // },
=======
    updateIngredient(ingredient) {
        return http.put(`/ingredients/${ingredient.idingredient}`, ingredient); 
    },
>>>>>>> 14bd1c27a7f0672b1aee297849a566258d3a7702

    deleteIngredient(idingredient) {
        return http.delete(`/ingredients/${idingredient}`);
    }


}