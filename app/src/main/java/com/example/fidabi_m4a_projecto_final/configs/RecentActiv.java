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
        reacres.setUsu_cod(glob.getUsuarios());
        TextView accion = view.findViewById(R.id.state_txt);
        TextView descripcion = view.findViewById(R.id.desc_txt);
        TextView fecha = view.findViewById(R.id.date_txt);
        TextView usuario = view.findViewById(R.id.usu_txt);


        //OJO AGREGAR VALIDACION DE USUARIO CON UN IF AL CALL

        //Obtener la llamada hacia el API
        retrofit2.Call<List<RecentActResponse>> call = ApiClient.getUserService().recentActList(reacres);


        //Obtenenmos JSON
        call.enqueue(new Callback<List<RecentActResponse>>() {
            @Override
            public void onResponse(Call<List<RecentActResponse>> call, Response<List<RecentActResponse>> response) {
                List<RecentActResponse> actList = response.body();
                if (actList != null && !actList.isEmpty()) { // Check if the list is not null and not empty
                    LinearLayout containerrecent = view.findViewById(R.id.itemlayout);

                    for (RecentActResponse recentActRes : actList) {
                        View recentView = LayoutInflater.from(view.getContext()).inflate(R.layout.recent_item, null);

                        //accion.setText(recentActRes.getAct_accion());
                        descripcion.setText(recentActRes.getBien().getBien_descripcion());
                        accion.setText("Le fue asignado");
                        fecha.setText(recentActRes.getHis_fecha());
                        containerrecent.addView(recentView);
                    }
                } else {
                    accion.setText("No hay acciones recientes");
                    descripcion.setText("");
                    fecha.setText("");
                    usuario.setText("");

                }
            }

            @Override
            public void onFailure(Call<List<RecentActResponse>> call, Throwable t) {
                // Handle failure if needed
            }
        });

    }
}
