package com.techelevator.model;
public class MealIngredient extends Ingredient{

    private int idmeal;
    private String measurement;

    public MealIngredient(){};


    public MealIngredient(int idingredient, String stringredient, String strdescription, String strtype, int idmeal, String measurement) {
        super(idingredient, stringredient, strdescription, strtype);
        this.idmeal = idmeal;
        this.measurement = measurement;
    }

    public int getIdmeal() {
        return idmeal;
    }

    public void setIdmeal(int idmeal) {
        this.idmeal = idmeal;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
}
