package com.example.deliciousrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RecipeActivity extends AppCompatActivity {

    private ImageView image;
    private TextView recipeText;
    private int position;
    private final String LOG_TAG = "RecipeActivity";
    public final String EXTRA_POSITION = "Extra_Position";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        image = findViewById(R.id.recipe_image);
        recipeText = findViewById(R.id.recipe_text);

        Intent intent = getIntent();
        position = intent.getIntExtra(EXTRA_POSITION, -1);
        try {
            image.setImageResource(MainActivity.recipeList.get(position).imageId);
            recipeText.setText(MainActivity.recipeList.get(position).recipeLongText);
        } catch (Exception e) {
            Log.d(LOG_TAG, "Invalid position or no position received from MainActivity");
        }
    }
}
