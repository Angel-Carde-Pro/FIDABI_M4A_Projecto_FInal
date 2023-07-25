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
    private TextView txtDescripcion;
    private TextView txtCodigo;
    private TextView txtCategoria;
    private TextView txtEstado;
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
        txtDescripcion = findViewById(R.id.txt_descripcion);
        txtCodigo = findViewById(R.id.cod_txt);
        txtCategoria = findViewById(R.id.txt_categoria);
        txtEstado = findViewById(R.id.txt_estadoBien);
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
        txtDescripcion.setText(bien.getBien_descripcion());
        txtCodigo.setText(bien.getBien_codigoG());
        txtCategoria.setText(String.valueOf(bien.getBien_cat_cod()));
        txtEstado.setText(bien.getBien_estado());
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
