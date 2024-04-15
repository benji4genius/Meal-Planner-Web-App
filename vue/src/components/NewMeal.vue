<template>
    <form v-on:submit.prevent="addNewMeal">
      <div class="form-element">
        <label for="strmeal">Meal Name:</label>
        <input id="strmeal" type="text" v-model="newMeal.strmeal" />
      </div>
      <div class="form-element">
        <label for="strmealthumb">Image (Copy and paste the image link):</label>
        <input id="strmealthumb" type="text" v-model="newMeal.strmealthumb">
      </div>
      <div class="form-element">
        <label for="strtags">Tags:</label>
        <input id="strtags" v-model.number="newMeal.strtags"/>
      </div>
      <div class="form-element">
        <label for="strinstructions">Directions:</label>
        <textarea id="strinstructions" type="text" v-model="newMeal.strinstructions"></textarea>
      </div>
      <div class="form-element">
        <label for="stringredient1">Ingredient 1:</label>
        <input id="stringredient1" type="text" v-model="newMeal.stringredient1">
      </div>
      <div class="form-element">
        <label for="stringredient2">Ingredient 2:</label>
        <input id="stringredient2" type="text" v-model="newMeal.stringredient2">
      </div>
      <div class="form-element">
        <label for="stringredient3">Ingredient 3:</label>
        <input id="stringredient3" type="text" v-model="newMeal.stringredient3">
      </div>
      <div class="form-element">
        <label for="stringredient4">Ingredient 4:</label>
        <input id="stringredient4" type="text" v-model="newMeal.stringredient4">
      </div>
      <div class="form-element">
        <label for="stringredient5">Ingredient 5:</label>
        <input id="stringredient5" type="text" v-model="newMeal.stringredient5">
      </div>
      <div class="form-element">
        <label for="stringredient6">Ingredient 6:</label>
        <input id="stringredient6" type="text" v-model="newMeal.stringredient6">
      </div>
      <div class="form-element">
        <label for="stringredient7">Ingredient 7:</label>
        <input id="stringredient7" type="text" v-model="newMeal.stringredient7">
      </div>
      <div class="form-element">
        <label for="stringredient8">Ingredient 8:</label>
        <input id="stringredient8" type="text" v-model="newMeal.stringredient8">
      </div>
      <div class="form-element">
        <label for="stringredient9">Ingredient 9:</label>
        <input id="stringredient9" type="text" v-model="newMeal.stringredient9">
      </div>
      <div class="form-element">
        <label for="stringredient10">Ingredient 10:</label>
        <input id="stringredient10" type="text" v-model="newMeal.stringredient10">
      </div>
      <div class="form-element">
        <label for="stringredient11">Ingredient 11:</label>
        <input id="stringredient11" type="text" v-model="newMeal.stringredient11">
      </div>
      <div class="form-element">
        <label for="stringredient12">Ingredient 12:</label>
        <input id="stringredient12" type="text" v-model="newMeal.stringredient12">
      </div>
      <div class="form-element">
        <label for="stringredient13">Ingredient 13:</label>
        <input id="stringredient13" type="text" v-model="newMeal.stringredient13">
      </div>
      <div class="form-element">
        <label for="stringredient14">Ingredient 14:</label>
        <input id="stringredient14" type="text" v-model="newMeal.stringredient14">
      </div>
      <div class="form-element">
        <label for="stringredient15">Ingredient 15:</label>
        <input id="stringredient15" type="text" v-model="newMeal.stringredient15">
      </div>
      <div class="form-element">
        <label for="stringredient16">Ingredient 16:</label>
        <input id="stringredient16" type="text" v-model="newMeal.stringredient16">
      </div>
      <div class="form-element">
        <label for="stringredient17">Ingredient 17:</label>
        <input id="stringredient17" type="text" v-model="newMeal.stringredient17">
      </div>
      <div class="form-element">
        <label for="stringredient18">Ingredient 18:</label>
        <input id="stringredient18" type="text" v-model="newMeal.stringredient18">
      </div>      
      <div class="form-element">
        <label for="stringredient19">Ingredient 19:</label>
        <input id="stringredient19" type="text" v-model="newMeal.stringredient19">
      </div>
      <div class="form-element">
        <label for="stringredient20">Ingredient 20:</label>
        <input id="stringredient20" type="text" v-model="newMeal.stringredient20">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 1:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 2:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 3:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 4:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 5:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 6:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 7:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 8:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 9:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 10:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 11:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 12:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 13:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 14:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 15:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 16:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 17:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 18:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure1">Measurement 19:</label>
        <input id="strmeasure1" type="text" v-model="newMeal.strmeasure1">
      </div>
      <div class="form-element">
        <label for="strmeasure20">Measurement 20:</label>
        <input id="strmeasure20" type="text" v-model="newMeal.strmeasure20">
      </div>
      <input type="submit" value="Save" />
      <input type="button" value="Cancel" v-on:click="resetForm" />
    </form>
  </template>
  
  <script>
  export default {
    props: ['idmeal'],
    data() {
      return {
        newMeal: {}
      };
    },
    methods: {
      addNewMeal() {
        this.newMeal.idmeal = this.idmeal;
        this.$store.commit('ADD_TO_MY_MEALS', this.newMeal);
        this.$router.push({ name: 'mealDetails', params: { id: this.idmeal } });
      },
      resetForm() {
        this.newMeal = {};
      }
    }
  };
  </script>

  <style scoped>
.form-element {
  margin-top: 10px;
}

.form-element label {
  display: block;
}

.form-element input,
.form-element select {
  height: 30px;
  width: 300px;
}

.form-element textarea {
  height: 60px;
  width: 300px;
}

form input[type=button] {
  width: 100px;
}

form input[type=submit] {
  width: 100px;
  margin-right: 10px;
}
</style>
