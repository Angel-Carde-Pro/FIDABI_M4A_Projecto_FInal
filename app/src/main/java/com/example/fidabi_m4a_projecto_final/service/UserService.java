package com.example.fidabi_m4a_projecto_final.service;

import com.example.fidabi_m4a_projecto_final.request.CatResponse;
import com.example.fidabi_m4a_projecto_final.request.LoginRequest;
import com.example.fidabi_m4a_projecto_final.request.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {
    @POST("tecazuay/logina/")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);


    @GET("/tecazuay/categoria")
    Call<List<CatResponse>> catList();
}
