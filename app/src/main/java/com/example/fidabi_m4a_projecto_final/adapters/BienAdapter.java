package com.example.fidabi_m4a_projecto_final.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.activities.DetalleBienActivity;
import com.example.fidabi_m4a_projecto_final.request.Bien;
import com.example.fidabi_m4a_projecto_final.request.BienResponse;

import java.util.ArrayList;
import java.util.List;

public class  BienAdapter extends RecyclerView.Adapter<BienAdapter.BienViewHolder> {

    private List<BienResponse> bienes;
    private List<BienResponse> filteredBienes;

    public BienAdapter(List<BienResponse> bienes) {
        this.bienes = bienes;
        this.filteredBienes = new ArrayList<>(bienes);
    }

    // Método para actualizar los datos del adaptador con una nueva lista de bienes
    public void setBienes(List<BienResponse> bienes) {
        this.bienes = bienes;
        this.filteredBienes = new ArrayList<>(bienes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bien, parent, false);
        return new BienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BienViewHolder holder, int position) {
        BienResponse bien = filteredBienes.get(position);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetalleBienActivity.class);
            intent.putExtra("bien_objeto", bien);
            view.getContext().startActivity(intent);
        });

        holder.txtDescripcion.setText(bien.getBienDescripcion());
        holder.txtModelo.setText(bien.getBienCodigoG());
    }

    @Override
    public int getItemCount() {
        return filteredBienes.size();
    }

    // Nuevo método para filtrar la lista de bienes por cédula
    public void filterByCedula(String cedula) {
        filteredBienes.clear();
        if (cedula.isEmpty()) {
            filteredBienes.addAll(bienes);
        } else {
            for (BienResponse bien : bienes) {
                if (bien.getUsuario() != null && bien.getUsuario().getPersona() != null &&
                        bien.getUsuario().getPersona().getPerCedula() != null &&
                        bien.getUsuario().getPersona().getPerCedula().toLowerCase().contains(cedula.toLowerCase())) {
                    filteredBienes.add(bien);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class BienViewHolder extends RecyclerView.ViewHolder {

        TextView txtDescripcion;
        TextView txtModelo;

        BienViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDescripcion = itemView.findViewById(R.id.txtDescripcionBien);
            txtModelo = itemView.findViewById(R.id.txtModeloBien);
        }
    }
}