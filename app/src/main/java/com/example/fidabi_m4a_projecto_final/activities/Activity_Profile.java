package com.example.fidabi_m4a_projecto_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.fidabi_m4a_projecto_final.GlobalData;
import com.example.fidabi_m4a_projecto_final.R;

public class Activity_Profile extends AppCompatActivity {
    RelativeLayout signup, setting, shareApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        signup = findViewById(R.id.log_out);
        setting = findViewById(R.id.ajustes);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalData data = GlobalData.getInstance();
                Intent close = new Intent(Activity_Profile.this, LoginActivity.class);
                close.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(close);
                data.cerrarsesion();
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timer = new Intent(Activity_Profile.this, TimerContaActivity.class);
                startActivity(timer);
            }
        });
    }
}