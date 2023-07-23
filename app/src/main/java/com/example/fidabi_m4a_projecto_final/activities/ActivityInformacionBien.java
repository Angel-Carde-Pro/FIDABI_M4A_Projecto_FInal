package com.example.fidabi_m4a_projecto_final.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fidabi_m4a_projecto_final.ApiClient;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.BienResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityInformacionBien extends AppCompatActivity {
    private TextView txtDescripcion;
    private TextView txtCodigo;
    private TextView txtCategoria;
    private TextView txtEstado;
    private ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_detail);

        txtDescripcion = findViewById(R.id.txt_descripcion);
        txtCodigo = findViewById(R.id.cod_txt);
        txtCategoria = findViewById(R.id.txt_categoria);
        txtEstado = findViewById(R.id.txt_estadoBien);
        apiClient = new ApiClient();

        String scannedData = getIntent().getStringExtra("scanned_data");

        if (scannedData != null) {
            // Llamar a la API para obtener los datos del bien utilizando el código de barras escaneado
            apiClient.getUserService().obtenerDatosBienPorCodigoBarras(scannedData).enqueue(new Callback<BienResponse>() {
                @Override
                public void onResponse(Call<BienResponse> call, Response<BienResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        BienResponse bien = response.body();
                        // Mostrar los datos del bien en la vista
                        mostrarInformacionBien(bien);
                    } else {
                        mostrarError();
                    }
                }

                @Override
                public void onFailure(Call<BienResponse> call, Throwable t) {
                    mostrarError();
                }
            });
        } else {
            mostrarError();
        }

        Button btnAceptar = findViewById(R.id.button_aceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finalizar el Activity actual y volver al Activity anterior en la pila de actividades
                finish();
            }
        });
    }

    private void mostrarInformacionBien(BienResponse bien) {
        txtDescripcion.setText(bien.getBien_descripcion());
        txtCodigo.setText(bien.getBien_codigoG());
        txtCategoria.setText(String.valueOf(bien.getBien_cat_cod()));
        txtEstado.setText(bien.getBien_estado());
    }

    private void mostrarError() {
        txtDescripcion.setText("El bien no fue encontrado en la base de datos.");
        txtCodigo.setText("");
        txtCategoria.setText("");
        txtEstado.setText("");
    }
}
