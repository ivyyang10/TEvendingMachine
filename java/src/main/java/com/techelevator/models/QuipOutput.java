package com.techelevator.models;

public class QuipOutput {
    private String drinkQup = "Drinky, Drinky, Slurp Slurp!";
    private String gumQuip = "Chewy, Chewy, Lots O Bubbles!";
    private String candyQuip = "Sugar, Sugar, so Sweet!";
    private String munchyQuip = "Munchy, Munchy, so Good!" ;

    public String getDrinkQuip() {
        return drinkQup;
    }

    public String getGumQuip() {
        return gumQuip;
    }

    public String getCandyQuip() {
        return candyQuip;
    }

    public String getMunchyQuip() {
        return munchyQuip;
    }

    public String getQuip(String itemType){
        if (itemType.equalsIgnoreCase("Drink")){
            return getDrinkQuip();
        } else if (itemType.equalsIgnoreCase("Munchy")){
            return getMunchyQuip();
        } else if (itemType.equalsIgnoreCase("Gum")){
            return getGumQuip();
        }else {
            return getCandyQuip();
        }
    }
}
