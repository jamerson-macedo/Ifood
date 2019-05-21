package com.jmdevelopers.ifood.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmdevelopers.ifood.ItemClickListener;
import com.jmdevelopers.ifood.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements ItemClickListener, View.OnClickListener {
  public  TextView nome_menu;
    public ImageView foto_menu;
    private ItemClickListener listener;

    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);
        nome_menu=itemView.findViewById(R.id.menu_nome);
        foto_menu=itemView.findViewById(R.id.menu_imagem);
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
