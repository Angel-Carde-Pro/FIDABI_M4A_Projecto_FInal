package com.example.fidabi_m4a_projecto_final.service;

import com.example.fidabi_m4a_projecto_final.request.Bien;
import com.example.fidabi_m4a_projecto_final.request.BienResponse;
import com.example.fidabi_m4a_projecto_final.request.CatResponse;
import com.example.fidabi_m4a_projecto_final.request.Categoria;
import com.example.fidabi_m4a_projecto_final.request.FechaBienResponse;
import com.example.fidabi_m4a_projecto_final.request.LoginRequest;
import com.example.fidabi_m4a_projecto_final.request.LoginResponse;
import com.example.fidabi_m4a_projecto_final.request.Persona;
import com.example.fidabi_m4a_projecto_final.request.Propietario;
import com.example.fidabi_m4a_projecto_final.request.RecentActRequest;
import com.example.fidabi_m4a_projecto_final.request.RecentActResponse;
import com.example.fidabi_m4a_projecto_final.request.Ubicación;
import com.example.fidabi_m4a_projecto_final.request.UdescripcionLugar;
import com.example.fidabi_m4a_projecto_final.request.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {
    @POST("tecazuay/logina/")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @GET("/tecazuay/categoria")
    Call<List<CatResponse>> catList();

    @POST("/tecazuay/historialactividades/{his_usu_cod}")
    Call<List<RecentActResponse>> recentActList(@Path("his_usu_cod") int his_usu_cod);

    @POST("/tecazuay/actividadrecs/")
    Call<List<RecentActResponse>> recentActList(@Body RecentActRequest recentActRequest);

    @GET("/tecazuay/bien/codigo-barras")
    Call<BienResponse> obtenerDatosBienPorCodigoBarras(@Query("codigoBarras") String codigoBarras);

    @GET("/tecazuay/propietarios")
    Call<List<Propietario>> index();

    @PUT("/tecazuay/bien/actualizar-descripcion-lugar/{bien_codigoG}")
    Call<Void> actualizarDescripcionLugar(@Path("bien_codigoG") String bienCodigoG, @Body UdescripcionLugar udescripcionLugar);

    @PUT("/tecazuay/bien/actualizartodos/{intervalo}")
    Call<Void> updatevalido(@Path("intervalo") int intervalo);

    @GET("/tecazuay/bien/fechasprox")
    Call<List<FechaBienResponse>> fechprox();

    @GET("/tecazuay/categoria/{categoriaCod}")
    Call<CatResponse> obtenerNombreCategoria(@Path("categoriaCod") int categoriaCod);



    @GET("/tecazuay/categoria")
    Call<List<Categoria>> categoriaList();

    @GET("/tecazuay/bien")
    Call<List<Bien>> bienList();

    @GET("/tecazuay/personas")
    Call<List<Persona>> personaList();

    @GET("/tecazuay/usuarios")
    Call<List<Usuario>> usuarioList();

    @GET("/tecazuay/ubicacion")
    Call<List<Ubicación>> ubicacionList();
}
