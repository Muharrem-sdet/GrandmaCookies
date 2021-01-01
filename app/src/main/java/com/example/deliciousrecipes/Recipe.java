package com.example.deliciousrecipes;


public class Recipe {

    public String foodName;
    public String foodIntroText;
    public String recipeLongText;
    public int imageId;

    public Recipe(String foodName, String recipeIntroText, String recipeLongText, int imageId) {
        this.foodName = foodName;
        this.foodIntroText = recipeIntroText;
        this.recipeLongText = recipeLongText;
        this.imageId = imageId;
    }
}
