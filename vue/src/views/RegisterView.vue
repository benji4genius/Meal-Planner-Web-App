<template>
  <main>
    <div id="register" class="text-center">
      <header>
        <nav>
          <img class="plan-to-plate-nav" src="plantoplate-favicon-white.png" />
        </nav>
      </header>

      <body>
        <div id="main-content">
          <div class="welcome-text">
            <h1>Start your journey to a healthier life!</h1>
          </div>
          <h2>Making life easier one meal at a time.</h2>
          <form v-on:submit.prevent="register">
            <h2>Create Account</h2>
            <div role="alert" v-if="registrationErrors">
              {{ registrationErrorMsg }}
            </div>
            <div class="form-input-group">
              <label id="sign-up-text" for="username">Username</label>
              <input type="text" id="username" v-model="user.username" required autofocus />
            </div>
            <div class="form-input-group">
              <label id="sign-up-text" for="password">Password</label>
              <input type="password" id="password" v-model="user.password" required />
            </div>
            <div class="form-input-group">
              <label id="sign-up-text" for="confirmPassword">Confirm Password</label>
              <input type="confirmPassword" id="confirmPassword" v-model="user.confirmPassword" required />
            </div>
            <button id="submit-btn" type="submit">Create Account</button>
            <p><router-link id="sign-up-link" v-bind:to="{ name: 'login' }">Already have an account? Log
                in.</router-link></p>
          </form>
        </div>
      </body>
    </div>
    <footer>
      <p>This meal plan application was meticulously crafted, cooked, and served by
        Benjamin Adetunlese, Jake Lilly, Katherine Miller, Saraswati Rizal, and Melissa Stevens.</p>
    </footer>
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

main {
  background-image: url("login-page-photo.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center center;
  padding: 0;
  margin: 0;
  position: relative;
}

.welcome-text {
  text-align: center;
  font-family: Neucha, sans-serif;
  white-space: nowrap;
  display: inline-block;
  margin-right: 20px;
  font-size: 35px;
}

footer {
  background-color: #f0754f;
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  margin-bottom: 0;
  width: 100%;
  height: 145px;
  border: 2px solid black;
  font-family: Arial, Helvetica, sans-serif;
  font-weight: bold;
}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
}

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

.logo {
  width: 200px;
  height: auto;
  align-self: center;
  position: absolute;
  margin-right: 1px;
  margin-left: 1px;
}

#main-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 200px;
  margin-right: 40%;
  margin-left: 40%;
  padding-bottom: 42.75rem;
  padding-top: 10rem;
  text-align: center;
  font-family: Neucha, sans-serif;
}

h1 {
  font-family: 'Cabin Sketch', cursive;
}

h2 {
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

.form-input-group {
  border: 2px solid #ccc;
  border-width: 10px;
  border-radius: 6px;
  font-size: 16px;
}

#username {
  font-size: 25px;
}

#password {
  font-size: 25px;
}

#confirmPassword {
  font-size: 19px;
}

#sign-up-text {
  font-size: 25px;
}

#submit-btn {

  color: black;
  padding: 12px 20px;
  margin: 8px 0;
  border: 3px solid #ccc;
  border-radius: 6px;
  cursor: pointer;
  font-size: 24px;
}

#submit-btn:hover {
  background-color: #f0754f;
  color: white;
}

#sign-up-link {
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
