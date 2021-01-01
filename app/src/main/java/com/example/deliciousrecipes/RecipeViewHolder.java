package com.example.deliciousrecipes;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class RecipeViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textViewFoodName;
    TextView textViewFoodIntro;

    public RecipeViewHolder(View view) {
        super(view);
        imageView = view.findViewById(R.id.image);
        textViewFoodIntro = view.findViewById(R.id.food_intro_label);
        textViewFoodName = view.findViewById(R.id.food_name_label);
    }
}
