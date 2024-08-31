package com.example.socialmediaapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialmediaapp.MainActivity2;
import com.example.socialmediaapp.R;
import com.example.socialmediaapp.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    Context context;
    List<Post> posts;

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    public void updatePosts(List<Post> newPosts) {
        this.posts.clear();
        this.posts.addAll(newPosts);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(context).inflate(R.layout.post_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.nameView.setText(posts.get(position).getNombre());
        holder.emailView.setText(posts.get(position).getEmail());
        holder.comentarioView.setText(posts.get(position).getComentario());

        //new
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Elemento Seleccionado: "+posts.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                //test
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("comentario", posts.get(position).getComentario().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
