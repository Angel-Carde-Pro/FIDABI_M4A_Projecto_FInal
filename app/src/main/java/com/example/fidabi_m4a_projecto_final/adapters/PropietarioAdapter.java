package com.example.fidabi_m4a_projecto_final.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.Propietario;

import java.util.List;

public class PropietarioAdapter extends RecyclerView.Adapter<PropietarioAdapter.PropietarioViewHolder> {

    private List<Propietario> propietarios;

    public PropietarioAdapter(List<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    @NonNull
    @Override
    public PropietarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_propietario, parent, false);
        return new PropietarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PropietarioViewHolder holder, int position) {
        Propietario propietario = propietarios.get(position);
        holder.txtNombre.setText(propietario.getPro_nombre());
        holder.txtDireccion.setText(propietario.getPro_direccion());
    }

    @Override
    public int getItemCount() {
        return propietarios.size();
    }

    static class PropietarioViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre;
        TextView txtDireccion;

        PropietarioViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtDireccion = itemView.findViewById(R.id.txtDireccion);
        }
    }
}

