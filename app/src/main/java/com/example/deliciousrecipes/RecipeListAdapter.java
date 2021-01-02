package com.example.deliciousrecipes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private final View.OnClickListener listener;
    private final ArrayList<Recipe> recipeList;

    public RecipeListAdapter(View.OnClickListener listener, ArrayList<Recipe> recipeList) {
        this.listener = listener;
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_food_intro, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.textViewFoodName.setText(recipeList.get(position).foodName);
        holder.textViewFoodIntro.setText(recipeList.get(position).foodIntroText);
        holder.imageView.setImageResource(recipeList.get(position).imageId);
        holder.itemView.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}
