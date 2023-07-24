package com.example.fidabi_m4a_projecto_final.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
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

    Button settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.statusbar_1));
        }

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
        glob.setUsuarios(getIntent().getLongExtra("usuariosnick",0));

        // Container donde esta ubicado el menubottom
        RelativeLayout container = findViewById(R.id.bottomcointainer);
        LinearLayout container2= findViewById(R.id.contanerliner);

        // Estas views son los layouts a ocupar para el menú y categorías desplegables
        View menuView = LayoutInflater.from(this).inflate(R.layout.activity_bottom_menu, container, false);
        View categView = LayoutInflater.from(this).inflate(R.layout.activity_categories, container, false);
        View recentView = LayoutInflater.from(this).inflate(R.layout.recent_item, container, false);

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
        container2.addView(recentView);

        // Se llama la configuración de los botones
        Bottomenu.configurationMenu(menuView, categView);
        Categories.configurationCategory(categView);
        Profile.configurationPerfil(categView);
        RecentActiv.configurationRecentAc(recentView);



        /*CONFIGURACION DE BOTONES*/
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

        //SETTINGS
        settings = findViewById(R.id.user_settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setts = new Intent(ActivityHome.this, ProfileItemActivity.class);
                startActivity(setts);

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
