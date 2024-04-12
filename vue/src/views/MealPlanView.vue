<template>
    <main>
      <header>
        <nav>
          <p class="link" href="{name: home}"><router-link v-bind:to="{ name: 'home' }">Home</router-link></p>
          <img class="logo" src="Untitled Design.png" />
          <p class="link">Meal Plans</p>
        </nav>
      </header>
  
      <body>
        <div id="main-content">
          <!-- <div class="card" style="width: 20rem;">
            <img class="image-top" src="chicken_soup.jpg" alt="Card example image">
            <div class="card-body">
              <h4 class="card-title">Chicken Noodle Soup</h4>
              <router-link v-bind:to="{ name: 'mealDetails' }"><button>Let's Cook!</button></router-link>
              <button>Add to a meal plan</button>
            </div>
          </div> -->
  
          <div class="meal-container">
              <div class="card" style="width: 20rem;" v-bind:to="{ name: '', params: { id: meal.idmeal } }" v-for="meal in $store.state.meals"
                v-bind:key="meal.idmeal">
                <img class="image-top" v-if="meal.idmeal" :src="meal.strmealthumb" alt="Card example image">
                <div class="card-body">
                  <h4 class="card-title">{{ meal.strmeal }}</h4>
                  <router-link v-bind:to="{ name: 'mealDetails' }"><button>Let's Cook!</button></router-link>
                  <button>Add to a meal plan</button>
                </div>
              </div>
            </div>
        </div>
      </body>
    </main>
  </template>
  
  <script>
  import MealService from "../services/MealService";
  export default {
    data() {
      return {
        meals: []
  
  
      };
    },
    methods: {
      loadMeals() {
  
        MealService
          .getMealsForUser()
          .then((response) => {
            this.$store.state.meals = response.data;
  
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
  
      }
  
    },
    created() {
      this.loadMeals();
    }
  };
  </script>
  
  
  <style scoped>
  main {
    background-image: url("healthy_background.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    position: relative;
  }
  
  header {
    background-color: #f0754f;
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
  }
  
  .logo {
    height: 100px;
    border: 2px solid black;
  }
  
  #main-content {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 200px;
    margin-right: 40%;
    margin-left: 40%;
    padding-bottom: 42.75rem;
    padding-top: 10rem;
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
    color: #41403e;
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
    display:flex;
    flex-direction: row;
  }
  .card {
    border-color: #949ba2;
    backface-visibility: hidden;
    border-style: solid;
    border-width: 2px;
    display: flex;
    flex-direction: column;
    position: relative;
    will-change: transform;
    /* word-wrap: break-word; */
  
    .card-header,
    .card-footer {
      background-color: rgba(255, 255, 255, 0.03);
      border-color: #949ba2;
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
      }
  
      .card-subtitle,
      h5 {
        color: #5595ce;
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
  
    .image-top { /*added width and height*/
      width: 100%;
      height: auto;
    }
    .image-bottom,
    img {
      border: 0;
      border-radius: 0;
    }
  }
  
  </style>