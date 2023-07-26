package com.example.fidabi_m4a_projecto_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fidabi_m4a_projecto_final.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button buttoncontinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //cambiar color barra de estado
        getWindow().setStatusBarColor(getResources().getColor(R.color.blancoSplash));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.blancoSplash));

        ImageView imgWave3 = findViewById(R.id.img_wave3);
        ImageView imgWave2 = findViewById(R.id.img_wave2);
        ImageView Yellow_circle = findViewById(R.id.yellow_circle);

        // Cargar la animación
        Animation bubbleAnimation = AnimationUtils.loadAnimation(this, R.anim.bubble_anim);

        // Aplicar la animación
        imgWave3.startAnimation(bubbleAnimation);
        imgWave2.startAnimation(bubbleAnimation);
        Yellow_circle.startAnimation(bubbleAnimation);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 3000);
    }
}
