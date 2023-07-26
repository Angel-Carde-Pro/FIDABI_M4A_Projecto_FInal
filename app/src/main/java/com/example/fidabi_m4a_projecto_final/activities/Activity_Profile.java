package com.example.fidabi_m4a_projecto_final.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fidabi_m4a_projecto_final.GlobalData;
import com.example.fidabi_m4a_projecto_final.R;

public class Activity_Profile extends AppCompatActivity {
    RelativeLayout signup, setting, shareApp, visit_play_store, profile_settings, notifications;
    TextView msjWelcome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusbar_profile));
        }

        setContentView(R.layout.activity_profile);
        signup = findViewById(R.id.log_out);
        setting = findViewById(R.id.ajustes);
        shareApp = findViewById(R.id.share_app);
        visit_play_store = findViewById(R.id.play_store);
        profile_settings = findViewById(R.id.data_user);
        notifications = findViewById(R.id.notifications_sett);
        msjWelcome = findViewById(R.id.welc_user_txt);
        msjWelcome.setText("¡ Bienvenido ! \n" + getIntent().getStringExtra("primerNombre"));

        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(Activity_Profile.this, Activity_Noti_Settigs.class);
                startActivity(profile);
            }
        });
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

        shareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llama al método shareApp() cuando se haga clic en tu LinearLayout
                shareApp();
            }
        });

        visit_play_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llama al método shareApp() cuando se haga clic en tu LinearLayout
                openAppInPlayStore();
            }
        });


        profile_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timer = new Intent(Activity_Profile.this, Activity_Profile_Settings.class);
                startActivity(timer);
            }
        });
    }

    public final void shareApp() {
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.base_link_apk));
        sb.append(getPackageName());
        String sb2 = sb.toString();
        String string = getString(R.string.app_name);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.app_name));
        StringBuilder sb3 = new StringBuilder();
        sb3.append(string);
        sb3.append(": ");
        sb3.append(sb2);
        intent.putExtra("android.intent.extra.TEXT", sb3.toString());
        startActivity(Intent.createChooser(intent, getString(R.string.share_via)));
    }


    public void openAppInPlayStore() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }
}