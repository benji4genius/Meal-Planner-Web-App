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

    updateIngredient(ingredient) {
        return http.put(`/ingredients/${ingredient.idingredient}`, ingredient); 
    },


=======
    // updateIngredient(ingredient) {
    //     return http.put(`/ingredients/${ingredient.id}`, ingredient); //not sure?
    // },
    
>>>>>>> cbfd6010b382d9fd9e2dfdd2f948aa3f996828f4
    deleteIngredient(idingredient) {
        return http.delete(`/ingredients/${idingredient}`);
    }


}