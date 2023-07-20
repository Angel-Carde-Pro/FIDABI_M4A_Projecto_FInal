package com.example.fidabi_m4a_projecto_final.activities;

import android.widget.TextView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fidabi_m4a_projecto_final.R;

//holaaaa
public class ActivityInformacionBien extends AppCompatActivity {
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_bien);

        resultado = findViewById(R.id.resultado);

        String scannedData = getIntent().getStringExtra("scanned_data");

        resultado.setText("Código QR escaneado: " + scannedData);
    }
}
