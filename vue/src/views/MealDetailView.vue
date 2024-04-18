<template>
  <main>
    <header>
      <nav>
        <p class="link" href="{name: home}"><router-link v-bind:to="{ name: 'home' }">Home</router-link></p>

        <!-- <router-link to="/">
          <img class="logo" src="Chefs_Hat.png" />
        </router-link> -->


        <router-link to="/mymeals">
          <p class="link">My Meals</p>
        </router-link>

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
              <ul>
                <p>{{ meal.stringredient1 }}</p>
                <p>{{ meal.stringredient2 }}</p>
                <p>{{ meal.stringredient3 }}</p>
                <p>{{ meal.stringredient4 }}</p>
                <p>{{ meal.stringredient5 }}</p>
                <p>{{ meal.stringredient6 }}</p>
                <p>{{ meal.stringredient7 }}</p>
                <p>{{ meal.stringredient8 }}</p>
                <p>{{ meal.stringredient9 }}</p>
                <p>{{ meal.stringredient10 }}</p>
                <p>{{ meal.stringredient11 }}</p>
                <p>{{ meal.stringredient12 }}</p>
                <p>{{ meal.stringredient13 }}</p>
                <p>{{ meal.stringredient14 }}</p>
                <p>{{ meal.stringredient15 }}</p>
                <p>{{ meal.stringredient16 }}</p>
                <p>{{ meal.stringredient17 }}</p>
                <p>{{ meal.stringredient18 }}</p>
                <p>{{ meal.stringredient19 }}</p>
                <p>{{ meal.stringredient20 }}</p>
              </ul>
              <ul>
                <p>{{ meal.strmeasure1 }}</p>
                <p>{{ meal.strmeasure2 }}</p>
                <p>{{ meal.strmeasure3 }}</p>
                <p>{{ meal.strmeasure4 }}</p>
                <p>{{ meal.strmeasure5 }}</p>
                <p>{{ meal.strmeasure6 }}</p>
                <p>{{ meal.strmeasure7 }}</p>
                <p>{{ meal.strmeasure8 }}</p>
                <p>{{ meal.strmeasure9 }}</p>
                <p>{{ meal.strmeasure10 }}</p>
                <p>{{ meal.strmeasure11 }}</p>
                <p>{{ meal.strmeasure12 }}</p>
                <p>{{ meal.strmeasure13 }}</p>
                <p>{{ meal.strmeasure14 }}</p>
                <p>{{ meal.strmeasure15 }}</p>
                <p>{{ meal.strmeasure16 }}</p>
                <p>{{ meal.strmeasure17 }}</p>
                <p>{{ meal.strmeasure18 }}</p>
                <p>{{ meal.strmeasure19 }}</p>
                <p>{{ meal.strmeasure20 }}</p>
              </ul>
              <ol>
                <p>{{ meal.strinstructions }}</p>
              </ol>
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
        stryoutube: '',
        stringredient1: '',
        stringredient2: '',
        stringredient3: '',
        stringredient4: '',
        stringredient5: '',
        stringredient6: '',
        stringredient7: '',
        stringredient8: '',
        stringredient9: '',
        stringredient10: '',
        stringredient11: '',
        stringredient12: '',
        stringredient13: '',
        stringredient14: '',
        stringredient15: '',
        stringredient16: '',
        stringredient17: '',
        stringredient18: '',
        stringredient19: '',
        stringredient20: '',
        strmeasure1: '',
        strmeasure2: '',
        strmeasure3: '',
        strmeasure4: '',
        strmeasure5: '',
        strmeasure6: '',
        strmeasure7: '',
        strmeasure8: '',
        strmeasure9: '',
        strmeasure10: '',
        strmeasure11: '',
        strmeasure12: '',
        strmeasure13: '',
        strmeasure14: '',
        strmeasure15: '',
        strmeasure16: '',
        strmeasure17: '',
        strmeasure18: '',
        strmeasure19: '',
        strmeasure20: ''
      }
    };
  },

  created() {
    let idmeal = parseInt(this.$route.params.idmeal);
    MealService.getMealById(idmeal)
      .then(response => {
        this.meal = response.data;
        console.log(this.meal);
      });
  }

}
</script>
  
<style scoped>
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