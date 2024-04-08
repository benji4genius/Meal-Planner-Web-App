package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private int mealId;

    private String mealName;

    private String instructions;

    private List<Ingredient> ingredientList;

    //TO DO: Ingredient Measurements, Ingredient Tags//

    private String image;

    private String tutorialVideo;

    public Meal(){};

    public Meal(int mealId, String mealName, String instructions, List<Ingredient> ingredientList, String image, String tutorialVideo) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.instructions = instructions;
        this.ingredientList = ingredientList;
        this.image = image;
        this.tutorialVideo = tutorialVideo;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTutorialVideo() {
        return tutorialVideo;
    }

    public void setTutorialVideo(String tutorialVideo) {
        this.tutorialVideo = tutorialVideo;
    }
}
