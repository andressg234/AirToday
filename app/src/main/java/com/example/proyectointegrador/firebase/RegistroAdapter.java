package com.example.proyectointegrador.firebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectointegrador.R;

import java.util.ArrayList;

public class RegistroAdapter extends RecyclerView.Adapter<RegistroAdapter.RegistroViewHolder>{
    private ArrayList<DatosRegistro> listaRegistro;

    public RegistroAdapter(ArrayList<DatosRegistro> listaRegistro) {
        this.listaRegistro = listaRegistro;
    }

    @NonNull
    @Override
    public RegistroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.registro_item, parent, false);
        return new RegistroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RegistroViewHolder holder, int position) {

        holder.bindRegis(listaRegistro.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void clear() {
        listaRegistro.clear();
    }

    public class RegistroViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre;
        private TextView tvUsuario;
        private TextView tvEmail;
        private TextView tvContraseña;
        private TextView tvConContraseña;
        private String reservante;
        public RegistroViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvUsuario = itemView.findViewById(R.id.tvUsuario);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvContraseña = itemView.findViewById(R.id.tvContraseña);
            tvConContraseña = itemView.findViewById(R.id.tvCContraseña);
        }

        public void bindRegis(DatosRegistro registro) {
            tvNombre.setText(registro.getNombre());
            tvUsuario.setText(registro.getUsuario());
            tvEmail.setText(registro.getEmail());
            tvContraseña.setText(registro.getContraseña());
            tvConContraseña.setText(registro.getConfirContraseña());

        }

        public void clear() {
            listaRegistro.clear();
        }
    }
}
