# Final Capstone
​
Developed by: benji4genius and your 5 fellow programmers (JakeCodesToo, melissastevens3, rizal4585, Kem1004, aorlandoTE(Instructor)).

This document guides you through setting up and running the Vue starter project for the final capstone. It also explains the project's features, such as Vue Router, Vuex, and authentication.

- FUTURE IMPROVEMENTS

This project serves as a solid foundation, but there's always room for improvement. We plan to implement additional features in the future, such as building a mobile version and potentially implemeenting a non relational database for optimized funtionality. Feel free to contribute your ideas as well!

- CONTRIBUTION

We welcome contributions from the community! If you have improvements, bug fixes, or new features you'd like to add, feel free to fork the repository and submit a pull request. We appreciate your help in making this project even better.

- PROJECT SETUP

Clone the Repository:

Begin by cloning the repository to your local machine.

Install Dependencies:

Navigate to the project directory and run the following command to install all required dependencies:   

Bash
npm install


Review the .env File:

The .env file located in the project root stores environment variables used throughout the application. You can customize these variables as needed.

Start the Application:

Run the following command to start the Vue application in development mode:

Bash
npm run dev
Use code with caution.

This will launch the application in your default web browser, typically at http://localhost:8080.

Authentication
Upon initial project launch, you'll be directed to a login page as the base URL (/) is secured by default.

Navigation Guards:

Vue Router utilizes navigation guards to control access to routes. These guards are defined in src/router/index.js. They run before each navigation and check if the route requires authentication based on the requiresAuth property in the route's meta object. Protected routes redirect users to the login page if they're not authenticated.

Authentication Flow:

Login:

The user attempts to access a protected route.
The navigation guard checks if authentication is required and if the user's token exists in Vuex state.
If authentication is not required or the token exists, the user proceeds to the requested route.
If authentication is required and the token doesn't exist, the user is redirected to the login page (/login).
Login Process:

The user submits their credentials on the login page.
The login method in src/views/LoginView.vue sends a POST request to the backend's /login endpoint using src/services/AuthService.js.
Upon successful login (status code 200), the response containing the authentication token and user object is used to update Vuex state with mutations.
The token is also stored in local storage for persistence.
The user is redirected to the homepage (/).
Logout:

Clicking the logout link triggers the LOGOUT mutation in the Vuex store.
This mutation removes the token from local storage, clears the token and user state, and resets the Axios authorization header.
The user is redirected to the login page, which in turn redirects them back to the login page due to the lack of authentication.
Vuex
The application utilizes Vuex (src/store/index.js) to manage the application state. The state object holds the authentication token (token) and user information (user). Upon successful login, the token and user object are retrieved from the backend and stored in Vuex state using mutations.

Login
The login functionality resides in src/views/LoginView.vue. The login method sends a POST request containing the user's credentials to the backend's /login endpoint. Upon successful login, the response is used to update Vuex state and set the Axios authorization header.

Logout
The logout functionality resides in src/views/LogoutView.vue. Clicking the logout link triggers the LOGOUT mutation, which clears the token, user information, and Axios authorization header.

Register
Similar to login, the registration functionality resides in src/views/RegisterView.vue. The register method sends a POST request containing the user's registration details to the backend's registration endpoint. Upon successful registration (status code 201), the user is redirected to the login page with a success message.

- DEMO
  Check out some project images below:
![Registration Page](https://github.com/user-attachments/assets/2ea54b57-6ff7-45c9-ba8b-23152ff583ff)
![Log in page](https://github.com/user-attachments/assets/73591ec5-53b8-4c7b-b993-7934d4c197e4)
![Main page](https://github.com/user-attachments/assets/1b44c265-b375-4f6f-8298-1bfc6945717d)
![Meal selection page](https://github.com/user-attachments/assets/71ef0c3b-6195-483d-ab8e-b09d86889e02)
![User Selected Meal Page](https://github.com/user-attachments/assets/105dec49-17f5-4546-8eb2-c35460c5ecd1)
![Meal Plan page with calendar feature](https://github.com/user-attachments/assets/5c23e39b-5995-4c38-a360-5a8efd3439a3)




  
