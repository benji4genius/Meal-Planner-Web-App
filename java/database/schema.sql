 BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS ingredients;

CREATE TABLE ingredients (
   idIngredient   INTEGER  NOT NULL
  ,strIngredient  VARCHAR(100) NOT NULL
  ,strDescription TEXT
  ,strType        VARCHAR(50),
  CONSTRAINT PK_ingredient PRIMARY KEY (idIngredient)
);

DROP TABLE IF EXISTS meal_plans;

CREATE TABLE meal_plans (
    meal_plan_id SERIAL NOT NULL,
    user_id INTEGER NOT NULL,
    name varchar(50) NOT NULL,
    description varchar(200) NOT NULL,
    CONSTRAINT PK_meal_plan PRIMARY KEY (meal_plan_id)
);

DROP TABLE IF EXISTS meal_ingredient_association;

CREATE TABLE meal_ingredient_association (
    meal_ingredient_id SERIAL,
    idMeal INTEGER,
    idIngredient INTEGER,
    user_id INTEGER,
    CONSTRAINT PK_meal_ingredient PRIMARY KEY (meal_ingredient_id)
);

DROP TABLE IF EXISTS meals;

CREATE TABLE meals(
   idMeal                      INTEGER  NOT NULL PRIMARY KEY
  ,strMeal                     VARCHAR(200) NOT NULL
  ,strDrinkAlternate           VARCHAR(200)
  ,strCategory                 VARCHAR(200)
  ,strArea                     VARCHAR(200)
  ,strInstructions             TEXT
  ,strMealThumb                VARCHAR(200)
  ,strTags                     VARCHAR(200)
  ,strYoutube                  VARCHAR(200)
  ,strIngredient1              VARCHAR(200)
  ,strIngredient2              VARCHAR(200)
  ,strIngredient3              VARCHAR(200)
  ,strIngredient4              VARCHAR(200)
  ,strIngredient5              VARCHAR(200)
  ,strIngredient6              VARCHAR(200)
  ,strIngredient7              VARCHAR(200)
  ,strIngredient8              VARCHAR(200)
  ,strIngredient9              VARCHAR(200)
  ,strIngredient10             VARCHAR(200)
  ,strIngredient11             VARCHAR(200)
  ,strIngredient12             VARCHAR(200)
  ,strIngredient13             VARCHAR(200)
  ,strIngredient14             VARCHAR(200)
  ,strIngredient15             VARCHAR(200)
  ,strIngredient16             VARCHAR(200)
  ,strIngredient17             VARCHAR(200)
  ,strIngredient18             VARCHAR(200)
  ,strIngredient19             VARCHAR(200)
  ,strIngredient20             VARCHAR(200)
  ,strMeasure1                 VARCHAR(200)
  ,strMeasure2                 VARCHAR(200)
  ,strMeasure3                 VARCHAR(200)
  ,strMeasure4                 VARCHAR(200)
  ,strMeasure5                 VARCHAR(200)
  ,strMeasure6                 VARCHAR(200)
  ,strMeasure7                 VARCHAR(200)
  ,strMeasure8                 VARCHAR(200)
  ,strMeasure9                 VARCHAR(200)
  ,strMeasure10                VARCHAR(200)
  ,strMeasure11                VARCHAR(200)
  ,strMeasure12                VARCHAR(200)
  ,strMeasure13                VARCHAR(200)
  ,strMeasure14                VARCHAR(200)
  ,strMeasure15                VARCHAR(200)
  ,strMeasure16                VARCHAR(200)
  ,strMeasure17                VARCHAR(200)
  ,strMeasure18                VARCHAR(200)
  ,strMeasure19                VARCHAR(200)
  ,strMeasure20                VARCHAR(200)
  ,strSource                   VARCHAR(200)
  ,strImageSource              VARCHAR(200)
  ,strCreativeCommonsConfirmed VARCHAR(200)
  ,dateModified                VARCHAR(200)
  CONSTRAINT PK_meal PRIMARY KEY (idMeal)
);

COMMIT TRANSACTION;

