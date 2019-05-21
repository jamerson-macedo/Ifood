package com.jmdevelopers.ifood.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmdevelopers.ifood.ItemClickListener;
import com.jmdevelopers.ifood.R;

public class FoodViewHolder extends RecyclerView.ViewHolder implements ItemClickListener, View.OnClickListener {
    public TextView nome_food;
    public ImageView foto_food;
    private ItemClickListener listener;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);
        nome_food=itemView.findViewById(R.id.food_nome);
        foto_food=itemView.findViewById(R.id.food_imagem);
        itemView.setOnClickListener(this);


    }
    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }


    @Override
    public void onClick(View v) {
        listener.onclick(v,getAdapterPosition(),false);

    }

    @Override
    public void onclick(View v, int position, Boolean islong) {

    }
}
