import { createStore as _createStore } from 'vuex';
import axios from 'axios';
// Function to create the Vuex store
export function createStore(currentToken, currentUser) {
  // Initialize state with data from local storage or default values
  const initialState = {
    token: currentToken || '',
    user: currentUser || {},
    myMeals: JSON.parse(localStorage.getItem('myMeals')) || [], // Initialize myMeals with data from local storage
    mealplans: JSON.parse(localStorage.getItem('mealplans')) || [],
    ingredients: [],
    mealPlan: {
      Monday: [],
      Tuesday: [],
      Wednesday: [],
      Thursday: [],
      Friday: [],
      Saturday: [],
      Sunday: []
    }
  };
  // Create the Vuex store
  const store = _createStore({
    state: initialState,
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      ADD_TO_MY_MEALS(state, meal) {
        state.myMeals.push(meal);
        // Update local storage with the updated myMeals array
        localStorage.setItem('myMeals', JSON.stringify(state.myMeals));
      },
      REMOVE_FROM_MY_MEALS(state, index) {
        state.myMeals.splice(index, 1);
        localStorage.setItem('myMeals', JSON.stringify(state.myMeals));
      },
      REMOVE_FROM_MEAL_PLANS(state, index) {
        state.mealplans.splice(index, 1);
        localStorage.setItem('mealplans', JSON.stringify(state.mealplans));
      },
      ADD_TO_MEAL_PLANS(state,{meal}) {
        // Update the meal plan with the new meal data
      state.mealplans.push(meal);
        // Update local storage to persist the changes
        localStorage.setItem('mealplans', JSON.stringify(state.mealplans));
      },
      SET_INGREDIENTS(state, ingredients) {
        state.ingredients = ingredients;
        localStorage.setItem('ingredients', JSON.stringify(ingredients));
      },

       // Added this part
       SET_SELECTED_DAY(state, { mealId, selectedDay }) {
        // Find the meal by its id and update its selected day
        const meal = state.myMeals.find(meal => meal.idmeal === mealId);
        if (meal) {
          meal.selectedDay = selectedDay;
        }
        
        // Save the updated myMeals array to localStorage
        localStorage.setItem('myMeals', JSON.stringify(state.myMeals));
      },

    },
    actions: {
      fetchIngredients({ commit }) {
        const ingredients = JSON.parse(localStorage.getItem('ingredients')) || [];
        commit('SET_INGREDIENTS', ingredients);
      }
    }
  });
  // Load data from local storage when the application starts
  // This ensures that the state persists between page loads
  if (!currentToken) {
    store.replaceState(initialState);
  }
  return store;
}