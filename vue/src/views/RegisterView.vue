<template>
  <main>
  <div id="register" class="text-center">
    <header>
        <nav>
          <a href="{name: home}">Home</a>
          <p>Meals</p>
          <p>Meal Plans</p>
        </nav>
      </header>
      <body>
        <div id="main-content">
          <h2>Welcome! Let's get planning!</h2>
        <form v-on:submit.prevent="register">
      <h2>Create Account</h2>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <button type="submit">Create Account</button>
      <p><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
        </div>
      </body>
  </div>
</main>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
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
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
main{
  background-image: url("healthy_background.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}
form{
  display: flex;
  flex-direction: column;
  align-items: center;
}
header{
  background-color:#f0754f;
  padding: 20px;
  margin-bottom: none;
}
nav{
  display:flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 20px;
}
#main-content{
  display:flex;
  flex-direction: column;
  align-items: center;
  margin-top: 200px;
  margin-right: 40%;
  margin-left: 40%;
  padding-bottom: 45rem;
  padding-top: 10rem;
  font-family: Arial, Helvetica, sans-serif;
}
</style>
