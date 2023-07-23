package com.example.fidabi_m4a_projecto_final.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

    String selectedOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_detail);

        // Inicializar el Spinner
        Spinner spinnerDescripcionLugar = findViewById(R.id.spinner_descripcion_lugar);

        // Obtener el array de opciones del Spinner desde los recursos
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.descripcion_lugar_options,
                android.R.layout.simple_spinner_item
        );

        // Especificar el diseño para las opciones que se mostrarán en el Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Asignar el adaptador al Spinner
        spinnerDescripcionLugar.setAdapter(adapter);

        // Escuchador para manejar la selección del Spinner
        spinnerDescripcionLugar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtener la opción seleccionada por el usuario (excluyendo la opción "Seleccione una opción")
                selectedOption = (String) parent.getItemAtPosition(position);

                // Si la opción seleccionada no es "Seleccione una opción", realizar acciones según la opción seleccionada

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Manejar la situación si no se selecciona nada (puedes agregar tu lógica aquí)
            }
        });

        // Resto del código en el método onCreate...
        // (incluyendo la inicialización de otras vistas y el resto de las funciones)



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
                if (!selectedOption.equals(getString(R.string.select_option))) {
                    finish();

                }else {
                    Toast.makeText(ActivityInformacionBien.this, "Seleccione una opción: ", Toast.LENGTH_SHORT).show();

                }
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
