package com.example.fidabi_m4a_projecto_final.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.Ubicación;

public class DetalleUbicacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_ubicacion);

        // Obtén los datos del intent
        Intent intent = getIntent();
        if (intent != null) {
            Ubicación bienResponse = (Ubicación) intent.getSerializableExtra("ubi_objeto");

            // Comprobar si el objeto bienResponse no es null
            if (bienResponse != null) {
                // Vincular las vistas del XML con las variables Java
                TextView txtCodigoBien = findViewById(R.id.txt_codUbi);
                TextView txtCategoriaBien = findViewById(R.id.txt_cedula);
                TextView txtDescripcionBien = findViewById(R.id.txt_departamento_ubi);
                TextView txtubiestado = findViewById(R.id.txt_ubi_estado);



                // Actualiza los datos en las vistas
                txtCodigoBien.setText("#" + bienResponse.getUbi_cod());
                txtCategoriaBien.setText(bienResponse.getUbi_nombre());
                txtDescripcionBien.setText(bienResponse.getUbi_departamento());
                txtubiestado.setText(String.valueOf(bienResponse.getUbi_estado()));


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