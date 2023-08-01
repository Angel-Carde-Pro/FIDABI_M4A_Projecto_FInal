package com.example.fidabi_m4a_projecto_final.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.activities.DetalleCatActivity;
import com.example.fidabi_m4a_projecto_final.activities.DetalleUbicacionActivity;
import com.example.fidabi_m4a_projecto_final.request.CatResponse;
import com.example.fidabi_m4a_projecto_final.request.Ubicación;

import java.util.ArrayList;
import java.util.List;

public class UbicaciónAdapter extends RecyclerView.Adapter<UbicaciónAdapter.UbicaciónViewHolder> {

    private List<Ubicación> ubicaciones;
    private List<Ubicación> filteredUbicaciones;

    public UbicaciónAdapter(List<Ubicación> ubicaciones) {
        this.ubicaciones = ubicaciones;
        this.filteredUbicaciones = new ArrayList<>(ubicaciones);
    }

    @NonNull
    @Override
    public UbicaciónViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ubicacion, parent, false);
        return new UbicaciónViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UbicaciónViewHolder holder, int position) {
        Ubicación ubicacion = filteredUbicaciones.get(position);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetalleUbicacionActivity.class);
            intent.putExtra("ubi_objeto", ubicacion);
            view.getContext().startActivity(intent);
        });

        holder.txtNombre.setText(ubicacion.getUbi_nombre());
        holder.txtDepartamento.setText(ubicacion.getUbi_departamento());


    }

    @Override
    public int getItemCount() {
        return filteredUbicaciones.size();
    }

    // Nuevo método para filtrar la lista de ubicaciones por nombre
    public void filterByNombre(String nombre) {
        filteredUbicaciones.clear();
        if (nombre.isEmpty()) {
            filteredUbicaciones.addAll(ubicaciones);
        } else {
            for (Ubicación ubicacion : ubicaciones) {
                if (ubicacion.getUbi_nombre().toLowerCase().contains(nombre.toLowerCase())) {
                    filteredUbicaciones.add(ubicacion);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class UbicaciónViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre;
        TextView txtDepartamento;


        UbicaciónViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombreUbi);
            txtDepartamento = itemView.findViewById(R.id.txtDepartamentoUbi);

        }
    }
}