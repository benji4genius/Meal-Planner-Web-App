<template>
  <main>
    <div class="home">
      <header>

        <nav>
          <p class="link"><router-link v-bind:to="{ name: 'meals' }">Meals</router-link></p>
          <p class="link"><router-link v-bind:to="{ name: 'mymeals' }">My Meals</router-link></p>
          <img class="plan-to-plate-nav" src="plantoplate-favicon-white.png"/>
          <!-- Update this section -->
          <p class="link"><router-link to="/mealplans">Meal Plans</router-link></p>
          <!-- Updated section ends -->
          <p class="link"><router-link to="/logout">Logout</router-link></p>
        </nav>

      </header>

      <body>
        
        <div id="main-content">
          <div><img class="plan-to-plate" src="logo-orange-hat.png"/>
          </div>
         
          <h1 class="main-title">
             Meal Planning Made Easy
          </h1>
            <h2 class=" welcome-text">Let's get planning!</h2>
              <div class="steps-text">
                <h3>Step 1: Choose your meals</h3>
                <h3>Step 2: Add to your Meal Plan</h3>
                <h3>Step 3: Get cookin'</h3>
              </div>
          </div>
      </body>
    </div>
      <footer>
        <p>This meal plan application was meticulously crafted, cooked, and served by Benjamin Adetunlese, Jake Lilly, Katherine Miller, Saraswati Rizal, and Melissa Stevens.</p>
      </footer>
  </main>
</template>

<script>
import { RouterLink } from 'vue-router';

export default {
  components: { RouterLink }
};
</script>

<style scoped>
main {
  background-image: url("plates of salad.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center center;
  padding: 0;
  margin: 0;
  position: relative;
}

header {
  background-color: #f0754f;
  padding: 20px;
  border: 2px solid black
}

.plan-to-plate-nav {
  width: 100px;
  height: auto;
}

.plan-to-plate {
  width: 500px;
  height: auto;
  margin-bottom: 175px;
  justify-content: center;
}

footer {
  background-color:#f0754f;
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  width: 100%;
  height: 145px;
  border: 2px solid black;
  font-family: 'Cabin Sketch', cursive;
  font-weight: bold;
  bottom: 0;
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

/* added this for title */
.main-title {

  -webkit-font-smoothing: antialiased;
  text-rendering: optimizeLegibility;
  text-size-adjust: 100%;

  box-sizing: inherit;
  word-break: break-word;
  line-height: 1.125;
  padding-bottom: 5px;
  text-transform: none;
  margin-bottom: 1.5rem;
  font-size: 60px;
  font-family: 'Cabin Sketch', cursive;
  color: #007444;
  background-color: rgba(255, 255, 255, 0.75);
  border-radius: 10px;
  padding: 15px;
  font-weight: bold;
  text-align: center;
}

.stepscontainer {
  display: flex;
  justify-content: center;
  align-items: center;
  top: 900px;
  right: 1000px;
  position: absolute;

}

.steps {
  text-align: center;
  align-items: center;
  justify-content: center;
}

.step-image {
  width: 150px;
  /* Adjust as needed */
  height: auto;
  justify-content: space-around;
  padding: 50px;
  align-items: center;
  top: 100px;
}

.nb {
  font-size: 24px;
  /* Adjust as needed */
  font-weight: bold;
}

#main-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 200px;
  /* margin-right: 40%;
  margin-left: 40%; */
  padding-bottom: 42.75rem;
  padding-top: 10rem;
  font-family: 'Cabin Sketch', cursive;
}

.welcome-text {
  font-size: 40px;
  color: #007444;
  background-color: rgba(255, 255, 255, 0.75);
  border-radius: 10px;
  padding: 15px;
  font-family: 'Cabin Sketch', cursive;
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

.steps-text {
  color: black;
  border-radius: 10px;
  padding: 15px;
  font-size: 20px;
}
</style>
