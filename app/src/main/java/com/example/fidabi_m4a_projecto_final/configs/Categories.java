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
        import com.google.gson.JsonArray;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.Serializable;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;

        import retrofit2.Call;
        import retrofit2.Response;

public class  Categories implements Serializable {

    public static void configurationCategory(View view){

        //                // Configura los datos de la categoría en la vista creada
        //                ImageView categoryImage = categoryView.findViewById(R.id.category_image);
        //                TextView categoryName = categoryView.findViewById(R.id.category_name);
        //                categoryImage.setImageResource(category.getImageResource());
        //                categoryName.setText(category.getName());
        //
        //                // Agrega la vista de categoría al LinearLayout
        //                categoryLayout.addView(categoryView);
        //            }

        //Llamamos al get
        retrofit2.Call<List<CatResponse>> call = ApiClient.getUserService().catList();
        call.enqueue(new retrofit2.Callback<List<CatResponse>>(){
            @Override
            public void onResponse(Call<List<CatResponse>> call, Response<List<CatResponse>> response) {
                List<CatResponse> categories = response.body();
                LinearLayout categoryContainer = view.findViewById(R.id.contanerliner);

                for (CatResponse category : categories){
                    // Inflar el diseño de la categoría
                    View categoryView = LayoutInflater.from(view.getContext()).inflate(R.layout.category_item, null);

                    // Convertir 20dp a pixels
                    int marginLeft = dpToPx(20, view.getContext());

                    // Establecer los parámetros de diseño con margen izquierdo
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,     // Ancho de los hijos
                            LinearLayout.LayoutParams.WRAP_CONTENT      // Alto de los hijos
                    );
                    layoutParams.setMargins(marginLeft, 0, 0, 0);     // left, top, right, bottom
                    categoryView.setLayoutParams(layoutParams);

                    // Establecer los datos de la categoría en los elementos del diseño
                    ImageView categoryImage = categoryView.findViewById(R.id.category_image);
                    TextView categoryName = categoryView.findViewById(R.id.category_name);
                    categoryImage.setImageResource(R.drawable.inventario_icon); // Coloca la imagen apropiada
                    categoryName.setText(category.getCat_nombre());

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