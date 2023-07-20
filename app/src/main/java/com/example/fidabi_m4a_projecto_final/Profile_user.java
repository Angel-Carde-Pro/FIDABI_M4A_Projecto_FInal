package com.example.fidabi_m4a_projecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fidabi_m4a_projecto_final.activities.LoginActivity;

public class Profile_user extends AppCompatActivity {

//    Note: Ahora el panel de perfil de usuario se muestra en el panel que asciende con una animación
//    Por ende hay que cambiar el codigo : )

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        TextView msjBienvenida, role;
//        RelativeLayout sessionclose;
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile_user);
//        msjBienvenida = findViewById(R.id.tv_kg_weightfragment);
//        role = findViewById(R.id.tv_reminder_weight);
//
//        GlobalData glob = GlobalData.getInstance();
//        msjBienvenida.setText("Hola! \n" + glob.getPrimerNombre());
//        role.setText(glob.getRol());
//
//        sessionclose = findViewById(R.id.CloseSS);
//
//        //Cerrar sesion boton
//        sessionclose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Comienza una nueva activity y cierra las demas
//                Intent intent = new Intent(Profile_user.this, LoginActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//                glob.cerrarsesion();
//            }
//        });
//    }
}