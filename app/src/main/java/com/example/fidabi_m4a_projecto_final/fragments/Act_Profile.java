package com.example.fidabi_m4a_projecto_final.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fidabi_m4a_projecto_final.R;

import kotlin.jvm.internal.Intrinsics;

public class Act_Profile extends Fragment {

    TextView msjWelcome, role;
    private View scan;

    public Act_Profile() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_act_profile, container, false);

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llama al método shareApp() cuando se haga clic en tu LinearLayout
                shareApp(Act_Profile.this);
            }
        });
        return root;
    }

    public final void shareApp(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$shareApp");
        StringBuilder sb = new StringBuilder();
        sb.append(fragment.getString(R.string.base_link_apk));
        Context context = fragment.getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        sb.append(context.getPackageName());
        String sb2 = sb.toString();
        String string = fragment.getString(R.string.app_name);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.app_name)");
        Log.d("Link_Apk", sb2);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", fragment.getString(R.string.app_name));
        StringBuilder sb3 = new StringBuilder();
        sb3.append(string);
        sb3.append(" : ");
        sb3.append(fragment.getString(R.string.app_name));
        sb3.append(": ");
        sb3.append(sb2);
        intent.putExtra("android.intent.extra.TEXT", sb3.toString());
        fragment.startActivity(Intent.createChooser(intent, fragment.getString(R.string.share_via)));
    }
}