package com.jmdevelopers.ifood;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.jmdevelopers.ifood.model.Categoria;
import com.jmdevelopers.ifood.model.Food;
import com.jmdevelopers.ifood.viewholder.FoodViewHolder;
import com.jmdevelopers.ifood.viewholder.MenuViewHolder;
import com.squareup.picasso.Picasso;

public class FoodActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference category;
    FirebaseRecyclerAdapter adapter;
    String categoriaid = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        database = FirebaseDatabase.getInstance();
        category = database.getReference("foods");
        recyclerView = findViewById(R.id.recyclerview_food);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        if (getIntent() != null) {
            categoriaid = getIntent().getStringExtra("categoria");
            if (!categoriaid.isEmpty() && categoriaid != null) {
                // carregar a lista
                loadlistfood(categoriaid);


            }

        }

    }

    private void loadlistfood(String categoriaid) {
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("foods")
                .orderByChild("menuid").equalTo(categoriaid);


        FirebaseRecyclerOptions<Food> options = new FirebaseRecyclerOptions.Builder<Food>()
                .setQuery(query, Food.class).setLifecycleOwner(this)
                .build();

        adapter = new FirebaseRecyclerAdapter<Food, FoodViewHolder>(options) {


            @NonNull
            @Override
            public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.food_item, viewGroup, false);

                return new FoodViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull FoodViewHolder holder, int position, @NonNull Food model) {
                holder.nome_food.setText(model.getNome());

                Picasso.get().load(model.getImagem()).into(holder.foto_food);
                final Food food=model;
                holder.setListener(new ItemClickListener() {
                    @Override
                    public void onclick(View v, int position, Boolean islong) {
                        Toast.makeText(FoodActivity.this,""+food.getNome(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        recyclerView.setAdapter(adapter);

    }

}
