package com.example.fidabi_m4a_projecto_final.activities;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fidabi_m4a_projecto_final.ApiClient;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.adapters.CategoriaAdapter;
import com.example.fidabi_m4a_projecto_final.adapters.PropietarioAdapter;
import com.example.fidabi_m4a_projecto_final.request.Categoria;
import com.example.fidabi_m4a_projecto_final.request.Propietario;
import com.example.fidabi_m4a_projecto_final.service.UserService;

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

        loadCategorias();
    }

    private void loadCategorias() {
        UserService userService = ApiClient.getUserService();
        Call<List<Categoria>> call = userService.categoriaList();

        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                if (response.isSuccessful()) {
                    List<Categoria> categorias = response.body();
                    categoriaAdapter = new CategoriaAdapter(categorias);
                    recyclerViewCate.setAdapter(categoriaAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {


            }
        });
    }
}
