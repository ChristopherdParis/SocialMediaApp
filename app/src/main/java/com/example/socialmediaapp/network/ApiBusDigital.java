package com.example.socialmediaapp.network;

import com.example.socialmediaapp.model.CrearPost;
import com.example.socialmediaapp.model.LoginResponse;
import com.example.socialmediaapp.model.PostResponse;
import com.example.socialmediaapp.model.UserLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiBusDigital {

    @POST("iniciarSession")
    Call<LoginResponse> iniciarSession(@Body UserLogin user);

    @GET("publicaciones")
    Call<PostResponse> getPublicaciones();

    @POST("publicaciones")
    Call<Object> registrarPublicacion(@Body CrearPost post);

    @PUT("publicaciones/{id}")
    Call<Object> editarPost(@Path("id") int id, @Body Object post);

    @DELETE("publicaciones/{id}")
    Call<Object> eliminarPublicacion(@Path("id") int idPost);

}
