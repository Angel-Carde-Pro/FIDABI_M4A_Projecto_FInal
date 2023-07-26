package com.example.fidabi_m4a_projecto_final.activities;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fidabi_m4a_projecto_final.ApiClient;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.adapters.BienAdapter;
import com.example.fidabi_m4a_projecto_final.adapters.CategoriaAdapter;
import com.example.fidabi_m4a_projecto_final.request.Bien;
import com.example.fidabi_m4a_projecto_final.request.Categoria;
import com.example.fidabi_m4a_projecto_final.service.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivityBien extends AppCompatActivity {

    private RecyclerView recyclerViewBien;
    private BienAdapter bienAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_bien);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusbar_profile));
        }

        recyclerViewBien = findViewById(R.id.listRecyclerView);
        recyclerViewBien.setLayoutManager(new LinearLayoutManager(this));

        loadBienes();
    }

    private void loadBienes() {
        UserService userService = ApiClient.getUserService();
        Call<List<Bien>> call = userService.bienList();

        call.enqueue(new Callback<List<Bien>>() {
            @Override
            public void onResponse(Call<List<Bien>> call, Response<List<Bien>> response) {
                if (response.isSuccessful()) {
                    List<Bien> bienes = response.body();
                    bienAdapter = new BienAdapter(bienes);
                    recyclerViewBien.setAdapter(bienAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Bien>> call, Throwable t) {


            }
        });
    }
}
