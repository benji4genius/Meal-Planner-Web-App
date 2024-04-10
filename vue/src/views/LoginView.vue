<template>
  <main>
    <div id="login">
      <header>
        <nav>
          <a class="link" href="{name: home}">Home</a>
          <p class="link">Link</p>
          <img class="logo" src="Untitled Design.png"/>
          <p class="link">Meals</p>
          <p class="link">Meal Plans</p>
        </nav>
      </header>
      <body>
        <div id="main-content">
          <h2>Welcome! Let's get planning!</h2>
        <form v-on:submit.prevent="login">
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
      </body>
    </div>
  </main>
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
      invalidCredentials: false
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
  border: 2px solid black;
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
  font-family: Neucha, sans-serif;
}
.logo{
  height: 100px;
  border: 2px solid black;
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