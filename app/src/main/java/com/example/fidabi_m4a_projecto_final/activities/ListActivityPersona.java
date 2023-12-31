package com.example.fidabi_m4a_projecto_final.activities;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fidabi_m4a_projecto_final.ApiClient;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.adapters.CategoriaAdapter;
import com.example.fidabi_m4a_projecto_final.adapters.PersonaAdapter;
import com.example.fidabi_m4a_projecto_final.request.Categoria;
import com.example.fidabi_m4a_projecto_final.request.Persona;
import com.example.fidabi_m4a_projecto_final.service.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivityPersona extends AppCompatActivity {

    private RecyclerView recyclerViewPer;
    private PersonaAdapter personaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_persona);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusbar_profile));
        }

        recyclerViewPer = findViewById(R.id.listRecyclerView);
        recyclerViewPer.setLayoutManager(new LinearLayoutManager(this));

        loadPersonas();
    }

    private void loadPersonas() {
        UserService userService = ApiClient.getUserService();
        Call<List<Persona>> call = userService.personaList();

        call.enqueue(new Callback<List<Persona>>() {
            @Override
            public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
                if (response.isSuccessful()) {
                    List<Persona> personas = response.body();
                    personaAdapter = new PersonaAdapter(personas);
                    recyclerViewPer.setAdapter(personaAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Persona>> call, Throwable t) {


            }
        });
    }
}
