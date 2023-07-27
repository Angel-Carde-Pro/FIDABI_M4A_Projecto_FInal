package com.example.fidabi_m4a_projecto_final.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.Bien;

import java.util.ArrayList;
import java.util.List;

public class BienAdapter extends RecyclerView.Adapter<BienAdapter.BienViewHolder> {

    private List<Bien> bienes;
    private List<Bien> filteredBienes; // Lista para almacenar los bienes filtrados por cédula



    public BienAdapter() {
        this.bienes = new ArrayList<>(); // Inicializar la lista de bienes vacía
        this.filteredBienes = new ArrayList<>(); // Inicializar la lista de bienes filtrados vacía
    }

    // Método para actualizar los datos del adaptador con una nueva lista de bienes
    public void setBienes(List<Bien> bienes) {
        this.bienes = bienes;
        this.filteredBienes = new ArrayList<>(bienes); // Actualizar la lista de bienes filtrados con la nueva lista de bienes
        notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado
    }


    public BienAdapter(List<Bien> bienes) {
        this.bienes = bienes;
        this.filteredBienes = new ArrayList<>(bienes); // Inicializar la lista de bienes filtrados con todos los bienes
    }

    @NonNull
    @Override
    public BienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bien, parent, false);
        return new BienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BienViewHolder holder, int position) {
        Bien bien = filteredBienes.get(position); // Usar la lista de bienes filtrados en lugar de la lista original

        holder.txtDescripcion.setText(bien.getBien_descripcion());
        holder.txtModelo.setText(bien.getBien_codigoG());
    }

    @Override
    public int getItemCount() {
        return filteredBienes.size(); // Usar el tamaño de la lista de bienes filtrados en lugar de la lista original
    }

    // Nuevo método para filtrar la lista de bienes por cédula
    public void filterByCedula(String cedula) {
        filteredBienes.clear();
        if (cedula.isEmpty()) {
            filteredBienes.addAll(bienes); // Si la cédula está vacía, mostrar todos los bienes
        } else {
            for (Bien bien : bienes) {
                if (bien.getUsuario() != null && bien.getUsuario().getPersona() != null &&
                        bien.getUsuario().getPersona().getPerCedula() != null &&
                        bien.getUsuario().getPersona().getPerCedula().toLowerCase().contains(cedula.toLowerCase())) {
                    filteredBienes.add(bien); // Agregar el bien a la lista filtrada si la cédula coincide
                }
            }
        }
        notifyDataSetChanged(); // Notificar al adaptador que la lista de datos ha cambiado
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
