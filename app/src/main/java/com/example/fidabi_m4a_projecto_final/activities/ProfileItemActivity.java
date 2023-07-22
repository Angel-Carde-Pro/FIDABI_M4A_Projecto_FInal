package com.example.fidabi_m4a_projecto_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.fidabi_m4a_projecto_final.GlobalData;
import com.example.fidabi_m4a_projecto_final.R;

public class ProfileItemActivity extends AppCompatActivity {
    RelativeLayout signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_item);
        signup = findViewById(R.id.log_out);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalData data = GlobalData.getInstance();
                Intent close = new Intent(ProfileItemActivity.this, LoginActivity.class);
                close.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(close);
                data.cerrarsesion();
            }
        });
    }
}