<template>
    <main>
      <header>
        <nav>
          <p class="link" href="{name: home}"><router-link v-bind:to="{ name: 'home' }">Home</router-link></p>
          <img class="logo" src="Untitled Design.png" />
          <p class="link">Meal Details</p>
        </nav>
      </header>
  
      <body>
        <div id="main-content">
          <div class="meal-details">
            <img class="image-top" src="chicken_soup.jpg" alt="Meal image">
            <div class="meal-info">
              <h2>{{ mealDetails.strMeal }}</h2>
              <p>Description: {{ mealDetails.strInstructions }}</p>
              <!-- Add more details here -->
            </div>
          </div>
        </div>
      </body>
    </main>
  </template>
  
  <script>
  export default {
    data() {
      return {
        mealDetails: {} // Placeholder for meal details
      };
    },
    methods: {
      loadMealDetails() {
       
        // MealService.getMealDetails(this.$route.params.id)
        //   .then(response => {
        //     this.mealDetails = response.data;
        //   })
        //   .catch(error => {
        //     console.error('Error fetching meal details:', error);
        //   });
      }
    },
    created() {
      this.loadMealDetails();
    }
  };
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
.logo{
  height: 100px;
  border: 2px solid black;
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
  }
  
  .meal-info {
    text-align: center;
  }
  </style>