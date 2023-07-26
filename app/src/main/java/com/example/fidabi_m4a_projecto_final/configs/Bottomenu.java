package com.example.fidabi_m4a_projecto_final.configs;

import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.activities.Activity_Profile;
import com.example.fidabi_m4a_projecto_final.activities.InventoryActivity;

public class Bottomenu {

    private RelativeLayout contenedorDesplegable;
    private RelativeLayout layoutDesplegable;
    private static boolean desplegue = false;

    public static void configurationMenu(View view, View categView) {
        Button home, categ, admi, profile, plus, scaner;
        categView.setVisibility(View.INVISIBLE);

        home = view.findViewById(R.id.homebtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("jolallalasldlasldlalsdas");
            }
        });
        plus = view.findViewById(R.id.btn_plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("aqui se abre los listados");
                Intent listActivityIntent = new Intent(view.getContext(), InventoryActivity.class);
                view.getContext().startActivity(listActivityIntent);
            }
        });

        scaner = view.findViewById(R.id.categorias_btn);
        scaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!desplegue) {
                    desplegarLayout(categView);
                    System.out.println("holabola");
                } else {
                    contraerLayout(categView);
                    System.out.println("holabola21");

                }
            }
        });

        profile = view.findViewById(R.id.user_settings);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(view.getContext(), Activity_Profile.class);
                view.getContext().startActivity(profile);

            }
        });

    }


    private static void desplegarLayout(View layout) {
        // Obtener la altura del layout
        int height = layout.getHeight();

        // Crea la animación de desplazamiento hacia arriba con valores invertidos
        Animation slideUpAnimation = new TranslateAnimation(0, 0, height, 0);
        slideUpAnimation.setDuration(500); // Duración de la animación en milisegundos

        // Aplica la animación al layout
        layout.startAnimation(slideUpAnimation);

        // Establece la visibilidad del layout como visible al inicio de la animación
        layout.setVisibility(View.VISIBLE);

        desplegue = true;
    }


    private static void contraerLayout(View layout) {
        // Calcula la altura del layout
        int height = layout.getHeight();

        // Crea la animación de desplazamiento hacia abajo
        Animation slideDownAnimation = new TranslateAnimation(0, 0, 0, height);
        slideDownAnimation.setDuration(500); // Duración de la animación en milisegundos

        // Aplica la animación al layout
        layout.startAnimation(slideDownAnimation);

        // Establece la visibilidad del layout como invisible al final de la animación
        layout.setVisibility(View.INVISIBLE);

        desplegue = false;
    }
}