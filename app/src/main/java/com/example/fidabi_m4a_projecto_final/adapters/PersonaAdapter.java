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
import com.example.fidabi_m4a_projecto_final.activities.DetallePersonaActivity;
import com.example.fidabi_m4a_projecto_final.request.BienResponse;
import com.example.fidabi_m4a_projecto_final.request.Categoria;
import com.example.fidabi_m4a_projecto_final.request.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder> {

    private List<Persona> personas;
    private List<Persona> filteredPersonas;

    public PersonaAdapter(List<Persona> personas) {
        this.personas = personas;
        this.filteredPersonas = new ArrayList<>(personas);
    }

    // Método para actualizar los datos del adaptador con una nueva lista de personas
    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
        this.filteredPersonas = new ArrayList<>(personas);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persona, parent, false);
        return new PersonaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        Persona persona = filteredPersonas.get(position);

        holder.itemView.setOnClickListener(view -> {
            // Aquí deberías definir la clase DetallePersonaActivity en lugar de DetalleBienActivity
            Intent intent = new Intent(view.getContext(), DetallePersonaActivity.class);
            intent.putExtra("persona_objeto", persona);
            view.getContext().startActivity(intent);
        });

        holder.txtCedula.setText(persona.getPerCedula());
        holder.txtNombre.setText(persona.getPerPrimerNom() + " " + persona.getPerApellidoPater());
        holder.txtNombre2.setText(persona.getPerEmail());
    }

    @Override
    public int getItemCount() {
        return filteredPersonas.size();
    }

    // Nuevo método para filtrar la lista de personas por cédula
    public void filterByCedula(String cedula) {
        filteredPersonas.clear();
        if (cedula.isEmpty()) {
            filteredPersonas.addAll(personas);
        } else {
            for (Persona persona : personas) {
                if (persona.getPerCedula() != null && persona.getPerCedula().toLowerCase().contains(cedula.toLowerCase())) {
                    filteredPersonas.add(persona);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class PersonaViewHolder extends RecyclerView.ViewHolder {

        TextView txtCedula;
        TextView txtNombre;
        TextView txtNombre2;

        PersonaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCedula = itemView.findViewById(R.id.txtCedulaPer);
            txtNombre = itemView.findViewById(R.id.txtNombrePer);
            txtNombre2 = itemView.findViewById(R.id.txtNombre2Per);
        }
    }
}



