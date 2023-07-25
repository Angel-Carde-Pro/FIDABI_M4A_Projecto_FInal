package com.example.fidabi_m4a_projecto_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fidabi_m4a_projecto_final.ApiClient;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.RecentActRequest;
import com.example.fidabi_m4a_projecto_final.request.UpdateIntervaloBienRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimerContaActivity extends AppCompatActivity {
    Button aceptar;
    EditText cantidad;
    UpdateIntervaloBienRequest inter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_conta);

        cantidad = findViewById(R.id.txtdias);
        aceptar = findViewById(R.id.button);

        inter = new UpdateIntervaloBienRequest();

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(cantidad.getText().toString()) || cantidad.getText().toString().equals("0")) {
                    Toast.makeText(TimerContaActivity.this, "Ingrese un valor correcto", Toast.LENGTH_SHORT).show();
                } else {
                    // Obtener el texto ingresado en el EditText como String
                    String cantidadText = cantidad.getText().toString();
                    // Convertir el String a un valor entero (int)
                    int dias = Integer.parseInt(cantidadText);
                    inter.setBien_intervalo(dias);

                    actualizarvalor();
                }
            }
        });
    }

    public void actualizarvalor() {
        Call<Void> call = ApiClient.getUserService().updatevalido(inter.getBien_intervalo());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(TimerContaActivity.this, "se ha actualizado correctamente", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Manejar la falla de la solicitud
            }
        });
    }
}
