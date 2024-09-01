package com.example.socialmediaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.socialmediaapp.model.ActualizarPost;
import com.example.socialmediaapp.network.ApiBusDigital;
import com.example.socialmediaapp.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);


        Bundle bundle = getIntent().getExtras();


        String dato = bundle.getString("comentario");
        int idPublicacion = bundle.getInt("idPublicacion");

        tv1 = findViewById(R.id.txtidPost);
        tv1.setText(String.valueOf(idPublicacion));
        tv2 = findViewById(R.id.txtDetalle);
        tv2.setText(dato);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void finalizar(View view) {
        finish();
    }
    
    public void editarPost(View view) {
        int idPost = Integer.parseInt(tv1.getText().toString());
        String comentario = tv2.getText().toString();
        ActualizarPost updatePost = new ActualizarPost(comentario,"");
        Call<Object> call = ApiClient.getClient().create(ApiBusDigital.class).editarPost(idPost,updatePost);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity2.this, "Post Actualizado", Toast.LENGTH_SHORT).show();
                    finish();
                } else {

                    Toast.makeText(MainActivity2.this, "Error al Actualizar Post", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                // Error de red u otro problema
                Toast.makeText(MainActivity2.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    
    public void eliminarPost(View view) {
        int idPost = Integer.parseInt(tv1.getText().toString());
        Call<Object> call = ApiClient.getClient().create(ApiBusDigital.class).eliminarPublicacion(idPost);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity2.this, "Post Eliminado", Toast.LENGTH_SHORT).show();
                    finish();
                } else {

                    Toast.makeText(MainActivity2.this, "Error al Eliminar Post", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                // Error de red u otro problema
                Toast.makeText(MainActivity2.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}