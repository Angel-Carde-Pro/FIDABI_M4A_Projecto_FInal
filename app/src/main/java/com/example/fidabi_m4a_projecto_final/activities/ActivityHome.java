package com.example.fidabi_m4a_projecto_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fidabi_m4a_projecto_final.GlobalData;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.configs.Bottomenu;
import com.example.fidabi_m4a_projecto_final.configs.Categories;
import com.example.fidabi_m4a_projecto_final.configs.Profile;
import com.example.fidabi_m4a_projecto_final.configs.RecentActiv;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.integration.android.IntentIntegrator;

public class ActivityHome extends AppCompatActivity {
    TextView msjWelcome, role;
    private View scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        msjWelcome = findViewById(R.id.welcome_mss2);
        role = findViewById(R.id.role_id);

        msjWelcome.setText("Hola!, bienvenid@ \n" + getIntent().getStringExtra("primerNombre"));
        role.setText(getIntent().getStringExtra("rol"));

        /* DATOS GLOBALES */
        GlobalData glob = GlobalData.getInstance();
        glob.setRol(getIntent().getStringExtra("rol"));
        glob.setPrimerNombre(getIntent().getStringExtra("primerNombre"));
            glob.setUsuarios(getIntent().getIntExtra("usuariosnick",0));

        // Container donde esta ubicado el menubottom
        RelativeLayout container = findViewById(R.id.bottomcointainer);

        // Estas views son los layouts a ocupar para el menú y categorías desplegables
        View menuView = LayoutInflater.from(this).inflate(R.layout.activity_bottom_menu, container, false);
        View categView = LayoutInflater.from(this).inflate(R.layout.activity_categories, container, false);
        View recentView = LayoutInflater.from(this).inflate(R.layout.recent_activ, container, false);

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

        // Se asignará dónde se mostrarán los layouts
        container.addView(categView);
        container.addView(menuView);
        container.addView(recentView);

        // Se llama la configuración de los botones
        Bottomenu.configurationMenu(menuView, categView);
        Categories.configurationCategory(categView);
        Profile.configurationPerfil(categView);
        RecentActiv.configurationRecentAc(recentView);

       scan = findViewById(R.id.scanner);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar el escaneo del código QR
                IntentIntegrator integrator = new IntentIntegrator(ActivityHome.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                integrator.setPrompt("Escanear código QR");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setOrientationLocked(false);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Obtener el resultado del escaneo del código QR
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                // Crear un intent para abrir la actividad de información del bien
                Intent informacionBienIntent = new Intent(ActivityHome.this, ActivityInformacionBien.class);
                informacionBienIntent.putExtra("qrContent", result.getContents());
                startActivity(informacionBienIntent);
            }
        }
    }
}
