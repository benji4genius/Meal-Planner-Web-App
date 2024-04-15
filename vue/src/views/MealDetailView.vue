<template>
    <main>
      <header>
        <nav>
          <p class="link" href="{name: home}"><router-link v-bind:to="{ name: 'home' }">Home</router-link></p>
          <img class="logo" src="/Chefs_Hat.png" />
          <router-link to="/meals">
          <p class="link">Meals</p>
          </router-link>
        </nav>
      </header>

      <div class="recipe-name">
        <h2>{{ meal.strmeal }}</h2>
        <h3>Recipe Instructions</h3>
      </div>
  
      <body>
        <div id="main-content">
          <div class="meal-details" v-bind:to="{ name: '', params: { id: meal.idmeal } }">
            <img class="image-top" v-if="meal.idmeal" :src="meal.strmealthumb">
            <div class="meal-info">
              <div class="recipe-instructions"> 
                <p>{{ meal.strinstructions }}</p>
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
        meal: {
          strmeal: '',
          strinstructions: '',
          strtags: '',
          strmealthumb: '',
          stryoutube: ''
        }
      };
    },

    
      created() {
    let idmeal = parseInt(this.$route.params.idmeal);
    MealService.getMealById(idmeal)
      .then(response => {
        this.meal = response.data;
      });
  }
    
}
  </script>
  
<style scoped>
header{
    background-color:#f0754f;
    padding: 20px;
    border: 2px solid black
}
nav{
  display:flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 20px;
  height: 100px;
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
.logo {
  width: 200px;
  height: auto;
  align-self: center;
  position: absolute;
  margin-right: 1px;
  margin-left: 1px;
}
  .meal-details {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
  }
  
  .image-top {
    width: 300px; 
    height: auto;
    margin-bottom: 20px;
    box-shadow: 0 0 15px #f0754f;
  }
  
  .meal-info {
    text-align: left;
    font-family: Arial, Helvetica, sans-serif;
    font-size: 20px;
    list-style-type: disc;
    margin-left: 20px;
  }

  .recipe-name {
    text-align: center;
    margin-top: 20px;
    font-family: Arial, Helvetica, sans-serif;
    font-size: 24px;
  }

  </style>