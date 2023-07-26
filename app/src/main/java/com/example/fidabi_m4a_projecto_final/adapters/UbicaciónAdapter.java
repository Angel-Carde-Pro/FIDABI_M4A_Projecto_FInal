package com.example.fidabi_m4a_projecto_final.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fidabi_m4a_projecto_final.R;
import com.example.fidabi_m4a_projecto_final.request.Ubicación;
import java.util.List;

public class UbicaciónAdapter extends RecyclerView.Adapter<UbicaciónAdapter.UbicaciónViewHolder> {

    private List<Ubicación> ubicaciones;

    public UbicaciónAdapter(List<Ubicación> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    @NonNull
    @Override
    public UbicaciónViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ubicacion, parent, false);
        return new UbicaciónViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UbicaciónViewHolder holder, int position) {
        Ubicación ubicacion = ubicaciones.get(position);
        holder.txtNombre.setText(ubicacion.getUbi_nombre());
        holder.txtDepartamento.setText(ubicacion.getUbi_departamento());
        //holder.txtEstado.setText(ubicacion.getUbi_estado().toString());

    }

    @Override
    public int getItemCount() {
        return ubicaciones.size();
    }

    static class UbicaciónViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre;
        TextView txtDepartamento;
        TextView txtEstado;


        UbicaciónViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombreUbi);
            txtDepartamento = itemView.findViewById(R.id.txtDepartamentoUbi);
            //txtEstado = itemView.findViewById(R.id.txtEstadoUbi);

        }
    }
}
