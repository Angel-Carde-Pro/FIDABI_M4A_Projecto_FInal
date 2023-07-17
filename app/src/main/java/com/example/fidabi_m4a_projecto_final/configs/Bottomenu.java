package com.example.fidabi_m4a_projecto_final.configs;

import android.animation.Animator;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.fidabi_m4a_projecto_final.Profile_user;
import com.example.fidabi_m4a_projecto_final.R;

public class Bottomenu {

    private static boolean desplegue = false;
    public static void configurationMenu(View view, View categView){
        Button home,scaner,admi, search;
        ImageView categ;

        //Que no muestre las categorias
        categView.setVisibility(View.INVISIBLE);

        //HOME configuracion del boton
        home = view.findViewById(R.id.homebtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("jolallalasldlasldlalsdas");
            }
        });

        //CATEG configuracion del boton con animaciones
        categ = view.findViewById(R.id.categorias);
        categ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("parapendejo");
            if (!desplegue){
                desplegarLayout(categView);
                System.out.println("holabola");
            }else{
                contraerLayout(categView);
                System.out.println("holabola21");

            }
            }
        });

        //SEARCH OR PROFILE configuracion del boton
        search = view.findViewById(R.id.search_bar);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(view.getContext(), Profile_user.class);
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
