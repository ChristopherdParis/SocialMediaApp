package com.example.socialmediaapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit;

    public static Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://postapi.busdigital.pe/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
