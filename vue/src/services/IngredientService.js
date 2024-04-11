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


    // updateIngredient(ingredient) {
    //     return http.put(`/ingredients/${ingredient.id}`, ingredient); //not sure?
    // },

    updateIngredient(ingredient) {
        return http.put(`/ingredients/${ingredient.idingredient}`, ingredient); 
    },


    deleteIngredient(idingredient) {
        return http.delete(`/ingredients/${idingredient}`);
    }


}