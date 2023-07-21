        package com.example.fidabi_m4a_projecto_final.configs;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import com.example.fidabi_m4a_projecto_final.ApiClient;
        import com.example.fidabi_m4a_projecto_final.R;
        import com.example.fidabi_m4a_projecto_final.request.CatResponse;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Response;

        public class Profile {

            public static void configurationCategory(View view){
                //Llamamos al get
                Call<List<CatResponse>> call = ApiClient.getUserService().catList();
                call.enqueue(new retrofit2.Callback<List<CatResponse>>(){
                    @Override
                    public void onResponse(Call<List<CatResponse>> call, Response<List<CatResponse>> response) {
                        List<CatResponse> categories = response.body();
                        LinearLayout categoryContainer = view.findViewById(R.id.contanerliner);

                        for (CatResponse category : categories){
                            // Inflar el diseño de la categoría
                            View categoryView = LayoutInflater.from(view.getContext()).inflate(R.layout.profile_item, null);

                            // Convertir 20dp a pixels
                            int marginLeft = dpToPx(20, view.getContext());

                            // Establecer los parámetros de diseño con margen izquierdo
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.WRAP_CONTENT,     // Ancho de los hijos
                                    LinearLayout.LayoutParams.WRAP_CONTENT      // Alto de los hijos
                            );
                            layoutParams.setMargins(marginLeft, 0, 0, 0);     // left, top, right, bottom
                            categoryView.setLayoutParams(layoutParams);

                            // Agregar la vista de categoría al contenedor
                            categoryContainer.addView(categoryView);
                        }

                    }

                    public int dpToPx(int dp, Context context){
                        return (int) (dp * context.getResources().getDisplayMetrics().density);
                    }

                    @Override
                    public void onFailure(Call<List<CatResponse>> call, Throwable t) {

                    }
                });
            }

        }