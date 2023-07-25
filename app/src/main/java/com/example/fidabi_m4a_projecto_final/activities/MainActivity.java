package com.example.fidabi_m4a_projecto_final.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.fragments.Act_Profile;
import com.example.fidabi_m4a_projecto_final.fragments.act_Inventory;
import com.example.fidabi_m4a_projecto_final.fragments.act_home;

public class MainActivity extends AppCompatActivity {

    private int selectedTab = 0;
    private int backButtonCount = 0;

    // Aquí están las referencias a los elementos de la UI que se necesita para cada pestaña
    private class Tab {
        public Button actionBtn;
        public int statusBarColor;
        public Class<? extends Fragment> fragmentClass;
        public int selectedIcon;
        public int unselectedIcon;
    }

    // Aquí es donde se define las pestañas
    private Tab[] tabs = new Tab[]{
            new Tab(), // Esta es una pestaña vacía para llenar el índice 0
            new Tab(), // home
            new Tab(), // Codigos QR
            new Tab(), // Categorias
            new Tab(),  // Administración
            new Tab()  // Perfil
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // *CONFIGURACIÓN DE LOS BOTONES DE LA BARRA DE OPCIONES*
        setUpTab(tabs[1], findViewById(R.id.homebtn), act_home.class, ContextCompat.getColor(this, R.color.blueista), R.drawable.icon_home, R.drawable.icon_home);
        setUpTab(tabs[2], findViewById(R.id.btn_plus), act_Inventory.class, ContextCompat.getColor(this, R.color.blueista), R.drawable.icon_home, R.drawable.icon_home);
        setUpTab(tabs[3], findViewById(R.id.categorias_btn), act_home.class, ContextCompat.getColor(this, R.color.blueista), R.drawable.icon_home, R.drawable.icon_home);
        setUpTab(tabs[4], findViewById(R.id.admin), act_home.class, ContextCompat.getColor(this, R.color.blueista), R.drawable.icon_home, R.drawable.icon_home);
        setUpTab(tabs[5], findViewById(R.id.user_settings), Act_Profile.class, ContextCompat.getColor(this, R.color.statusbar_profile), R.drawable.user_icon, R.drawable.user_icon);

        ChangeColorStatusBar(tabs[1].statusBarColor);

        // Selecciona la pestaña de Home por defecto
        selectTab(1);
    }

    @Override
    public void onBackPressed() {
        if (backButtonCount >= 1) {
            finishAffinity(); // Cerrar aplicación
        } else {
            Toast.makeText(this, "Presiona de nuevo para salir", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }

    // ----------------------------- TABS SETTINGS -----------------------------
    private void setUpTab(Tab tab, Button actionBtnID, Class<? extends Fragment> fragmentClass, int statusBarColor, int selectedIcon, int unselectedIcon) {
        tab.actionBtn = actionBtnID;
        tab.statusBarColor = statusBarColor;
        tab.fragmentClass = fragmentClass;
        tab.selectedIcon = selectedIcon;
        tab.unselectedIcon = unselectedIcon;

        tab.actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(tab);
            }
        });
    }

    private void selectTab(int tabIndex) {
        if (tabIndex != selectedTab) {
            selectTab(tabs[tabIndex]);
        }
    }

    private void selectTab(Tab tab) {
        // Anula la selección de la pestaña anteriormente seleccionada
        Tab oldTab = tabs[selectedTab];
        // TODO: CAMBIAR EL ICONO DE SELECCIONADO AL NORMAL
//        oldTab.text.setVisibility(View.GONE);
//        oldTab.image.setImageResource(unselectedIcon);
//        oldTab.layout.setBackgroundColor
//                (getResources().getColor(android.R.color.transparent));

        ChangeColorStatusBar(tab.statusBarColor);

        // TODO: COLOCAR EL ICONO DE SELECCIONADO
//        tab.iconImgBtn.setImageResource(R.drawable.home_selected_icon);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container, tab.fragmentClass, null)
                .commit();

        // Actualiza la pestaña seleccionada
        for (int i = 1; i < tabs.length; i++) {
            if (tabs[i] == tab) {
                selectedTab = i;
                break;
            }
        }
    }

    private void ChangeColorStatusBar(int finalColor) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(finalColor);
    }
}
