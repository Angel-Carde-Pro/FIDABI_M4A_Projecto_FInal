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

import com.example.fidabi_m4a_projecto_final.R;

import kotlin.jvm.internal.Intrinsics;

public class Act_Profile extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Act_Profile() {
        // Required empty public constructor
    }

    public static Act_Profile newInstance(String param1, String param2) {
        Act_Profile fragment = new Act_Profile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_act_profile, container, false);

        LinearLayout myLayout = view.findViewById(R.id.share_app);

        myLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llama al método shareApp() cuando se haga clic en tu LinearLayout
                shareApp(Act_Profile.this);
            }
        });

        return view;
    }
}