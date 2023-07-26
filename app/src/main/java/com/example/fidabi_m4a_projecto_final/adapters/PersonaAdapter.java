package com.example.fidabi_m4a_projecto_final.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.Categoria;
import com.example.fidabi_m4a_projecto_final.request.Persona;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder> {

    private List<Persona> personas;

    public PersonaAdapter(List<Persona> personas) {
        this.personas = personas;
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persona, parent, false);
        return new PersonaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        Persona persona = personas.get(position);

        holder.txtCedula.setText(persona.getPerCedula());
        holder.txtNombre.setText(persona.getPerPrimerNom());
        holder.txtNombre2.setText(persona.getPerApellidoPater());

    }

    @Override
    public int getItemCount() {
        return personas.size();
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
