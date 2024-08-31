package com.example.socialmediaapp.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialmediaapp.R;

public class PostViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nameView, emailView, comentarioView;
    RelativeLayout cardView;


    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView= itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.name);
        emailView = itemView.findViewById(R.id.email);
        comentarioView = itemView.findViewById(R.id.comentario);
        cardView = itemView.findViewById(R.id.cardView);
    }
}
