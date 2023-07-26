package com.example.fidabi_m4a_projecto_final.activities;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fidabi_m4a_projecto_final.ApiClient;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.adapters.CategoriaAdapter;
import com.example.fidabi_m4a_projecto_final.adapters.UbicaciónAdapter;
import com.example.fidabi_m4a_projecto_final.request.Categoria;
import com.example.fidabi_m4a_projecto_final.request.Ubicación;
import com.example.fidabi_m4a_projecto_final.service.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivityUbicacion extends AppCompatActivity {

    private RecyclerView recyclerViewUbi;
    private UbicaciónAdapter ubicacionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_ubicacion);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusbar_profile));
        }

        recyclerViewUbi = findViewById(R.id.listRecyclerView);
        recyclerViewUbi.setLayoutManager(new LinearLayoutManager(this));

        loadUbicacion();
    }

    private void loadUbicacion() {
        UserService userService = ApiClient.getUserService();
        Call<List<Ubicación>> call = userService.ubicacionList();

        call.enqueue(new Callback<List<Ubicación>>() {
            @Override
            public void onResponse(Call<List<Ubicación>> call, Response<List<Ubicación>> response) {
                if (response.isSuccessful()) {
                    List<Ubicación> ubicaciones = response.body();
                    ubicacionAdapter = new UbicaciónAdapter(ubicaciones);
                    recyclerViewUbi.setAdapter(ubicacionAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Ubicación>> call, Throwable t) {


            }
        });
    }
}
