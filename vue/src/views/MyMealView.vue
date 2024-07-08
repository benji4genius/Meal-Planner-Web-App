<template>
  <main>
    <!-- Header section -->
    <header>
      <nav>
        <p class="link"><router-link v-bind:to="{ name: 'meals' }">Meals</router-link></p>
        <!-- Route link for Home -->
        <router-link to="/">
          <!-- Logo with route link -->
          <img class="plan-to-plate-nav" src="plantoplate-favicon-white.png"/>
        </router-link>
        <router-link to="/mealplans">
          <p class="link">Meal Plans</p>
        </router-link>
      </nav>
    </header>
    <!-- Body section -->

    <body>
      <div id="main-content">
        <!-- Loop through each meal in myMeals array -->
        <div class="meal-container">
          <div class="card" style="width:355px;" v-for="meal in myMeals" :key="meal.idmeal">
            <img class="image-top" v-if="meal.idmeal" :src="meal.strmealthumb" alt="Card example image">
            <div class="card-body">
              <h4 class="card-title">{{ meal.strmeal }}</h4>
              <!-- Call method to handle meal details navigation -->
              <router-link v-bind:to="{ name: 'mealDetails', params: { idmeal: meal.idmeal} }"><button class="link">Let's Cook!</button></router-link>
              <!-- Button to remove meal -->
              <button class="link" @click="removeFromMyMeals(meal)">Remove Meal</button>
              <!-- Select dropdown for days of the week -->
              <select v-model="meal.selectedDay" class="days-of-the-week" name="days">
                <option disabled value="">Select Day</option>
                <option v-for="day in daysOfWeek" :key="day">{{ day }}</option>
              </select>
              <!-- Button to add meal to meal plan -->
              <button class="link" @click="addToMealPlan(meal)">Add to Meal Plan</button>
            </div>
          </div>
        </div>
      </div>
    </body>
  </main>
</template>

<script>
import { mapState} from "vuex";

export default {
  computed: {
    ...mapState(['myMeals']),
    daysOfWeek() {
      return ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];
    }
  },
  methods: {
    // This basically the same as commiting the mutation in the store
   // ...mapMutations(['SET_SELECTED_DAY']),
    removeFromMyMeals(meal) {
      const index = this.myMeals.findIndex(m => m.idmeal === meal.idmeal);
      if (index !== -1) {
        this.$store.commit('REMOVE_FROM_MY_MEALS', index);
      }
    },
    //  modified this part
    addToMealPlan(meal) {
      if (meal.selectedDay) {
        // Dispatch Vuex mutation to update selected day for the meal
        this.$store.commit('SET_SELECTED_DAY', { mealId: meal.idmeal, selectedDay: meal.selectedDay });
        // Commented this line to prevent automatic addition to meal plan
        this.$store.commit('ADD_TO_MEAL_PLANS', { meal, day: meal.selectedDay });
        this.showNotification('Successfully added to Meal Plan');
      } else {
        this.showNotification('Please select a day of the week');
      }
    },
    
    showNotification(message) {
      alert(message);
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
  background-image: url("cutting-b-bg.jpg");
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

.days-of-the-week{
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
</style>
