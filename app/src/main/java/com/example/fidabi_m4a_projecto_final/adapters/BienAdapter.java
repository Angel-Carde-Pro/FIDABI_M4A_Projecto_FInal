package com.example.fidabi_m4a_projecto_final.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.Bien;

import java.util.List;

public class BienAdapter extends RecyclerView.Adapter<BienAdapter.BienViewHolder> {

    private List<Bien> bienes;

    public BienAdapter(List<Bien> bienes) {
        this.bienes = bienes;
    }

    @NonNull
    @Override
    public BienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bien, parent, false);
        return new BienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BienViewHolder holder, int position) {
        Bien bien = bienes.get(position);

        holder.txtDescripcion.setText(bien.getBien_descripcion());
        holder.txtModelo.setText(bien.getBien_codigoG());

    }

    @Override
    public int getItemCount() {
        return bienes.size();
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
