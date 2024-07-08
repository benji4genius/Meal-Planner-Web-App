<template>
  <main>
    <header>
      <nav>
        <p class="link">
          <router-link v-bind:to="{ name: 'mymeals' }">My Meals</router-link>
        </p>
        <router-link to="/">
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
            <router-link v-bind:to="{ name: 'mealDetails', params: { idmeal: meal.idmeal } }">
              <button class="link">Let's Cook!</button>
            </router-link>
            <button class="link" @click="removeFromMealPlans(meal)">Remove Meal</button>
            <button class="link" @click="addToCalendar(meal)">Add to Calendar</button>
          </div>
        </div>

        <div class="floating-calendar-icon" @click="toggleCalendarVisibility">
          <img src="calendar logo 3.png" alt="Icon Description">
        </div>

        <div v-show="calendarVisible" class="calendar-container">
          <div class="custom-calendar" style="width: 600px !important; height: 600px !important;">
            <VDatePicker v-model="date" class="calendar-component custom-calendar" ref="datePicker"
              style="width: 600px !important; height: 490px !important;  background-color: whitesmoke !important; color: black !important;">
              <template #day="{ date }">
                <div class="v-date-picker-month__day-btn custom-date-btn"> {{ date }}
                </div>
              </template>
              <template #weekday="{ weekday }">
                <div class="v-date-picker-month__weekday custom-weekday"> {{ weekday }}
                </div>
              </template>

              <div v-if="tooltipVisible" class="meal-box"
              :style="{ top: tooltipPosition.top + 'px', left: tooltipPosition.left + 'px' }">
              <div>{{ hoveredDay }}</div>
              <div>{{ hoveredMeal }}</div>
              <button class="remove-meal" @click="removeMealFromCalendar(hoveredDay, hoveredMeal)">Remove</button>
            </div>
            </VDatePicker>


            <div v-for="(dayMeals, day) in mealplan" :key="day">
              <h3>{{ day }}</h3>
              <ul>
                <li v-for="(meal, mealIndex) in dayMeals" :key="mealIndex" class="meal-item"
                  @mouseover="showHoverBox(day, meal, $event)" @mouseleave="hideHoverBox">
                  {{ meal }}
                </li>
              </ul>
            </div>

            
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import { mapState } from "vuex";
import { reactive } from 'vue';
import { VDatePicker } from 'vuetify/components';
import '@mdi/font/css/materialdesignicons.css';
import 'vuetify/styles';

export default {
  components: {
    VDatePicker,
  },

  data() {
    return {
      calendarVisible: false,
      date: null,
      tooltipVisible: false,
      hoveredDay: '',
      hoveredMeal: '',
      tooltipPosition: {
        top: 0,
        left: 0,

      },
      mealplan: reactive({})
    }
  },
  computed: {
    ...mapState(['mealplans'])
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
      if (!this.date || !meal || !meal.strmeal) {
        console.error('Invalid date or meal.');
        return;
      }

      const selectedDate = new Date(this.date);
      if (isNaN(selectedDate.getTime())) {
        console.error('Invalid date format.');
        return;
      }

      const formattedDate = selectedDate.toISOString().split('T')[0];
      if (!this.mealplan[formattedDate]) {
        this.mealplan[formattedDate] = [];
      }
      this.mealplan[formattedDate].push(meal.strmeal);

      console.log(`Meal added to calendar on ${formattedDate}:`, this.mealplan[formattedDate]);
    },

    removeMealFromCalendar(day, meal) {
      if (this.mealplan[day]) {
        this.mealplan[day] = this.mealplan[day].filter(m => m !== meal);
      }
    },
    showHoverBox(day, meal, event) {
      if (event) {
        this.tooltipVisible = true;
        this.hoveredDay = day;
        this.hoveredMeal = meal;
        this.tooltipPosition.top = event.clientY;
        this.tooltipPosition.left = event.clientX;
      }
    },
    hideHoverBox() {
      this.tooltipVisible = false;
      this.hoveredDay = '';
      this.hoveredMeal = '';
    }
  },

  watch: {
    mealplan: {
      handler(newVal) {
        localStorage.setItem('mealplan', JSON.stringify(newVal));
      },
      deep: true,
    },
  }

}
</script>

<style scoped>
/* Your existing styles */
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

.image-top {
  width: 100%;
  height: auto;
}

.image-bottom,
img {
  border: 0;
  border-radius: 0;
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
  font-family: Neucha, sans-serif;
  font-size: 2rem;
  color: #fff;
  text-align: center;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
}

.floating-calendar-icon {
  position: fixed;
  bottom: 10px;
  right: 30px;
  width: 60px;
  height: 60px;
  background-color: #F0754F;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  cursor: pointer;
}

.floating-calendar-icon img {
  width: 700px;
  height: 60px;
}

.calendar-container {
  position: absolute;
  bottom: 80px;
  right: 20px;
  background-color: rgb(204, 197, 197);
  border: 1px solid #ddd;
  border-radius: 20px;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  padding: 20px;
}


.meal-item:hover {
  background-color: #F0754F;
  color: white;
}

.meal-box {
  position: absolute;
  background-color: white;
  border: 1px solid #ddd;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  padding: 10px;
  z-index: 100;
}

.remove-meal {
  margin-top: 10px;
  padding: 5px;
  border: none;
  background-color: #FF5252;
  color: white;
  border-radius: 5px;
  cursor: pointer;
}

.remove-meal:hover {
  background-color: #E64A19;
}

.custom-date-btn {
  font-size: 1.5rem;
  padding: 2.5rem;
}
</style>
