package com.example.fidabi_m4a_projecto_final.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fidabi_m4a_projecto_final.ApiClient;
import com.example.fidabi_m4a_projecto_final.GlobalData;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.FechaBienResponse;
import com.example.fidabi_m4a_projecto_final.service.UserService;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.integration.android.IntentIntegrator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityHome extends AppCompatActivity {
    TextView msjWelcome, role;
    private View scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.statusbar_1));

        msjWelcome = findViewById(R.id.welcome_mss2);
        role = findViewById(R.id.role_id);

        msjWelcome.setText("Hola!, bienvenid@ \n" + getIntent().getStringExtra("primerNombre"));
        role.setText(getIntent().getStringExtra("rol"));

        /* DATOS GLOBALES */
        GlobalData glob = GlobalData.getInstance();
        glob.setRol(getIntent().getStringExtra("rol"));
        glob.setPrimerNombre(getIntent().getStringExtra("primerNombre"));
        glob.setUsuarios(getIntent().getLongExtra("usuariosnick", 0));

        /*CONFIGURACION DE BOTONES*/
        scan = findViewById(R.id.scanner);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitScanButton();
            }
        });
    }

    public void InitScanButton() {
        // Iniciar el escaneo de códigos de barras y códigos QR
        IntentIntegrator integrator = new IntentIntegrator(ActivityHome.this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Escanear código de barras del Bien");
        integrator.setCameraId(0); // Usar el scanner por defecto del teléfono
        integrator.setBeepEnabled(false);
        integrator.setOrientationLocked(false);

        // Personalizar el escaneo
        integrator.setCaptureActivity(CustomScannerActivity.class); // Actividad personalizada para el escaneo
        integrator.setBarcodeImageEnabled(true); // Mostrar el código escaneado en la pantalla

        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Obtener el resultado del escaneo del código QR
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                // Crear un intent para abrir la actividad de información del bien
                Intent informacionBienIntent = new Intent(ActivityHome.this, ActivityInformacionBien.class);
                informacionBienIntent.putExtra("scanned_data", result.getContents());
                startActivity(informacionBienIntent);
            } else {
                finish();
            }
        }
    }

    public void fechasproximas() {
        UserService userService = ApiClient.getUserService();

        Call<List<FechaBienResponse>> call = userService.fechprox();
        call.enqueue(new Callback<List<FechaBienResponse>>() {
            @Override
            public void onResponse(Call<List<FechaBienResponse>> call, Response<List<FechaBienResponse>> response) {
                List<FechaBienResponse> fechaBienResponses = response.body();
                for (FechaBienResponse fechas : fechaBienResponses) {
                    String nombre = fechas.getBien_detalles();
                    String fechaprox = fechas.getBien_fecha_consta();
                }
            }

            @Override
            public void onFailure(Call<List<FechaBienResponse>> call, Throwable t) {

            }
        });
    }
}

