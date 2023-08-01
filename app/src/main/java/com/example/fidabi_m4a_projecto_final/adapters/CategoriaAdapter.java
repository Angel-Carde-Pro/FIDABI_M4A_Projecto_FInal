package com.example.fidabi_m4a_projecto_final.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.activities.DetalleCatActivity;
import com.example.fidabi_m4a_projecto_final.request.CatResponse;
import com.example.fidabi_m4a_projecto_final.request.Categoria;
import com.example.fidabi_m4a_projecto_final.request.Propietario;

import java.util.ArrayList;
import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CatViewHolder> {

    private List<CatResponse> categorias;
    private List<CatResponse> filteredCategorias;


    public CategoriaAdapter(List<CatResponse> categorias) {
        this.categorias = categorias;
        this.filteredCategorias = new ArrayList<>(categorias);
    }

    // Método para actualizar los datos del adaptador con una nueva lista de categorías
    public void setCategorias(List<CatResponse> categorias) {
        this.categorias = categorias;
        this.filteredCategorias = new ArrayList<>(categorias);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        CatResponse categoria = filteredCategorias.get(position);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetalleCatActivity.class);
            intent.putExtra("cat_objeto", categoria);
            view.getContext().startActivity(intent);
        });

        holder.txtNombreCat.setText(categoria.getCat_nombre());
        holder.txtDescripcionCat.setText(categoria.getCat_descripcion());
    }

    @Override
    public int getItemCount() {
        return filteredCategorias.size();
    }

    // Nuevo método para filtrar la lista de categorías por nombre
    public void filterByNombre(String nombre) {
        filteredCategorias.clear();
        if (nombre.isEmpty()) {
            filteredCategorias.addAll(categorias);
        } else {
            for (CatResponse categoria : categorias) {
                if (categoria.getCat_nombre().toLowerCase().contains(nombre.toLowerCase())) {
                    filteredCategorias.add(categoria);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class CatViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombreCat;
        TextView txtDescripcionCat;

        CatViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNombreCat = itemView.findViewById(R.id.txtNombreCate);
            txtDescripcionCat = itemView.findViewById(R.id.txtDireccionCate);
        }
    }

    // Método para convertir una lista de Categoria en una lista de CatResponse

}