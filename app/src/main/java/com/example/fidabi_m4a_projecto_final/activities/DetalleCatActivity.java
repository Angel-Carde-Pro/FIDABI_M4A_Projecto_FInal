package com.example.fidabi_m4a_projecto_final.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.CatResponse;

public class DetalleCatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_categoria);

        // Obtén los datos del intent
        Intent intent = getIntent();
        if (intent != null) {
            CatResponse catResponse = (CatResponse) intent.getSerializableExtra("cat_objeto");

            // Comprobar si el objeto catResponse no es null
            if (catResponse != null) {
                // Vincular las vistas del XML con las variables Java
                TextView txtcodigoCat = findViewById(R.id.txt_codUbi);
                TextView txtNombreCat = findViewById(R.id.txt_cedula);
                TextView txtDescripcionCat = findViewById(R.id.txt_departamento_ubi);
                TextView txtcatestado = findViewById(R.id.txt_ubi_estado);

                // Actualizar los datos en las vistas
                txtcodigoCat.setText(String.valueOf(catResponse.getCat_cod()));
                txtNombreCat.setText(catResponse.getCat_nombre());
                txtDescripcionCat.setText(catResponse.getCat_descripcion());
                txtcatestado.setText(String.valueOf(catResponse.getCat_estado()));

                // Puedes seguir actualizando las demás vistas según sea necesario.

                // Botón "Aceptar"
                Button buttonAceptar = findViewById(R.id.button_aceptar);
                buttonAceptar.setOnClickListener(view -> {
                    // Finalizar esta actividad y regresar a la actividad anterior
                    finish();
                });
            } else {
                // Manejar el caso cuando el objeto catResponse es null, por ejemplo, mostrar un mensaje de error.
                // Otra opción sería finalizar esta actividad si el objeto catResponse no está presente.
                // finish();
            }
        }
    }
}