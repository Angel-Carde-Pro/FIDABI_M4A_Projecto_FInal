package com.example.fidabi_m4a_projecto_final.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fidabi_m4a_projecto_final.GlobalData;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.configs.Bottomenu;
import com.example.fidabi_m4a_projecto_final.configs.Categories;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.integration.android.IntentIntegrator;

public class ActivityHome extends AppCompatActivity {
    TextView msjWelcome, role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        msjWelcome = findViewById(R.id.welcome_mss2);
        role = findViewById(R.id.role_id);

        msjWelcome.setText("Hola!, bienvenid@ \n" + getIntent().getStringExtra("primerNombre"));
        role.setText(getIntent().getStringExtra("rol") );


        GlobalData glob = GlobalData.getInstance();
        glob.setRol(getIntent().getStringExtra("rol"));
        glob.setPrimerNombre(getIntent().getStringExtra("primerNombre"));

        //Este layout es del home donde se va a mostrar el menu y lo demas
        RelativeLayout container = findViewById(R.id.bottomcointainer);

        //Estas views son los layout a ocupar para el menu y categorias desplegable
        View menuView = LayoutInflater.from(this).inflate(R.layout.activity_bottom_menu, container, false);
        View categView = LayoutInflater.from(this).inflate(R.layout.activity_categories, container, false);

        // Establecer las reglas de posicionamiento
        RelativeLayout.LayoutParams menuParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        menuParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        menuView.setLayoutParams(menuParams);

        RelativeLayout.LayoutParams categParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        categParams.addRule(RelativeLayout.ABOVE, menuView.getId());
        categView.setLayoutParams(categParams);

        //Se asignara donde se mostrara los layout
        container.addView(categView);
        container.addView(menuView);


        //se llama la configuracion de los botones
        Bottomenu.configurationMenu(menuView,categView);
        Categories.configurationCategory(categView);

    }
    //abrir scanner

    public void onclick(View view) {

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                String scannedData = result.getContents();
                // Aquí puedes manejar los datos escaneados como desees
                Toast.makeText(this, "Código QR escaneado: " + scannedData, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Escaneo cancelado", Toast.LENGTH_SHORT).show();
                //chupalo danny perro
            }
        }
    }
}