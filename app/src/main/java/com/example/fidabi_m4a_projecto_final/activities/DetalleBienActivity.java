package com.example.fidabi_m4a_projecto_final.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.Bien;

public class DetalleBienActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_detail_bienes);

        // Obtén los datos del intent
        Intent intent = getIntent();
        if (intent != null) {
            Bien bien = (Bien) intent.getSerializableExtra("bien_objeto");

            // Comprobar si el objeto bien no es null
            if (bien != null) {
                // Vincular las vistas del XML con las variables Java
                TextView txtCodigoBien = findViewById(R.id.txtcodBien);
                TextView txtDescripcionBien = findViewById(R.id.txt_descripcion);
                TextView txtModeloBien = findViewById(R.id.txt_modelo_bien);
                TextView txtMarcaBien = findViewById(R.id.txt_marca_bien);
                TextView txtEstadoBien = findViewById(R.id.txt_estado_bien);
                TextView txtDetallesBien = findViewById(R.id.txt_detalle_bien);
                TextView txtSerieBien = findViewById(R.id.txt_serie_bien);
                TextView txtPrecioBien = findViewById(R.id.txt_precio_bien);

                // Actualiza los datos en las vistas
                txtCodigoBien.setText("#" + bien.getBien_cod());
                txtDescripcionBien.setText(bien.getBien_descripcion());
                txtModeloBien.setText(bien.getBien_modelo());
                txtMarcaBien.setText(bien.getBien_marca());
                txtEstadoBien.setText(bien.getBien_estado());
                txtDetallesBien.setText(bien.getBien_detalles());
                txtSerieBien.setText(bien.getBien_serie());
                txtPrecioBien.setText(String.valueOf(bien.getBien_precio()));

                // Puedes seguir actualizando las demás vistas según sea necesario.
            } else {
                // Manejar el caso cuando el objeto bien es null, por ejemplo, mostrar un mensaje de error.
                // Otra opción sería finalizar esta actividad si el objeto bien no está presente.
                // finish();
            }
        }
    }
}