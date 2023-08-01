package com.example.fidabi_m4a_projecto_final.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.BienResponse;

public class DetalleBienActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_bien);

        // Obtén los datos del intent
        Intent intent = getIntent();
        if (intent != null) {
            BienResponse bienResponse = (BienResponse) intent.getSerializableExtra("bien_objeto");

            // Comprobar si el objeto bienResponse no es null
            if (bienResponse != null) {
                // Vincular las vistas del XML con las variables Java
                TextView txtCodigoBien = findViewById(R.id.txt_codigoCat);
                TextView txtDescripcionBien = findViewById(R.id.txt_catNombre);
                TextView txtCategoriaBien = findViewById(R.id.txt_descripcion_cat);
                TextView txtEstadoBien = findViewById(R.id.txt_cat_estado);
                TextView txtModeloBien = findViewById(R.id.txt_bien_modelo);
                TextView txtMarcaBien = findViewById(R.id.txt_marca_bien);
                TextView txtUbicacionBien = findViewById(R.id.txt_ubicacion_bien);
                TextView txtDepartamentoBien = findViewById(R.id.txt_departamento_bien);
                TextView txtCedulaBien = findViewById(R.id.txt_cedula_custodio);
                TextView txtNombreBien = findViewById(R.id.txt_nomcustodio_bien);
                TextView txtDescripcionLugBien = findViewById(R.id.txt_descripcion_lugar);


                // Actualiza los datos en las vistas
                txtCodigoBien.setText("#" + bienResponse.getBienCod());
                txtDescripcionBien.setText(bienResponse.getBienDescripcion());
                txtCategoriaBien.setText(bienResponse.getCategoria().getCatNombre());
                txtEstadoBien.setText(bienResponse.getBienEstado());
                txtModeloBien.setText(bienResponse.getBienModelo());
                txtMarcaBien.setText(bienResponse.getBienMarca());
                txtUbicacionBien.setText(bienResponse.getUbicacion().getUbiNombre());
                txtDepartamentoBien.setText(bienResponse.getBienDescripcion());
                txtCedulaBien.setText(bienResponse.getUsuario().getPersona().getPerCedula());
                txtNombreBien.setText(bienResponse.getUsuario().getPersona().getPerPrimerNom());
                txtDescripcionLugBien.setText(bienResponse.getBienDescripcionLugar());

                Button buttonAceptar = findViewById(R.id.button_aceptar);
                buttonAceptar.setOnClickListener(view -> {
                    // Finalizar esta actividad y regresar a la actividad anterior
                    finish();
                });
            } else {
                // Manejar el caso cuando el objeto bienResponse es null, por ejemplo, mostrar un mensaje de error.
                // Otra opción sería finalizar esta actividad si el objeto bienResponse no está presente.
                // finish();
            }
        }
    }
}