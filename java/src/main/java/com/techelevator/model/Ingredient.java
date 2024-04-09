package com.techelevator.model;

public class Ingredient {
    private int idingredient;

    private String stringredient;

    private String strdescription;

    public Ingredient(){};

    public Ingredient(int idingredient, String stringredient, String strdescription) {
        this.idingredient = idingredient;
        this.stringredient = stringredient;
        this.strdescription = strdescription;
    }

    public int getIdingredient() {
        return idingredient;
    }

    public String getStringredient() {
        return stringredient;
    }

    public String getStrdescription() {
        return strdescription;
    }

    public void setIdingredient(int idingredient) {
        this.idingredient = idingredient;
    }

    public void setStringredient(String stringredient) {
        this.stringredient = stringredient;
    }

    public void setStrdescription(String strdescription) {
        this.strdescription = strdescription;
    }
}
