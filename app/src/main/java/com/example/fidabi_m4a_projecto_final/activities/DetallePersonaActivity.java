package com.example.fidabi_m4a_projecto_final.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.BienResponse;
import com.example.fidabi_m4a_projecto_final.request.Persona;
import com.example.fidabi_m4a_projecto_final.request.RecentActResponse;

import java.text.SimpleDateFormat;

public class DetallePersonaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_persona);

        // Obtén los datos del intent
        Intent intent = getIntent();
        if (intent != null) {
            Persona persona = (Persona) intent.getSerializableExtra("persona_objeto");

            // Comprobar si el objeto persona no es null
            if (persona != null) {
                // Vincular las vistas del XML con las variables Java
                TextView txtCodigoBien = findViewById(R.id.txt_codUbi);
                TextView txtDescripcionBien = findViewById(R.id.txt_cedula);
                TextView txtCategoriaBien = findViewById(R.id.txt_departamento_ubi);
                TextView txtEstadoBien = findViewById(R.id.txt_ubi_estado);
                TextView txtModeloBien = findViewById(R.id.txt_bien_modelo);
                TextView txtMarcaBien = findViewById(R.id.txt_marca_bien);
                TextView txtUbicacionBien = findViewById(R.id.txt_ubicacion_bien);
                TextView txtDepartamentoBien = findViewById(R.id.txt_departamento_bien);
                TextView txtCedulaBien = findViewById(R.id.txt_cedula_custodio);
                TextView txtNombreBien = findViewById(R.id.txt_nomcustodio_bien);
                TextView txtDescripcionLugBien = findViewById(R.id.txt_descripcion_lugar);

                // Actualiza los datos en las vistas
                txtCodigoBien.setText("#" + persona.getPerCedula());
                txtDescripcionBien.setText(persona.getPerCedula());
                txtCategoriaBien.setText(persona.getPerPrimerNom());
                txtEstadoBien.setText(persona.getPerSegundoNom());
                txtModeloBien.setText(persona.getPerApellidoPater());
                txtMarcaBien.setText(persona.getPerApellidoMater());
                txtUbicacionBien.setText(persona.getPerTelefono());
                txtDepartamentoBien.setText(persona.getPerGenero());
                txtCedulaBien.setText(persona.getPerEmail());

                // Formatear y establecer la fecha de nacimiento en el TextView
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaNacimiento = sdf.format(persona.getPerFechaNac());
                txtNombreBien.setText(fechaNacimiento);

                Button buttonAceptar = findViewById(R.id.button_aceptar);
                buttonAceptar.setOnClickListener(view -> {
                    // Finalizar esta actividad y regresar a la actividad anterior
                    finish();
                });
            } else {
                // Manejar el caso cuando el objeto persona es null, por ejemplo, mostrar un mensaje de error.
                // Otra opción sería finalizar esta actividad si el objeto persona no está presente.
                // finish();
            }
        }
    }
}