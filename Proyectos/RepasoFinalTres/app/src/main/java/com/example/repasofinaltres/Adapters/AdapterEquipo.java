package com.example.repasofinaltres.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.repasofinaltres.R;
import com.example.repasofinaltres.utils.Equipo;

import java.util.ArrayList;

public class AdapterEquipo extends RecyclerView.Adapter<AdapterEquipo.MyHolder> {

    private ArrayList<Equipo> equipoArrayList;
    private Context context;
    private OnEquipoListener listener;

    public AdapterEquipo(Context context) {
        this.context = context;
        this.equipoArrayList = new ArrayList<>();
        listener = (OnEquipoListener) context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_equipos,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Equipo equipo = equipoArrayList.get(position);

        holder.nombre.setText(equipo.getNombre());
        Glide.with(context).load(equipo.getEscudo()).into(holder.escudo);

        holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onEquipoSelecionado(equipo);
            }
        });

    }

    @Override
    public int getItemCount() {
        return equipoArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView escudo;
        private TextView nombre;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            escudo = itemView.findViewById(R.id.imagen_equipo);
            nombre = itemView.findViewById(R.id.nombre_equipo);
        }
    }

    public interface OnEquipoListener{
        void onEquipoSelecionado(Equipo equipo);
    }

    public void agregarEquipo(Equipo equipo){
        equipoArrayList.add(equipo);
        notifyDataSetChanged();
    }
}
