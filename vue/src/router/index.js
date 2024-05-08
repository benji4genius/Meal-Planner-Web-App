import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'
// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import MealView from '../views/MealView.vue';
import MyMealView from '../views/MyMealView.vue';
import MealDetailView from '../views/MealDetailView.vue';
import MealPlanView from '../views/MealPlanView.vue';
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/mymeals",
    name: "mymeals",
    component: MyMealView,
    meta: {
      requiresAuth:false
    }
  },
  {
    path: "/meals",
    name: "meals",
    component: MealView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/meal_details/:idmeal",
    name: "mealDetails",
    component: MealDetailView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/mealplans",
    name: "mealplans",
    component: MealPlanView,
    meta: {
      requiresAuth: false
    }
  }
];
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});
router.beforeEach((to) => {
  // Get the Vuex store
  const store = useStore();
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return { name: "login" };
  }
  // Otherwise, do nothing and they'll go to their next destination
});
export default router;







