package com.example.fidabi_m4a_projecto_final.configs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fidabi_m4a_projecto_final.ApiClient;
import com.example.fidabi_m4a_projecto_final.GlobalData;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.RecentActRequest;
import com.example.fidabi_m4a_projecto_final.request.RecentActResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecentActiv {

    public static void configurationRecentAc(View view) {
        RecentActRequest reacres = new RecentActRequest();
        GlobalData glob = GlobalData.getInstance();
        reacres.setUsuarios(glob.getUsuarios());

        //Obtener la llamada hacia el API
        retrofit2.Call<List<RecentActResponse>> call = ApiClient.getUserService().recentActList(reacres.getUsuarios());


        //Obtenenmos JSON
        call.enqueue(new Callback<List<RecentActResponse>>() {
            @Override
            public void onResponse(Call<List<RecentActResponse>> call, Response<List<RecentActResponse>> response) {
                List<RecentActResponse> actList = response.body();
                LinearLayout containerrecent = view.findViewById(R.id.linearlay);
                System.out.println(actList.get(0));


                for (RecentActResponse recentActRes : actList) {
                    View recentView = LayoutInflater.from(view.getContext()).inflate(R.layout.recent_activ, null);
                    TextView accion = view.findViewById(R.id.accion);
                    TextView descripcion = view.findViewById(R.id.descrip);

                    accion.setText(recentActRes.getAct_accion());
                    descripcion.setText(recentActRes.getAct_tabla());

                    containerrecent.addView(recentView);

                }

            }

            @Override
            public void onFailure(Call<List<RecentActResponse>> call, Throwable t) {

            }
        });

    }
}