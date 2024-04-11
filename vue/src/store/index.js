import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},

      meals: [
        {
          idmeal: 1,
          strmeal: "Apple Frangipan Tart",
          strinstructions: "Preheat the oven to 200C/180C Fan/Gas 6.\nPut the biscuits in a large re-sealable freezer bag and bash with a rolling pin into fine crumbs. Melt the butter in a small pan, then add the biscuit crumbs and stir until coated with butter. Tip into the tart tin and, using the back of a spoon, press over the base and sides of the tin to give an even layer. Chill in the fridge while you make the filling.\nCream together the butter and sugar until light and fluffy. You can do this in a food processor if you have one. Process for 2-3 minutes. Mix in the eggs, then add the ground almonds and almond extract and blend until well combined.\nPeel the apples, and cut thin slices of apple. Do this at the last minute to prevent the apple going brown. Arrange the slices over the biscuit base. Spread the frangipane filling evenly on top. Level the surface and sprinkle with the flaked almonds.\nBake for 20-25 minutes until golden-brown and set.\nRemove from the oven and leave to cool for 15 minutes. Remove the sides of the tin. An easy way to do this is to stand the tin on a can of beans and push down gently on the edges of the tin.\nTransfer the tart, with the tin base attached, to a serving plate. Serve warm with cream, crème fraiche or ice cream.",
          strtags: "Tart,Baking,Fruity",
          ingredientList: null,
          strmealthumb: "https://www.themealdb.com/images/media/meals/wxywrq1468235067.jpg",
          stryoutube: "https://www.youtube.com/watch?v=rp8Slv4INLk"
        },

        {
          "idmeal": 52997,
          "strmeal": "Beef Banh Mi Bowls with Sriracha Mayo, Carrot & Pickled Cucumber",
          "strinstructions": "Add'l ingredients: mayonnaise, siracha\n\n1\n\nPlace rice in a fine-mesh sieve and rinse until water runs clear. Add to a small pot with 1 cup water (2 cups for 4 servings) and a pinch of salt. Bring to a boil, then cover and reduce heat to low. Cook until rice is tender, 15 minutes. Keep covered off heat for at least 10 minutes or until ready to serve.\n\n2\n\nMeanwhile, wash and dry all produce. Peel and finely chop garlic. Zest and quarter lime (for 4 servings, zest 1 lime and quarter both). Trim and halve cucumber lengthwise; thinly slice crosswise into half-moons. Halve, peel, and medium dice onion. Trim, peel, and grate carrot.\n\n3\n\nIn a medium bowl, combine cucumber, juice from half the lime, ¼ tsp sugar (½ tsp for 4 servings), and a pinch of salt. In a small bowl, combine mayonnaise, a pinch of garlic, a squeeze of lime juice, and as much sriracha as you’d like. Season with salt and pepper.\n\n4\n\nHeat a drizzle of oil in a large pan over medium-high heat. Add onion and cook, stirring, until softened, 4-5 minutes. Add beef, remaining garlic, and 2 tsp sugar (4 tsp for 4 servings). Cook, breaking up meat into pieces, until beef is browned and cooked through, 4-5 minutes. Stir in soy sauce. Turn off heat; taste and season with salt and pepper.\n\n5\n\nFluff rice with a fork; stir in lime zest and 1 TBSP butter. Divide rice between bowls. Arrange beef, grated carrot, and pickled cucumber on top. Top with a squeeze of lime juice. Drizzle with sriracha mayo.",
          "strtags": null,
          "ingredientList": null,
          "strmealthumb": "https://www.themealdb.com/images/media/meals/z0ageb1583189517.jpg",
          "stryoutube": null
        },

        {
          "idmeal": 53036,
          "strmeal": "Boxty Breakfast",
          "strinstructions": "STEP 1\nBefore you start, put your oven on its lowest setting, ready to keep things warm. Peel the potatoes, grate 2 of them, then set aside. Cut the other 2 into large chunks, then boil for 10-15 mins or until tender. Meanwhile, squeeze as much of the liquid from the grated potatoes as you can using a clean tea towel. Mash the boiled potatoes, then mix with the grated potato, spring onions and flour.\n\nSTEP 2\nWhisk the egg white in a large bowl until it holds soft peaks. Fold in the buttermilk, then add the bicarbonate of soda. Fold into the potato mix.\n\nSTEP 3\nHeat a large non-stick frying pan over a medium heat, then add 1 tbsp butter and some of the oil. Drop 3-4 spoonfuls of the potato mixture into the pan, then gently cook for 3-5 mins on each side until golden and crusty. Keep warm on a plate in the oven while you cook the next batch, adding more butter and oil to the pan before you do so. You will get 16 crumpet-size boxty from the mix. Can be made the day ahead, drained on kitchen paper, then reheated in a low oven for 20 mins.\n\nSTEP 4\nHeat the grill to medium and put the tomatoes in a heavy-based pan. Add a good knob of butter and a little oil, then fry for about 5 mins until softened. Grill the bacon, then pile onto a plate and keep warm. Stack up the boxty, bacon and egg, and serve the tomatoes on the side.",
          "strtags": null,
          "ingredientList": null,
          "strmealthumb": "https://www.themealdb.com/images/media/meals/naqyel1608588563.jpg",
          "stryoutube": "https://www.youtube.com/watch?v=80W0mCFDIP0"
        },

        {
          "idmeal": 52839,
          "strmeal": "Chilli prawn linguine",
          "strinstructions": "Mix the dressing ingredients in a small bowl and season with salt and pepper. Set aside.\n\nCook the pasta according to the packet instructions. Add the sugar snap peas for the last minute or so of cooking time.\n\nMeanwhile, heat the oil in a wok or large frying pan, toss in the garlic and chilli and cook over a fairly gentle heat for about 30 seconds without letting the garlic brown. Tip in the prawns and cook over a high heat, stirring frequently, for about 3 minutes until they turn pink.\n\nAdd the tomatoes and cook, stirring occasionally, for 3 minutes until they just start to soften. Drain the pasta and sugar snaps well, then toss into the prawn mixture. Tear in the basil leaves, stir, and season with salt and pepper.\n\nServe with salad leaves drizzled with the lime dressing, and warm crusty bread.",
          "strtags": null,
          "ingredientList": null,
          "strmealthumb": "https://www.themealdb.com/images/media/meals/usywpp1511189717.jpg",
          "stryoutube": "https://www.youtube.com/watch?v=SC17Mc70Db0"
        }

      ]


    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      }
    },
  });
  return store;
}
