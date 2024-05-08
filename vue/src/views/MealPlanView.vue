<template>
  <main>
    <header>
      <nav>
        <p class="link" href="{name: home}">
          <router-link v-bind:to="{ name: 'mymeals' }">My Meals</router-link>
        </p>
        <router-link to="/">
          <!-- Logo with route link -->
          <img class="plan-to-plate-nav" src="plantoplate-favicon-white.png" />
        </router-link>
        <router-link to="/meals">
          <p class="link">Meals</p>
        </router-link>
      </nav>
    </header>

    <div id="main-content">
      <h2 class="meal-title-page">Meal Plan</h2>
      <div class="meal-container">

        <div class="card" style="width:355px;" v-for="meal in mealplans" :key="meal.idmeal">
          <img class="image-top" v-if="meal.idmeal" :src="meal.strmealthumb" alt="Card example image">
          <div class="card-body">
            <h4 class="card-title">{{ meal.strmeal }}</h4>
            <!-- Call method to handle meal details navigation -->
            <router-link v-bind:to="{ name: 'mealDetails', params: { idmeal: meal.idmeal } }"><button class="link">Let's
                Cook!</button></router-link>
            <button class="link" @click="removeFromMealPlans(meal)">Remove Meal</button>
            <!-- New button to add meal to calendar -->
            <button class="link" @click="addToCalendar(meal.strmeal)">Add to Calendar</button>
          </div>

        </div>
        <!-- Placeholder for floating calendar icon -->
        <div class="floating-calendar-icon" @click="toggleCalendarVisibility">
          <img src="calendar logo.png" alt="Icon Description">

        </div>


        <!-- Calendar component -->
        <div v-show="calendarVisible" class="calendar-container">
          <!-- Placeholder for your calendar component -->
          <!-- You need to replace this with your actual calendar component -->

          <Calendar :mealplans="calendarMeals" @addMeal="addMealToCalendar" @removeMeal="removeMealFromCalendar" />
          <div class="calendar">
            <h3>Calendar</h3>
            <ul>
              <li v-for="meal in calendarMeals" :key="meal">{{ meal }}</li>
            </ul>
          </div>
        </div>
      </div>
      <!--------------------End of Calendar code--------------------->
      <div v-for="(dayMeals, day) in mealplan" :key="day">
        <h3>{{ day }}</h3>
        <ul>
          <li v-for="meal in dayMeals" :key="meal.idmeal">{{ meal.strmeal }}</li>
        </ul>
      </div>
    </div>
      <!-- Floating Calendar component -->
    <FloatingCalendar />

  </main>
</template>

<script>
import { mapState } from "vuex";
//import MyMealService from "../services/MyMealService";
//import { RouterLink } from "vue-router";
//import Calendar from '../components/Calendar.vue'; // Import the Calendar component
// import FloatingCalendar from '../components/FloatingCalendar.vue';

// Introduced in vue file
//import { FunctionalCalendar } from 'vue-functional-calendar';



export default {

  components: {
    //Calendar, // Register the Calendar component
    // Register the FloatingCalendar component
     FunctionalCalendar
  },

  data() {
    return {
      calendarVisible: false,
     //calendarData: {} 
    };
  },
  computed: {
    ...mapState(['mealplans']),// Map mealPlan from Vuex store
    // mealPlans() {
    //   return this.$store.state.mealPlans;
    // }
  },
  methods: {

    removeFromMealPlans(meal) {
      const index = this.mealplans.findIndex(m => m.idmeal === meal.idmeal);
      if (index !== -1) {
        this.$store.commit('REMOVE_FROM_MEAL_PLANS', index);
      }
    },

    toggleCalendarVisibility() {
      this.calendarVisible = !this.calendarVisible;
    },
    addToCalendar(meal) {
      // Add the meal to the calendarMeals array
      this.calendarMeals.push(meal);
    },

    removeMealFromCalendar(index) {
      this.calendarMeals.splice(index, 1);
    }
  }
}
</script>


<style scoped>
body,
html {
  height: 100%;
  margin: 0;
}

main {
  background-image: url("table-spices-spoons.jpg");
  background-repeat: no-repeat;
  min-height: 100vh;
  background-size: 100% 100%;
  background-position: center center;
  position: relative;
}

header {
  background-color: #F0754F;
  padding: 20px;
  border: 2px solid black;
}

select {
  margin-right: 5px;
}

nav {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 20px;
  height: 100px;
  margin-bottom: 20px;
  /* Add margin-bottom to create spacing between nav and main */
}

.logo {
  width: 200px;
  height: auto;
  align-self: center;
  position: relative;
  margin-right: 1px;
  margin-left: 1px;
}

#main-content {
  display: grid;
  font-family: Neucha, sans-serif;
  font-size: larger;
  color: black;

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
  font-size: 1.2rem;
  line-height: 23px;
  outline: none;
  padding: .75rem;
  margin-right: 10px;
  margin-bottom: 2px;
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

.meal-container {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
  grid-gap: 50px;
  align-items: center;
  justify-content: center;
  margin-top: 10px;
  padding: 20px 20px;


}

.meal-title-page {
  text-align: center;
}

.card {
  width: 100%;
  border-color: #949BA2;
  background-color: #fff;
  backface-visibility: hidden;
  border-radius: 15px;
  /* Adjust the value as needed */
  overflow: hidden;
  /* Ensure content inside the card respects the border-radius */
  border-style: solid;
  border-width: 5px;
  display: flex;
  flex-direction: column;
  position: relative;

  height: auto;
  align-items: center;
  justify-content: center;
  will-change: transform;
  transition: transform 0.3s ease;
  /* Apply hover effect to the card */
}

.card:hover {
  transform: translateY(-5px);
  /* Define hover effect */
}

.card-header,
.card-footer {
  background-color: rgba(255, 255, 255, 0.03);
  border-color: #949BA2;
  padding: 0.75rem 1.25rem;
}

.card-header {
  border-bottom-style: solid;
  border-bottom-width: 2px;
}

.card-footer {
  border-top-style: solid;
  border-top-width: 2px;
}

.card-body {
  flex: 1 1 auto;
  padding: 1.75rem;

  .card-title,
  h4 {
    margin-bottom: 0.5rem;
    margin-top: 0;
    text-align: center;
    font-size: 20px;
  }

  .card-subtitle,
  h5 {
    color: #5595CE;
    margin-bottom: 0.5rem;
    margin-top: 0;
  }

  .card-text,
  p {
    margin-bottom: 1rem;
    margin-top: 0;
  }

  .card-link+.card-link,
  a+a {
    margin-left: 1.25rem;
  }
}

.days-of-the-week {
  font-size: larger;
}

.image-top {
  /*added width and height*/
  width: 100%;
  height: auto;
}

.image-bottom,
img {
  border: 0;
  border-radius: 0;
}

/* Floatin-Calendar CSS */

.floating-calendar-icon {
  position: fixed;
  bottom: 100px; /* Adjust as needed */
  right: 300px; /* Adjust as needed */
  width: 100px; /* Adjust as needed */
  height: 50px; /* Adjust as needed */
  background-color: #f0754f; /* Background color of the icon container */
  border-radius: 50%; /* Makes it round */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2); /* Optional: Adds a shadow */
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 999; /* Make sure it's above other elements */
}

.floating-calendar-icon img {
  width: 70%; /* Make sure the image fits inside the container */
  height: auto;
}

</style>
