package com.example.deliciousrecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final ArrayList<Recipe> recipeList = new ArrayList<>();
    private RecyclerView recyclerView;
    public final String EXTRA_POSITION = "Extra_Position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        populateRecipeList();

        View.OnClickListener listener = view -> onClickViewHolderAction(view);

        RecipeListAdapter adapter = new RecipeListAdapter(listener, recipeList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void onClickViewHolderAction(View view) {
        Intent intent = new Intent(getApplicationContext(), RecipeActivity.class);
        intent.putExtra(EXTRA_POSITION, recyclerView.getChildAdapterPosition(view));
        startActivity(intent);
    }

    public void populateRecipeList() {
        String[] foodNames = getResources().getStringArray(R.array.food_names);
        String[] foodIntros = getResources().getStringArray(R.array.food_intros);
        String recipeLongText = getResources().getString(R.string.whole_recipe_sample);
        String[] imageTitles = getResources().getStringArray(R.array.food_images);

        for (int i = 0; i < foodNames.length; i++) {
            int imageId = getResources().getIdentifier(imageTitles[i], "drawable", getPackageName());
            recipeList.add(new Recipe(foodNames[i], foodIntros[i], recipeLongText, imageId));
        }
    }
}