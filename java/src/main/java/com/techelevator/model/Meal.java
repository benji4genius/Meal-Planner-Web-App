package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private int idmeal;
    private int user_id;
    private String strmeal;
    private String strinstructions;
    private String strtags;
    private List<MealIngredient> ingredientList;
    private String strmealthumb;
    private String stryoutube;

    public Meal() {
    }

    public Meal(int idmeal, int user_id, String strmeal, String strinstructions, String strtags, List<MealIngredient> ingredientList, String strmealthumb, String stryoutube) {
        this.idmeal = idmeal;
        this.user_id = user_id;
        this.strmeal = strmeal;
        this.strinstructions = strinstructions;
        this.strtags = strtags;
        this.ingredientList = ingredientList;
        this.strmealthumb = strmealthumb;
        this.stryoutube = stryoutube;
    }

    public int getIdmeal() {
        return idmeal;
    }

    public void setIdmeal(int idmeal) {
        this.idmeal = idmeal;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStrmeal() {
        return strmeal;
    }

    public void setStrmeal(String strmeal) {
        this.strmeal = strmeal;
    }

    public String getStrinstructions() {
        return strinstructions;
    }

    public void setStrinstructions(String strinstructions) {
        this.strinstructions = strinstructions;
    }

    public String getStrtags() {
        return strtags;
    }

    public void setStrtags(String strtags) {
        this.strtags = strtags;
    }

    public List<MealIngredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<MealIngredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getStrmealthumb() {
        return strmealthumb;
    }

    public void setStrmealthumb(String strmealthumb) {
        this.strmealthumb = strmealthumb;
    }

    public String getStryoutube() {
        return stryoutube;
    }

    public void setStryoutube(String stryoutube) {
        this.stryoutube = stryoutube;
    }
}