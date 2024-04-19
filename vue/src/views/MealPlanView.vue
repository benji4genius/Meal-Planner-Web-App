<template>
  <main>
    <header>
      <nav>
        <p class="link" href="{name: home}">
          <router-link v-bind:to="{ name: 'mymeals' }">My Meals</router-link>
        </p>
        <router-link to="/">
          <!-- Logo with route link -->
          <img class="plan-to-plate-nav" src="plantoplate-favicon-white.png"/>
        </router-link>


        <router-link to="/meals">
          <p class="link">Meals</p>
        </router-link>

      </nav>
    </header>
    <div id="main-content">
      <div class="meal-plan">

        <div class="meal-slot">
          <div>
            <h2>Monday</h2>
            <h3>Chicken Enchilada Casserole</h3>
            <img class="food" src="https://www.themealdb.com/images/media/meals/qtuwxu1468233098.jpg" />
          </div>
        </div>

        <div class="meal-slot">
          <div>
            <h2>Tuesday</h2>
            <h3>Beef Caldereta</h3>
            <img class="food" src="https://www.themealdb.com/images/media/meals/41cxjh1683207682.jpg" />
          </div>
        </div>

        <div class="meal-slot">
          <div>
            <h2>Wednesday</h2>
            <h3>Beef Wellington</h3>
            <img class="food" src="https://www.themealdb.com/images/media/meals/vvpprx1487325699.jpg" />
          </div>
        </div>
        <div class="meal-slot">
          <div>
            <h2>Thursday</h2>
            <h3>Chicken Alfredo Primavera</h3>
            <img class="food" src="https://www.themealdb.com/images/media/meals/syqypv1486981727.jpg" />
          </div>
        </div>

        <div class="meal-slot">
          <div>
            <h2>Friday</h2>
            <h3>Beef Brisket Pot Roast</h3>
            <img class="food" src="https://www.themealdb.com/images/media/meals/ursuup1487348423.jpg" />
          </div>
        </div>

        <div class="meal-slot">
          <div>
            <h2>Saturday</h2>
            <h3>Baingan Bharta</h3>
            <img class="food" src="https://www.themealdb.com/images/media/meals/urtpqw1487341253.jpg" />
          </div>
        </div>

        <div class="meal-slot">
          <div>
            <h2>Sunday</h2>
            <h3>Chicken Fajita Mac and Cheese</h3>
            <img class="food" src="https://www.themealdb.com/images/media/meals/qrqywr1503066605.jpg" />
          </div>
        </div>
      </div>
    </div>
   
  </main>
</template>

<script>
// import MealPlanService from "../services/MealPlanService";

export default {
  data() {
    return {
      daysOfWeek: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
      // mealSlots: ['Breakfast', 'Lunch', 'Dinner'],
      mealPlan: {
        // Initialize meal plan with empty slots for each day and meal
        Monday: { Breakfast: { name: '' }, Lunch: { name: '' }, Dinner: { name: '' } },
        Tuesday: { Breakfast: { name: '' }, Lunch: { name: '' }, Dinner: { name: '' } },
        Wednesday: { Breakfast: { name: '' }, Lunch: { name: '' }, Dinner: { name: '' } },
        Thursday: { Breakfast: { name: '' }, Lunch: { name: '' }, Dinner: { name: '' } },
        Friday: { Breakfast: { name: '' }, Lunch: { name: '' }, Dinner: { name: '' } },
        Saturday: { Breakfast: { name: '' }, Lunch: { name: '' }, Dinner: { name: '' } },
        Sunday: { Breakfast: { name: '' }, Lunch: { name: '' }, Dinner: { name: '' } }
      },
      meals: []

    }
  },
  methods: {
    // loadMeals() {
    //   MealPlanService
    //     .getAllMealPlansForUser()

    //     .then((response) => {
    //       this.meals = response.data;
    //     })
    //     .catch((error) => {
    //       console.error("Error loading meals: ", error);
    //     });
    // },
    dayOfWeek() {
      const daysOfWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
      const currentDate = new Date();
      return daysOfWeek[currentDate.getDay()];
    },
    dropMeal(day, mealSlot) {
      // Implement drop logic to add a meal to the meal plan
      // For now, let's just add the first meal from the meals list to the dropped slot
      if (this.meals.length > 0) {
        const meal = this.meals[0];
        this.$set(this.mealPlan[day], mealSlot, meal);
      }
    },
    dragMeal(day, mealSlot) {
      // Implement drag logic to move a meal within the meal plan
      // For now, let's clear the dragged slot
      this.mealPlan[day][mealSlot].name = '';
    }
  }
  // created() {
  //   this.loadMeals();
  // }
};
</script>

<style scoped>
main {
  background-image: url("wood-veggies-pasta.jpg");
  background-repeat: no-repeat;
  background-size:cover;
  background-position: center center;
  position: relative;
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
  position: relative;
  margin-right: 1px;
  margin-left: 1px;
}

#main-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 50px;
  /* Adjusted margin */
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
  margin-top: 20px;
  /* Added margin */
}

.meal-slot {
  border-color: #949BA2;
  backface-visibility: hidden;
  border-radius: 15px;
  /* Adjust the value as needed */
  overflow: hidden;
  /* Ensure content inside the card respects the border-radius */
  border-style: solid;
  color: black;
  font-size: large;
  background-color: #fff;
  margin-top: 10px;
  box-shadow: 0 0 10px #f0754f;
}

.meal-slot:hover {
  transform: translateY(-5px);
  will-change: transform;
  transition: transform 0.3s ease;
  /* Define hover effect */
}

.slot {
  margin-bottom: 10px;
}

.meal {
  width: 200px;
  /* Adjust width as needed */
  border: 1px solid #ccc;
  padding: 10px;
  text-align: center;
}

.meal img {
  max-width: 100%;
  /* Ensure images scale properly within the fixed width container */
  height: auto;
}

.meal p {
  margin-top: 5px;
  margin-bottom: 0;
}

.food {
  width: 300px;
}

.h3 {
  padding-top: 50px;
}

.meal-slot {
  border: 1px solid black;
  margin-right: 20px;
  padding: 20px;
  display: flex;
  flex-direction: column;

  border-radius: 10px;
}



</style>
