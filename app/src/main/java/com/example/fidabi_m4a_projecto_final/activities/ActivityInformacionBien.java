package com.example.fidabi_m4a_projecto_final.activities;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.fidabi_m4a_projecto_final.request.UdescripcionLugar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityInformacionBien extends AppCompatActivity {
    private TextView txt_codigoBien;
    private TextView txtDescripcion;
    private TextView txtCodigoBarras;
    private TextView txtCategoria;
    private TextView txtEstado;
    private TextView txt_Modelo;
    private TextView txt_Marca;
    private TextView txt_Ubicacion;
    private TextView txt_Departamento;
    private TextView txt_idCus;
    private TextView txt_nombCus;
    private ApiClient apiClient;
    String scannedData;
    String selectedOption;
    private boolean verificacionCompleta = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_detail);

        scannedData = getIntent().getStringExtra("scanned_data");
        Spinner spinnerDescripcionLugar = findViewById(R.id.spinner_descripcion_lugar);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.descripcion_lugar_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDescripcionLugar.setAdapter(adapter);
        spinnerDescripcionLugar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedOption = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        txtDescripcion = findViewById(R.id.txt_cedula);
        txtCodigoBarras = findViewById(R.id.txtcodBien);
        txtCategoria = findViewById(R.id.txt_departamento_ubi);
        txtEstado = findViewById(R.id.txt_ubi_estado);
        txt_Marca = findViewById(R.id.txt_marca_bien);
        txt_Modelo = findViewById(R.id.txt_bien_modelo);
        txt_idCus = findViewById(R.id.txt_cedula_custodio);
        txt_nombCus = findViewById(R.id.txt_nomcustodio_bien);
        txt_Ubicacion = findViewById(R.id.txt_ubicacion_bien);
        txt_Departamento = findViewById(R.id.txt_departamento_bien);
        txt_codigoBien = findViewById(R.id.txt_codUbi);

        apiClient = new ApiClient();

        if (scannedData != null) {
            apiClient.getUserService().obtenerDatosBienPorCodigoBarras(scannedData).enqueue(new Callback<BienResponse>() {
                @Override
                public void onResponse(Call<BienResponse> call, Response<BienResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        BienResponse bien = response.body();
                        mostrarInformacionBien(bien);
                    } else {
                        mostrarErrorbien();
                    }
                }

                @Override
                public void onFailure(Call<BienResponse> call, Throwable t) {
                    mostrarErrorbien();
                }
            });
        } else {
            mostrarErrorbien();
        }

        Button btnAceptar = findViewById(R.id.button_aceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selectedOption.equals(getString(R.string.select_option))) {
                    if (scannedData != null) {
                        UdescripcionLugar udescripcionLugar = new UdescripcionLugar(scannedData, selectedOption);
                        apiClient.getUserService().actualizarDescripcionLugar(scannedData, udescripcionLugar).enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if (response.isSuccessful()) {
                                    verificacionCompleta = true; // Se completó la verificación del bien
                                    mostrarExitomodbien();
                                } else {
                                    mostrarErrorbien();
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                mostrarErrorbien();
                            }
                        });
                    }
                } else {
                    Toast.makeText(ActivityInformacionBien.this, "Seleccione una opción: ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (!verificacionCompleta) {
            Toast.makeText(this, "Complete la verificación del bien", Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
        }
    }

    private void mostrarInformacionBien(BienResponse bien) {
        txt_codigoBien.setText(String.valueOf(bien.getBienCod()));
        txtDescripcion.setText(bien.getBienDescripcion());
        txtCodigoBarras.setText(bien.getBienCodigoG());
        txtCategoria.setText(bien.getCategoria().getCatNombre());
        txtEstado.setText(bien.getBienEstado());
        txt_Marca.setText(bien.getBienMarca());
        txt_Modelo.setText(bien.getBienModelo());
        txt_idCus.setText(bien.getUsuario().getPersona().getPerCedula());
        txt_nombCus.setText(bien.getUsuario().getPersona().getPerPrimerNom() + (" ") + bien.getUsuario().getPersona().getPerApellidoPater());
        txt_Ubicacion.setText(bien.getUbicacion().getUbiNombre());
        txt_Departamento.setText(bien.getUbicacion().getDepartamento());
    }

    private void mostrarErrorbien() {
        View errorView = getLayoutInflater().inflate(R.layout.dialog_fail, null);
        errorView.setAlpha(0f); // Inicialmente, configurar la transparencia a 0

        TextView tvErrorMessage = errorView.findViewById(R.id.tvErrorMessage);
        tvErrorMessage.setText("El bien no fue encontrado en la base de datos.");
        Button btnAceptar = errorView.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        addContentView(errorView, params);

        // Animación de aparición
        errorView.animate().alpha(1f).setDuration(500).start();
    }

    private void mostrarExitomodbien() {
        View errorView = getLayoutInflater().inflate(R.layout.dialog_exito, null);
        errorView.setAlpha(0f); // Inicialmente, configurar la transparencia a 0

        TextView tvErrorMessage = errorView.findViewById(R.id.MessageExito);
        tvErrorMessage.setText("El bien se actualizó con la descripción del lugar correctamente");
        Button btnAceptar = errorView.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        addContentView(errorView, params);

        // Animación de aparición
        errorView.animate().alpha(1f).setDuration(300).start();
        //ready
    }
}