<template>
  <main>
    <header>
      <nav>
        <p class="link" href="{name: home}"><router-link v-bind:to="{ name: 'home' }">Home</router-link></p>
        <img class="logo" src="Chefs_Hat.png" />

        <router-link to="/myMeals">
        <p class="link">My Meals</p>
        </router-link>
      </nav>
    </header>
    <div id="main-content">
      <div class="meal-plan">
        <div class="day" v-for="day in daysOfWeek" :key="day">
          <h3>{{ day }}</h3>
          <div class="meal-slot">
            <div class="slot" v-for="mealSlot in mealSlots" :key="mealSlot">
              <h4>{{ mealSlot }}</h4>
              <div class="meal" @drop="dropMeal(day, mealSlot)" @dragover.prevent>
                <img :src="mealPlan[day][mealSlot].image" alt="Meal Image" draggable="true" @dragstart="dragMeal(day, mealSlot)" />
                <p>{{ mealPlan[day][mealSlot].name }}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>
<script>
import MealService from "../services/MealService";
export default {
  data() {
    return {
      daysOfWeek: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
      mealSlots: ['Breakfast', 'Lunch', 'Dinner'],
      mealPlan: {
        // Initialize meal plan with empty slots for each day and meal
        Monday: { Breakfast: { name: '', image: '' }, Lunch: { name: '', image: '' }, Dinner: { name: '', image: '' } },
        Tuesday: { Breakfast: { name: '', image: '' }, Lunch: { name: '', image: '' }, Dinner: { name: '', image: '' } },
        Wednesday: { Breakfast: { name: '', image: '' }, Lunch: { name: '', image: '' }, Dinner: { name: '', image: '' } },
        Thursday: { Breakfast: { name: '', image: '' }, Lunch: { name: '', image: '' }, Dinner: { name: '', image: '' } },
        Friday: { Breakfast: { name: '', image: '' }, Lunch: { name: '', image: '' }, Dinner: { name: '', image: '' } },
        Saturday: { Breakfast: { name: '', image: '' }, Lunch: { name: '', image: '' }, Dinner: { name: '', image: '' } },
        Sunday: { Breakfast: { name: '', image: '' }, Lunch: { name: '', image: '' }, Dinner: { name: '', image: '' } }
      },
      meals: []
    };
  },
  methods: {
    loadMeals() {
      MealService
        .getMealsForUser()
        .then((response) => {
          this.meals = response.data;
        })
        .catch((error) => {
          console.error("Error loading meals: ", error);
        });
    },
    dropMeal(day, mealSlot) {
      // Implement drop logic to add a meal to the meal plan
      // For now, let's just add the first meal from the meals list to the dropped slot
      if (this.meals.length > 0) {
        const meal = this.meals[0];
        this.mealPlan[day][mealSlot].name = meal.strmeal;
        this.mealPlan[day][mealSlot].image = meal.strmealthumb;
      }
    },
    dragMeal(day, mealSlot) {
      // Implement drag logic to move a meal within the meal plan
      // For now, let's clear the dragged slot
      this.mealPlan[day][mealSlot].name = '';
      this.mealPlan[day][mealSlot].image = '';
    }
  },
  created() {
    this.loadMeals();
  }
};
</script>
<style scoped>
main {
  background-image: url("");
  background-repeat: no-repeat;
  background-size: cover;
  background-color: whitesmoke;
  position: relative;
  opacity: 4; /* added this part*/
}
header {
  background-color: #F0754F;
  padding: 20px;
  border: 2px solid black
}
nav {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 20px;
  height: 100px;
}
.logo {
  width: 200px;
  height: auto;
  align-self: center;
  position: absolute;
  margin-right: 1px;
  margin-left: 1px;
}
#main-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 50px; /* Adjusted margin */
}
.link {
  align-self: center;
  background-color: #fff;
  background-image: none;
  background-position: 0 90%;
  background-repeat: repeat no-repeat;
  background-size: 4px 3px;
  border-radius: 15px 225px 255px 15px 15px 255px 225px 15px;
  border-style: solid;
  border-width: 2px;
  box-shadow: rgba(0, 0, 0, .2) 15px 28px 25px -18px;
  box-sizing: border-box;
  color: #41403E;
  cursor: pointer;
  display: inline-block;
  font-family: Neucha, sans-serif;
  font-size: 1rem;
  line-height: 23px;
  outline: none;
  padding: .75rem;
  text-decoration: none;
  transition: all 235ms ease-in-out;
  border-bottom-left-radius: 15px 255px;
  border-bottom-right-radius: 225px 15px;
  border-top-left-radius: 255px 15px;
  border-top-right-radius: 15px 225px;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}
.link:hover {
  box-shadow: rgba(0, 0, 0, .3) 2px 8px 8px -5px;
  transform: translate3d(0, 2px, 0);
}
.link:focus {
  box-shadow: rgba(0, 0, 0, .3) 2px 8px 4px -6px;
}
.meal-plan {
  display: flex;
  flex-wrap: wrap;
  font-size: large;
  justify-content: space-around;
  margin-top: 20px; /* Added margin */
}
.day {
  width: 20%;
  margin-bottom: 20px;
  padding: 10px;
  
  border: 1px solid #ccc;
}
.meal-slot {
  margin-top: 10px;
}
.slot {
  margin-bottom: 10px;
}
.meal {
  width: 200px; /* Set a fixed width for meal containers */
  border: 1px solid #ccc;
  padding: 10px;
  text-align: center;
}
.meal img {
  max-width: 100%; /* Ensure images scale properly within the fixed width container */
  height: auto;
}
.meal p {
  margin-top: 5px;
  margin-bottom: 0;
}
</style>