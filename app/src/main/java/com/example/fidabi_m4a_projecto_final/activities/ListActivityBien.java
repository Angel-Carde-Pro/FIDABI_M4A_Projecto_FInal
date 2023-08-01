package com.example.fidabi_m4a_projecto_final.activities;

import android.os.Build;
import android.os.Bundle;
import android.widget.SearchView;

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

import java.util.ArrayList;
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

        // Obtener referencia al SearchView
        SearchView searchView = findViewById(R.id.searchView);

        // Crear una instancia del adapter con una lista vacía inicial
        // Utilizar el nuevo constructor que acepta una lista de bienes
        bienAdapter = new BienAdapter(new ArrayList<>());
        recyclerViewBien.setAdapter(bienAdapter);

        // Agregar el OnQueryTextListener al SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Llamar al método de filtrado con el texto ingresado
                bienAdapter.filterByCedula(newText);
                return false;
            }
        });

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
                    bienAdapter.setBienes(bienes); // Actualizar los datos del adapter con la lista de bienes obtenida
                }
            }

            @Override
            public void onFailure(Call<List<Bien>> call, Throwable t) {
                // Manejo del error en caso de que falle la llamada a la API
            }
        });
    }
}