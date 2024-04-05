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

CREATE TABLE meals (
   idMeal                      INTEGER  NOT NULL
  ,strMeal                     VARCHAR(50) NOT NULL
  ,strDrinkAlternate           VARCHAR(50)
  ,strCategory                 VARCHAR(50) NOT NULL
  ,strArea                     VARCHAR(20) NOT NULL
  ,strInstructions             TEXT NOT NULL
  ,strMealThumb                VARCHAR(100) NOT NULL
  ,strTags                     VARCHAR(20)
  ,strYoutube                  VARCHAR(50) NOT NULL
  ,strIngredient1              VARCHAR(20) NOT NULL
  ,strIngredient2              VARCHAR(20) NOT NULL
  ,strIngredient3              VARCHAR(20) NOT NULL
  ,strIngredient4              VARCHAR(20) NOT NULL
  ,strIngredient5              VARCHAR(20) NOT NULL
  ,strIngredient6              VARCHAR(50) NOT NULL
  ,strIngredient7              VARCHAR(20) NOT NULL
  ,strIngredient8              VARCHAR(20) NOT NULL
  ,strIngredient9              VARCHAR(20) NOT NULL
  ,strIngredient10             VARCHAR(20)
  ,strIngredient11             VARCHAR(20)
  ,strIngredient12             VARCHAR(5)
  ,strIngredient13             VARCHAR(5)
  ,strIngredient14             VARCHAR(30)
  ,strIngredient15             VARCHAR(30)
  ,strIngredient16             VARCHAR(30)
  ,strIngredient17             VARCHAR(30)
  ,strIngredient18             VARCHAR(30)
  ,strIngredient19             VARCHAR(30)
  ,strIngredient20             VARCHAR(30)
  ,strMeasure1                 VARCHAR(20) NOT NULL
  ,strMeasure2                 VARCHAR(20) NOT NULL
  ,strMeasure3                 VARCHAR(20) NOT NULL
  ,strMeasure4                 VARCHAR(20) NOT NULL
  ,strMeasure5                 VARCHAR(20) NOT NULL
  ,strMeasure6                 VARCHAR(20) NOT NULL
  ,strMeasure7                 VARCHAR(20) NOT NULL
  ,strMeasure8                 VARCHAR(20) NOT NULL
  ,strMeasure9                 VARCHAR(20) NOT NULL
  ,strMeasure10                VARCHAR(20)
  ,strMeasure11                VARCHAR(20)
  ,strMeasure12                VARCHAR(20)
  ,strMeasure13                VARCHAR(20)
  ,strMeasure14                VARCHAR(20)
  ,strMeasure15                VARCHAR(20)
  ,strMeasure16                VARCHAR(20)
  ,strMeasure17                VARCHAR(20)
  ,strMeasure18                VARCHAR(20)
  ,strMeasure19                VARCHAR(20)
  ,strMeasure20                VARCHAR(20)
  ,strSource                   VARCHAR(80)
  ,strImageSource              VARCHAR(30)
  ,strCreativeCommonsConfirmed VARCHAR(30)
  ,dateModified                VARCHAR(30),
  CONSTRAINT PK_meal PRIMARY KEY (idMeal)
);

COMMIT TRANSACTION;

