package com.example.socialmediaapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialmediaapp.adapter.PostAdapter;
import com.example.socialmediaapp.model.Post;
import com.example.socialmediaapp.model.PostResponse;
import com.example.socialmediaapp.network.ApiBusDigital;
import com.example.socialmediaapp.network.ApiClient;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Post> posts = new ArrayList<>();
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postAdapter = new PostAdapter(getApplicationContext(), posts);
        recyclerView.setAdapter(postAdapter);

        consultarPublicaciones(postAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void consultarPublicaciones(PostAdapter adapter) {
        Call<PostResponse> call = ApiClient.getClient().create(ApiBusDigital.class).getPublicaciones();
        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Codigo de error: "+ response.code());
                    return;
                }

                System.out.println("publicaciones recibidas");
                try {
                    PostResponse postResponse = response.body();
                    if (postResponse != null) {
                        List<Post> posts = postResponse.getPublicaciones();
                        adapter.updatePosts(posts);
                    } else {
                        System.out.println("Error: Response body is null.");
                        Toast.makeText(MainActivity.this, "Error: Received empty response.", Toast.LENGTH_SHORT).show();
                    }
                } catch (JsonSyntaxException e) {
                    System.out.println("JsonSyntaxException: " + e.getMessage());
                    Toast.makeText(MainActivity.this, "JSON Parsing Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                System.out.println("Network error: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Network error while fetching posts: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}