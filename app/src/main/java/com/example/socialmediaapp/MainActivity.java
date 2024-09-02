package com.example.socialmediaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialmediaapp.adapter.PostAdapter;
import com.example.socialmediaapp.model.CrearPost;
import com.example.socialmediaapp.model.LoginResponse;
import com.example.socialmediaapp.model.Post;
import com.example.socialmediaapp.model.PostResponse;
import com.example.socialmediaapp.model.UserLogin;
import com.example.socialmediaapp.network.ApiBusDigital;
import com.example.socialmediaapp.network.ApiClient;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.email);
        pass = findViewById(R.id.password);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void ingresar(View view){

        String usuario = user.getText().toString();
        String password = pass.getText().toString();

        UserLogin user = new UserLogin(usuario, password);
        Toast.makeText(MainActivity.this, "usuario: "+ user.getUsuario() + " contra: "+user.getPassword(), Toast.LENGTH_SHORT).show();
        Call<LoginResponse> call = ApiClient.getClient().create(ApiBusDigital.class).iniciarSession(user);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    try {
                        LoginResponse loginResponse = response.body();
                        if (loginResponse != null) {
                            boolean login = loginResponse.isStatus();
                            if (login) {
                                int usuario_id = loginResponse.getUsuario_id();
                                Toast.makeText(MainActivity.this, "Session Iniciada", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                                intent.putExtra("idUsuario", usuario_id);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            System.out.println("Error: Response body is null.");
                            Toast.makeText(MainActivity.this, "Error: Received empty response.", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JsonSyntaxException e) {
                        System.out.println("JsonSyntaxException: " + e.getMessage());
                        Toast.makeText(MainActivity.this, "JSON Parsing Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                } else {

                    Toast.makeText(MainActivity.this, "Error en las Credenciales", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}