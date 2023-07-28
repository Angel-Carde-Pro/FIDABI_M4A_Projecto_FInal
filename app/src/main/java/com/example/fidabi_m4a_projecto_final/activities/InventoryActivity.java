package com.example.fidabi_m4a_projecto_final.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.fidabi_m4a_projecto_final.R;

public class InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);

        CardView bienes_card_v = findViewById(R.id.bienes_card_v);
        CardView categ_card_v = findViewById(R.id.categ_card_v);
        CardView historial_card_v = findViewById(R.id.historial_card_v);
        CardView persona_card_v = findViewById(R.id.persona_card_v);
        CardView prop_card_v = findViewById(R.id.prop_card_v);
        CardView ubicaciones_card_v = findViewById(R.id.ubicaciones_card_v);
        CardView usu_card_v = findViewById(R.id.usu_card_v);

        if (getIntent().getStringExtra("rol").contains("Custodio")) {
            categ_card_v.setVisibility(View.GONE);
            historial_card_v.setVisibility(View.GONE);
            persona_card_v.setVisibility(View.GONE);
            prop_card_v.setVisibility(View.GONE);
            ubicaciones_card_v.setVisibility(View.GONE);
            usu_card_v.setVisibility(View.GONE);
        }

        toolbar.setTitle("Listados");

        setSupportActionBar(toolbar);
    }

    public void onOptionClicked(View view) {
        // Obtenemos la animación desde el archivo XML
        Animation clickAnimation = AnimationUtils.loadAnimation(this, R.anim.card_click_animation);
        view.startAnimation(clickAnimation);

        String tag = (String) view.getTag();
        String optionName;
        switch (tag) {
            case "bienes":
                optionName = "Bienes";
                Intent profile = new Intent(InventoryActivity.this, ListActivityBien.class);
                startActivity(profile);
                break;
            case "categoria":
                optionName = "Categoría";
                Intent profile1 = new Intent(InventoryActivity.this, ListActivityCategoria.class);
                startActivity(profile1);
                break;
            case "historial":
                optionName = "Historial";
                break;
            case "persona":
                optionName = "Persona";
                Intent profile2 = new Intent(InventoryActivity.this, ListActivityPersona.class);
                startActivity(profile2);
                break;
            case "propietario":
                optionName = "Propietario";
                Intent profile3 = new Intent(InventoryActivity.this, ListActivity.class);
                startActivity(profile3);
                break;
            case "roles":
                optionName = "Roles";
                break;
            case "ubicaciones":
                optionName = "Ubicaciones";
                Intent profile6 = new Intent(InventoryActivity.this, ListActivityUbicacion.class);
                startActivity(profile6);
                break;
            case "usuarios":
                optionName = "Usuarios";
                Intent profile5 = new Intent(InventoryActivity.this, ListActivityUsuario.class);
                startActivity(profile5);
                break;
            default:
                optionName = "";
                break;
        }

        Toast.makeText(this, "Opción seleccionada: " + optionName, Toast.LENGTH_SHORT).show();
    }
}
