package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private int idmeal;
    private String strmeal;
    private String strinstructions;
    private String strtags;
    private List<MealIngredient> ingredientList;
    private String strmealthumb;
    private String stryoutube;

    public Meal(){
    }

    public Meal(int idmeal, String strmeal, String strinstructions, String strtags,
                List<MealIngredient> ingredientList, String strmealthumb, String stryoutube) {
        this.idmeal = idmeal;
        this.strmeal = strmeal;
        this.strtags = strtags;
        this.strinstructions = strinstructions;
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
