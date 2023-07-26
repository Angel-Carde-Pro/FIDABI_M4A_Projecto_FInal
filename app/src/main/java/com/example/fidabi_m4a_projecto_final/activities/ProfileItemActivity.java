package com.example.fidabi_m4a_projecto_final.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.fidabi_m4a_projecto_final.GlobalData;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.fragments.Act_Profile;

import kotlin.jvm.internal.Intrinsics;

public class ProfileItemActivity extends AppCompatActivity {
    RelativeLayout signup, setting, shareApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_act_profile);
        signup = findViewById(R.id.log_out);
        setting = findViewById(R.id.ajustes);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalData data = GlobalData.getInstance();
                Intent close = new Intent(ProfileItemActivity.this, LoginActivity.class);
                close.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(close);
                data.cerrarsesion();
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timer = new Intent(ProfileItemActivity.this, TimerContaActivity.class);
                startActivity(timer);
            }
        });
    }
}