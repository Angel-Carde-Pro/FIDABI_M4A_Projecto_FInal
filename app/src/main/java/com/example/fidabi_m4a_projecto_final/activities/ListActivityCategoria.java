package com.example.fidabi_m4a_projecto_final.activities;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fidabi_m4a_projecto_final.ApiClient;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.adapters.CategoriaAdapter;
import com.example.fidabi_m4a_projecto_final.adapters.PropietarioAdapter;
import com.example.fidabi_m4a_projecto_final.request.CatResponse;
import com.example.fidabi_m4a_projecto_final.request.Categoria;
import com.example.fidabi_m4a_projecto_final.request.Propietario;
import com.example.fidabi_m4a_projecto_final.service.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivityCategoria extends AppCompatActivity {

    private RecyclerView recyclerViewCate;
    private CategoriaAdapter categoriaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_categoria);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusbar_profile));
        }

        recyclerViewCate = findViewById(R.id.listRecyclerView);
        recyclerViewCate.setLayoutManager(new LinearLayoutManager(this));

        // Crear una instancia del adapter con una lista vacía inicial
        // Utilizar el nuevo constructor que acepta una lista de categorías
        categoriaAdapter = new CategoriaAdapter(new ArrayList<>());
        recyclerViewCate.setAdapter(categoriaAdapter);

        loadCategorias();
    }

    private void loadCategorias() {
        UserService userService = ApiClient.getUserService();
        Call<List<CatResponse>> call = userService.catList();

        call.enqueue(new Callback<List<CatResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<CatResponse>> call, @NonNull Response<List<CatResponse>> response) {
                if (response.isSuccessful()) {
                    List<CatResponse> categorias = response.body();
                    if (categorias != null) {
                        categoriaAdapter.setCategorias(categorias); // Actualizar los datos del adapter con la lista de categorías obtenida
                    } else {
                        // Manejo del caso en que no se puedan obtener categorías
                    }
                } else {
                    // Manejo del caso en que la respuesta no sea exitosa
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<CatResponse>> call, @NonNull Throwable t) {
                // Manejo del error en caso de que falle la llamada a la API
            }
        });
    }
}