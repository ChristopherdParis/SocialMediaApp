package com.example.socialmediaapp.network;

import com.example.socialmediaapp.model.PostResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiBusDigital {
    @GET("publicaciones")
    Call<PostResponse> getPublicaciones();

}
