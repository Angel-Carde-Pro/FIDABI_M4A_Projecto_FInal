package com.example.fidabi_m4a_projecto_final.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fidabi_m4a_projecto_final.ApiClient;
import com.example.fidabi_m4a_projecto_final.GlobalData;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.activities.ActivityInformacionBien;
import com.example.fidabi_m4a_projecto_final.activities.CustomScannerActivity;
import com.example.fidabi_m4a_projecto_final.request.FechaBienResponse;
import com.example.fidabi_m4a_projecto_final.service.UserService;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class act_Inventory extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_act_inventory, container, false);

        androidx.appcompat.widget.Toolbar toolbar = root.findViewById(R.id.toolbar);

        toolbar.setTitle("Listados");

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        return root;
    }

    public void onOptionClicked(View view) {
        // Obtenemos la animación desde el archivo XML
        Animation clickAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.card_click_animation);
        view.startAnimation(clickAnimation);

        String tag = (String) view.getTag();
        String optionName;
        switch (tag) {
            case "bienes":
                optionName = "Bienes";
                break;
            case "categoria":
                optionName = "Categoría";
                break;
            case "historial":
                optionName = "Historial";
                break;
            case "persona":
                optionName = "Persona";
                break;
            case "propietario":
                optionName = "Propietario";
                break;
            case "roles":
                optionName = "Roles";
                break;
            case "ubicaciones":
                optionName = "Ubicaciones";
                break;
            case "usuarios":
                optionName = "Usuarios";
                break;
            default:
                optionName = "";
                break;
        }

        Toast.makeText(getActivity(), "Opción seleccionada: " + optionName, Toast.LENGTH_SHORT).show();
    }
}
