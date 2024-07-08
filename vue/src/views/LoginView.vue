<template>
  <main>
    <div id="login">
      <header>
        <nav>
          <img class="logo" src="plantoplate-favicon-white.png"/>
        </nav>
      </header>
      <body>
        <div id="main-content">
          <img class="logo-name" src="logo-orange-hat.png"/>
          <h1>Welcome! Get ready to plan, prep, and enjoy!</h1>
          <h2>Please Sign In</h2>
        <form v-on:submit.prevent="login">
        
        <div role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <div class="form-input-group">
          <label id="log-in-text" for="username">Username:</label>
          <input type="text" id="username" v-model="user.username" required autofocus />
        </div>
        <div class="form-input-group">
          <label id="log-in-text" for="password">Password:</label>
          <input type="password" id="password" v-model="user.password" required />
        </div>
        <button id="submit-btn" type="submit">Sign in</button>
        <p>
        <router-link id="sign-up-link" v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
      </form>
        </div>
      </body>
    </div>
  </main>
  <footer>
    <p>This meal plan application was meticulously crafted, cooked, and served by Benjamin Adetunlese, Jake Lilly, Katherine Miller, Saraswati Rizal, and Melissa Stevens.</p>
  </footer>
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

.logo-name {
  width: 500px;
  height: auto;
  margin-bottom: 100px;
  justify-content: center;
}

main{
  background-image: url("login-page-photo.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center center;
  position: relative;
  padding-bottom: 1rem;
}
form{
  display: flex;
  flex-direction: column;
  align-items: center;
}
header{
  background-color:#f0754f;
  padding: 20px;
  border-bottom: 2px solid black;
  margin-top: -10px;
}

footer {
  background-color:#f0754f;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
  bottom: 0;
  left: 0;
  width:100%;
  height: 100px;
  border-top: 2px solid black;
  font-family: 'Cabin Sketch', cursive;
  font-weight: bold;

 
}

nav{
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 20px;
  height: 100px;
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
  font-family: 'Cabin Sketch', cursive;
}
.logo {
  width: 100px;
  height: auto;
  align-self: center;
  position: absolute;
  padding-left: 1px;
  padding-right: 1px;
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
  transition: all 23v5ms ease-in-out;
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

h1 {
  text-align: center;
  white-space: nowrap;
  display: inline-block;
  margin-right: 2px;
  font-size: 50px;
}
.form-input-group{
  border: 2px solid #ccc;
  border-width: 10px;
  border-radius: 6px;
 font-size: 16px;
}
#username{
  font-size: 25px;
}
#password{
  font-size: 25px;
}

#log-in-text{
  font-size: 25px;
}

#submit-btn{
  
  color: black;
  padding: 12px 20px;
  margin: 8px 0;
  border: 3px solid #ccc;
  border-radius: 6px;
  cursor: pointer;
  font-size: 24px;
}
#submit-btn:hover{
  background-color: #f0754f;
  color: white;
}
#sign-up-link{
  font-size: 25px;
  color: blue;
  padding: 2px 10px;
  margin: 8px 0; 
  border: 1px solid #ccc;
  border-radius: 6px;
  cursor: pointer;
  font-size: 25px;
}
</style>