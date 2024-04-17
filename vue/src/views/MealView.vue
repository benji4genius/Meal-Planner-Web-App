<template>
  <main>
    <header>
      <nav>
<<<<<<< HEAD
        <p class="link" href="{name: home}"><router-link v-bind:to="{ name: 'home' }">Home</router-link></p>
=======

        <router-link to="/mealplans">
        <p class="link">Meal Plan</p>
        </router-link>
        <!-- <p class="link" href="{name: home}"><router-link v-bind:to="{ name: 'home' }">Home</router-link></p> -->

>>>>>>> 37abf60597154d03ece20a41516ff9ec5c9ff2ca
        <!-- Route link for Home -->
        <router-link to="/">
          <!-- Logo with route link -->
          <img class="logo" src="Chefs_Hat.png" />
        </router-link>
<<<<<<< HEAD
=======

       

>>>>>>> 37abf60597154d03ece20a41516ff9ec5c9ff2ca
        <router-link to="/mymeals">
        <p class="link">My Meals</p>
        </router-link>
      </nav>
    </header>
    <body>
      <div id="main-content">
           <div class="meal-container">
            <div class="card" style="width: 320px;" v-bind:to="{ name: '', params: { id: meal.idmeal } }" v-for="meal in $store.state.meals"
              v-bind:key="meal.idmeal" >
              <img class="image-top" v-if="meal.idmeal" :src="meal.strmealthumb" alt="Card example image">
              <div class="card-body">
                <h4 class="card-title">{{ meal.strmeal }}</h4>
                <router-link v-bind:to="{ name: 'mealDetails', params: { idmeal: meal.idmeal} }"><button class="link">Let's Cook!</button></router-link>
                <!--<router-link v-bind:to="{name: 'mymeals'}">this routes to my meals on click-->
                  <button class="link" @click="addToMyMeals(meal)">Add to My Meals
                  </button>
                <!--</router-link>--> <!--i added this part-->
              </div>
            </div>
          </div>
      </div>
      <!---Added this for popup functionality-->
      <div class="popup" v-if="showPopup">
        <p>Meal successfully added!</p>
      </div>
    </body>
  </main>
</template>
<script>
import MealService from "../services/MealService";
export default {
  data() {
    return {
      meals: [],
      showPopup: false
    };
  },
  methods: {
    loadMeals() {
      MealService
        .getAllMeals()
        .then((response) => {
          console.log('Response data:', response.data); // Add this line to check if meals are loaded
          this.$store.state.meals = response.data;
        })
        .catch((error) => {
          const response = error.response;
          this.registrationErrors = true;
          if (response.status === 400) {
            this.registrationErrorMsg = 'Bad Request: Validation Errors';
          }
        });
    },
    addToMyMeals(meal) {
  // Commit mutation to add meal to "My Meals" in Vuex store
  this.$store.commit('ADD_TO_MY_MEALS', meal);            //// changed this
  console.log('Adding to My Meals:', meal); // Add this line to check if meal is being added
  this.showPopup = true;
      // Reset the popup after a certain time, for example, 3 seconds
      setTimeout(() => {
        this.showPopup = false;
      }, 3000);
}
  },
  created() {
    this.loadMeals();
  }
};
</script>
<style scoped>
body, html {
  height: 100%;
  margin: 0;
}
main {
  background-image: url("");
  background-repeat: no-repeat;
  background-size:cover;
  position: relative;
  height:fit-content;
  background-color: whitesmoke;
 /* Add margin-top to create spacing between nav and main */
}
header {
  background-color: #F0754F;
  padding: 20px;
  border: 2px solid black;
}
nav {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 20px;
  height: 100px;
  margin-bottom: 20px; /* Add margin-bottom to create spacing between nav and main */
}
/* Styling for the pop-up message */
.popup {
  position:fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: #F0754F;
  color: white;
  padding: 25px;
  border-radius: 5px;
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
.meal-container{
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
  grid-gap: 5px;
  align-items: center;
  justify-content: center;
  padding-top: 5rem;
  padding-left: 10rem;
  padding-right: 10rem;
}
.card {
  border-color: #949BA2;
  backface-visibility: hidden;
  border-radius: 15px; /* Adjust the value as needed */
  overflow: hidden; /* Ensure content inside the card respects the border-radius */
  border-style: solid;
  border-width: 2px;
  display: flex;
  flex-direction: column;
  position: relative;
  width: 100%;
  height: auto;
  align-items: center;
  justify-content: center;
  will-change: transform;
  transition: transform 0.3s ease; /* Apply hover effect to the card */
}
.card:hover {
  transform: translateY(-5px);
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
  padding: 1.25rem;
  .card-title,
  h4 {
    margin-bottom: 0.5rem;
    margin-top: 0;
    text-align: center;
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
</style>












