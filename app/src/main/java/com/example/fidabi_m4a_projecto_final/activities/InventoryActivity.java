package com.example.fidabi_m4a_projecto_final.activities;

import androidx.appcompat.app.AppCompatActivity;
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
                break;
            case "categoria":
                optionName = "Categoría";
                break;
            case "historial":
                optionName = "Historial";
                break;
            case "persona":
                optionName = "Persona";
                break;
            case "propietario":
                optionName = "Propietario";
                break;
            case "roles":
                optionName = "Roles";
                break;
            case "ubicaciones":
                optionName = "Ubicaciones";
                break;
            case "usuarios":
                optionName = "Usuarios";
                break;
            default:
                optionName = "";
                break;
        }

        Toast.makeText(this, "Opción seleccionada: " + optionName, Toast.LENGTH_SHORT).show();
    }
}
