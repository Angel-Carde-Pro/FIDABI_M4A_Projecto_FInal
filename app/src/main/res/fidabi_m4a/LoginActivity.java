package com.example.fidabi_m4a;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fidabi_m4a.request.LoginRequest;
import com.example.fidabi_m4a.request.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    //variables del login activity
    Button btnacept;
    TextView btxolvido;
    EditText txtcorreo,txtpassword;
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
                    Toast.makeText(LoginActivity.this,"Correo/Contraseña son necesarios",Toast.LENGTH_LONG);

                }else{
                    //logearse
                    login();
                }
            }
        });
    }
    public void login (){
        LoginRequest lore = new LoginRequest();
        lore.setUsuario(txtcorreo.getText().toString());
        lore.setPassword(txtpassword.getText().toString());
        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(lore);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login Correcto",Toast.LENGTH_LONG);
                }else{
                    Toast.makeText(LoginActivity.this, "Login Fallo", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"ERROR: "+t.getLocalizedMessage(),Toast.LENGTH_LONG);
            }
        });

    }
}