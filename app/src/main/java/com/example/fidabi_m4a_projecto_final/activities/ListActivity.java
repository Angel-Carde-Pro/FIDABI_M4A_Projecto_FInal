package com.example.fidabi_m4a_projecto_final.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fidabi_m4a_projecto_final.ApiClient;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.adapters.PropietarioAdapter;
import com.example.fidabi_m4a_projecto_final.request.Propietario;
import com.example.fidabi_m4a_projecto_final.service.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PropietarioAdapter propietarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadPropietarios();
    }

    private void loadPropietarios() {
        UserService userService = ApiClient.getUserService();
        Call<List<Propietario>> call = userService.index();

        call.enqueue(new Callback<List<Propietario>>() {
            @Override
            public void onResponse(Call<List<Propietario>> call, Response<List<Propietario>> response) {
                if (response.isSuccessful()) {
                    List<Propietario> propietarios = response.body();
                    propietarioAdapter = new PropietarioAdapter(propietarios);
                    recyclerView.setAdapter(propietarioAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Propietario>> call, Throwable t) {

                
            }
        });
    }
}
