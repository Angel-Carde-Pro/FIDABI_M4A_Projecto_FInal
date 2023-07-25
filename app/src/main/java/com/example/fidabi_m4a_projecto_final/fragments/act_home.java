package com.example.fidabi_m4a_projecto_final.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import com.example.fidabi_m4a_projecto_final.R;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fidabi_m4a_projecto_final.*;
import com.example.fidabi_m4a_projecto_final.activities.ActivityInformacionBien;
import com.example.fidabi_m4a_projecto_final.activities.CustomScannerActivity;
import com.example.fidabi_m4a_projecto_final.request.FechaBienResponse;
import com.example.fidabi_m4a_projecto_final.service.UserService;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.integration.android.IntentIntegrator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class act_home extends Fragment {
    private ActivityResultLauncher<Intent> mActivityResultLauncher;

    private Button scanner_btn;
    TextView msjWelcome, role;
    private View scan;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();

                            // Obtener el resultado del escaneo del código QR
                            IntentResult scanResult = IntentIntegrator.parseActivityResult(result.getResultCode(), data);
                            if (scanResult != null) {
                                if (scanResult.getContents() != null) {
                                    // Crear un intent para abrir la actividad de información del bien
                                    Intent informacionBienIntent = new Intent(getActivity(), ActivityInformacionBien.class);
                                    informacionBienIntent.putExtra("scanned_data", scanResult.getContents());
                                    startActivity(informacionBienIntent);
                                }
                            }
                        }
                    }
                }
        );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_act_home, container, false);
        Bundle arguments = getArguments();

        msjWelcome = root.findViewById(R.id.welcome_mss2);
        role = root.findViewById(R.id.role_id);

//        msjWelcome.setText("Hola!, bienvenid@ \n" + arguments.getString("primerNombre"));
//        role.setText(arguments.getString("rol"));
//
//        /* DATOS GLOBALES */
//        GlobalData glob = GlobalData.getInstance();
//        glob.setRol(arguments.getString("rol"));
//        glob.setPrimerNombre(arguments.getString("primerNombre"));
//        glob.setUsuarios(arguments.getLong("usuariosnick", 0));

        /*CONFIGURACION DE BOTONES*/
        scan = root.findViewById(R.id.scanner_btn);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitScanButton();
            }
        });
        return root;
    }

    public void InitScanButton() {
        IntentIntegrator integrator = IntentIntegrator.forSupportFragment(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Escanear código de barras del Bien");
        integrator.setCameraId(0);  // Usar el scanner por defecto del teléfono
        integrator.setBeepEnabled(false);
        integrator.setOrientationLocked(false);
        integrator.setCaptureActivity(CustomScannerActivity.class); // Actividad personalizada para el escaneo
        integrator.setBarcodeImageEnabled(true); // Mostrar el código escaneado en la pantalla
        Intent scanIntent = integrator.createScanIntent();
        mActivityResultLauncher.launch(scanIntent);
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