<template>
  <main>
  <div class="home">
    <header>
        <nav>
          <p class="link">Ingredients</p>
          <p class="link"><router-link v-bind:to="{ name: 'meals' }">Meals</router-link></p>
          <img class="logo" src="Untitled Design.png"/>
          <!-- Update this section -->
          <p class="link"><router-link to="/meal_plan">Meal Plans</router-link></p>
          <!-- Updated section ends -->
          <p class="link"><router-link v-bind:to="{ name: 'logout' }">Logout</router-link></p>
        </nav>
      </header>
      <body>
        <div id="main-content">
          <h2>Welcome! Let's get planning!</h2>
        </div>
      </body>
  </div>
</main>
</template>

<script>
import { RouterLink } from 'vue-router';

export default {
    components: { RouterLink }
};
</script>

<style scoped>
main{
  background-image: url("healthy_background.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}
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
}
.logo{
  height: 100px;
  border: 2px solid black;
}
#main-content{
  display:flex;
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
</style>
