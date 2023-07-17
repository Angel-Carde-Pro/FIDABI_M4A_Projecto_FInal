        package com.example.fidabi_m4a_projecto_final.configs;

        import android.view.View;
        import android.widget.TextView;

        import com.example.fidabi_m4a_projecto_final.ApiClient;
        import com.example.fidabi_m4a_projecto_final.R;
        import com.example.fidabi_m4a_projecto_final.request.CatResponse;
        import com.google.gson.JsonArray;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;

        import retrofit2.Call;
        import retrofit2.Response;

public class Categories {

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
                String jsonRespose = response.body().toString();
                List<CatResponse> categories = parseoJSON(jsonRespose);
                TextView nombre = view.findViewById(R.id.nombredesc);


                for (CatResponse catResponse : categories){
                    nombre.setText(catResponse.getCat_nombre());

                }
            }

            @Override
            public void onFailure(Call<List<CatResponse>> call, Throwable t) {

            }
        });

    }
    public static List<CatResponse> parseoJSON(String JSON){

        List<CatResponse> categories = new ArrayList<>();
        try {
            //Tranformar el json como array
            JSONArray jsonArra = new JSONArray(JSON);
            for (int i = 0; i < jsonArra.length(); i++){

                //Obtener el json como objeto para poder sacar los datos
                JSONObject jsonObject = jsonArra.getJSONObject(i);

                //Asignar los datos del json como variables
                int catCod = jsonObject.getInt("cat_cod");
                String catNombre = jsonObject.getString("cat_nombre");
                String catDescripcion = jsonObject.getString("cat_descripcion");
                boolean catEstado = jsonObject.getBoolean("cat_estado");

                CatResponse category = new CatResponse(catCod,catNombre,catDescripcion,catEstado);

                categories.add(category);



            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return categories;
    }
}