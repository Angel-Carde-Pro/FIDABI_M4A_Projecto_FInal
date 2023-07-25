package com.example.fidabi_m4a_projecto_final;

import com.example.fidabi_m4a_projecto_final.service.UserService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit getRetrofit() {
        HttpLoggingInterceptor httpLoginInterceptor = new HttpLoggingInterceptor();
        httpLoginInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoginInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())

                //colocar ip personal (ipconfig en cmd)(http://ip:8080/) esto para localhost
                .baseUrl("http://192.168.18.57:8080/")
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public static UserService getUserService() {
        UserService userService = getRetrofit().create(UserService.class);
        return userService;
    }
}