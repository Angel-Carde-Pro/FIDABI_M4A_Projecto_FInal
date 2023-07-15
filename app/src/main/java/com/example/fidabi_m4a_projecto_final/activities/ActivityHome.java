package com.example.fidabi_m4a_projecto_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fidabi_m4a_projecto_final.R;

public class ActivityHome extends AppCompatActivity {
    TextView msjWelcome, role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        msjWelcome = findViewById(R.id.welcome_mss2);
        role = findViewById(R.id.role_id);

        msjWelcome.setText("Hola!, bienvenid@ \n" + getIntent().getStringExtra("primerNombre"));
        role.setText(getIntent().getStringExtra("rol").toUpperCase());


    }
}