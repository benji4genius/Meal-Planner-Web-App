<template>
  <div id="login">
    <header>
      <button
        id="show-form-button"
        href="#"
        v-on:click.prevent="showForm = true"
        v-if="showForm === false">
        Sign in
      </button>
    </header>
    <form v-on:submit.prevent="login" v-show="showForm === true">
      <h2>Please Sign In</h2>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign in</button>
      <p>
      <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
  <div id="main">
      <div id="welcome">
          <h2>Welcome! Let's get planning!</h2>
      </div>
    <body id="body">
      <img class="background" src="healthy_background.jpg"/>
    </body>
  </div>
</template>

<script>
import authService from "../services/AuthService";
export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false,
      showForm: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
body{
  background-image: url("healthy_background.jpg");
  background-repeat: no-repeat;
  margin: none;
  padding: none;
}
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
#show-form-button{
  margin-left: 92%;
  margin-top: 1.5rem;
}
form{
  display: flex;
  flex-direction: column;
  align-items: center;
}
header{
  background-color:#f0754f;
  padding-bottom: 25px;
}

div #welcome{
  display: flex;
  justify-content: center;
  margin: 5%;
  font-family: Arial, Helvetica, sans-serif;
}

</style>