package com.example.fidabi_m4a_projecto_final.activities;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fidabi_m4a_projecto_final.ApiClient;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.adapters.CategoriaAdapter;
import com.example.fidabi_m4a_projecto_final.adapters.UsuarioAdapter;
import com.example.fidabi_m4a_projecto_final.request.Categoria;
import com.example.fidabi_m4a_projecto_final.request.Usuario;
import com.example.fidabi_m4a_projecto_final.service.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivityUsuario extends AppCompatActivity {

    private RecyclerView recyclerViewUser;
    private UsuarioAdapter usuarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuario);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusbar_profile));
        }

        recyclerViewUser = findViewById(R.id.listRecyclerView);
        recyclerViewUser.setLayoutManager(new LinearLayoutManager(this));

        loadUsuarios();
    }

    private void loadUsuarios() {
        UserService userService = ApiClient.getUserService();
        Call<List<Usuario>> call = userService.usuarioList();

        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (response.isSuccessful()) {
                    List<Usuario> usuarios = response.body();
                    usuarioAdapter = new UsuarioAdapter(usuarios);
                    recyclerViewUser.setAdapter(usuarioAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {


            }
        });
    }
}
