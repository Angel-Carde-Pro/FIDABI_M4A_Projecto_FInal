package com.example.fidabi_m4a_projecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fidabi.request.LoginRequest;
import com.example.fidabi.request.LoginResponse;
import com.example.fidabi_m4a_projecto_final.request.LoginRequest;
import com.example.fidabi_m4a_projecto_final.request.LoginResponse;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    //variables del login activity
    Button btnacept;
    TextView btxolvido;
    EditText txtcorreo,txtpassword;
    private LoginResponse loginResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button myButton = findViewById(R.id.buttonacept);
        myButton.setBackgroundResource(R.drawable.roundedbuttonista);
        btnacept = findViewById(R.id.buttonacept);
        btxolvido = findViewById(R.id.txtrecuperar);
        txtcorreo = findViewById(R.id.editmail);
        txtpassword = findViewById(R.id.edittextpassword);

        //evento de boton iniciar
        btnacept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(txtcorreo.getText().toString())||TextUtils.isEmpty(txtpassword.getText().toString())){
                    Toast.makeText(LoginActivity.this,"Correo/Contraseña son necesarios",Toast.LENGTH_LONG).show();

                }else{
                    //logearse
                    login();
                }
            }
        });
    }
    public void login (){
        LoginRequest logre= new LoginRequest();
        logre.setUsuario(txtcorreo.getText().toString());
        logre.setPassword(txtpassword.getText().toString());

        //llamamos al response para obtener el json de respuesta al login
        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(logre);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login Correcto",Toast.LENGTH_LONG).show();
                    loginResponse = response.body();

                            /* PARA QUE FUNCU¡IONE EL JSON EN EL LOGIN RESPONSE PONER
                            TODO EL RESPONSE DEL JSON*/

                    LoginResponse.Persona persona = loginResponse.getPersona();
                    String primerNombre = persona.getPerPrimerNom();
                    String segundoNombre = persona.getPerSegundoNom();
                    String telefono = persona.getPerTelefono();

                    List<LoginResponse.Rol> roles = loginResponse.getRoles();
                    for (LoginResponse.Rol rol : roles) {
                        int codigoRol = rol.getRolCod();
                        String nombreRol = rol.getRolNombre();
                        boolean estadoRol = rol.isRolEstado();

                        Intent intent = new Intent(LoginActivity.this, Profile_user.class);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("rol",nombreRol);
                        startActivity(intent);

                    }
                    //intent para pasar el response a otro activity
                    // Otros campos de LoginResponse
                    String usuario = loginResponse.getUsuario();
                    String contrasenia = loginResponse.getContrasenia();
                    boolean estadoUsuario = loginResponse.isUsuEstado();

                    // Continuar con el flujo de tu aplicación, como iniciar una nueva actividad

                }else{
                    Toast.makeText(LoginActivity.this, "Login Fallo", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"ERROR: "+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}