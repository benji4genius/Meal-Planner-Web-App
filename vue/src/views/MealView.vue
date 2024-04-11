<template>
    <main>
        <header>
            <nav>
                <a class="link" href="{name: home}">Home</a>
                <img class="logo" src="Untitled Design.png"/>
                <p class="link">Meals</p>
            </nav>
      </header>
      <body>
        <div id="main-content">
            <div class="card" style="width: 20rem;">
                <img class="image-top" src="chicken_soup.jpg" alt="Card example image">
                <div class="card-body">
                    <h4 class="card-title">Chicken Noodle Soup</h4>
                    <h5 class="card-subtitle">Perfect for a rainy day!</h5>
                    <p class="card-text">Ingredients</p>
                    <ul class="card-text">
                        <li>2 Tbsp olive oil ($0.32)</li>
                        <li>1 medium yellow onion ($0.37)</li>
                        <li>3 cloves garlic ($0.24)</li>
                        <li>1/2 lb. carrots ($0.49)</li>
                        <li>1/2 bunch celery ($0.83)</li>
                        <li>2 split chicken breasts, bone-in ($6.64)</li>
                        <li>1 tsp dried basil ($0.10)</li>
                        <li>1 Tbsp dried parsley ($0.15)</li>
                        <li>1/2 tsp dried thyme ($0.05)</li>
                        <li>1 bay leaf ($0.15)</li>
                        <li>1/4 tsp Freshly cracked pepper ($0.05)</li>
                        <li>2-3 tsp salt ($0.05)</li>
                        <li>6 oz. egg noodles ($1.00)</li>
                    </ul>
                    <p class="card-text">Directions</p>
                    <p class="card-text">Dice the onion and mince the garlic. Add the onion, garlic, and olive oil to a large pot and sauté over medium heat for about 5 minutes, or until the onions are soft and transparent.
While the onion and garlic are sautéing, wash and slice the carrots and celery. Add them to the pot and continue to sauté for a few minutes more.
Pull the skin and any excess fat from the chicken breasts. Add the breasts to the pot along with the bay leaf, basil, parsley, thyme, some freshly cracked pepper, and 8 cups of water. Cover the pot, bring it to a boil over high heat, then reduce the heat to low and simmer for one hour. Make sure the pot continues to simmer for the whole hour. If the heat is turned down too low and it is not bubbling away, the chicken will not shred easily.
After an hour of simmering, remove the chicken from the pot. Using two forks, pull the meat from the bone and shred it slightly. Season the broth with salt. Begin with one teaspoon and add more to your liking. I used 2-3 teaspoons. The flavor of the broth will really pop once the salt is added.
Add the noodles to the pot, turn the heat up to high, and boil the noodles until tender (about 7 minutes). Return the shredded chicken to the pot. Taste and season again with salt if needed (I didn’t need to). Serve hot!</p>
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
            this.meals = response.data;
            
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
  created(){
    this.loadMeals();
  }
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

    .card-link + .card-link,
    a + a {
      margin-left: 1.25rem;
    }
  }

  .image-top,
  .image-bottom,
  img {
    border: 0;
    border-radius: 0;
  }
}
</style>