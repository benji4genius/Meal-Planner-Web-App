package com.techelevator.model;

public class Ingredient {
    private int idingredient;
    private String stringredient;
    private String strdescription;
    private String strtype;
    public Ingredient(){}

    public Ingredient(int idingredient, String stringredient, String strdescription, String strtype) {
        this.idingredient = idingredient;
        this.stringredient = stringredient;
        this.strdescription = strdescription;
        this.strtype = strtype;
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

    public String getStrtype() {
        return strtype;
    }

    public void setStrtype(String strtype) {
        this.strtype = strtype;
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
