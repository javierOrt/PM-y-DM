package com.example.repasofinal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.repasofinal.R;
import com.example.repasofinal.utils.Equipos;
import com.example.repasofinal.utils.Ligas;

import java.util.ArrayList;

public class AdaptadorEquipos extends RecyclerView.Adapter<AdaptadorEquipos.MyHolder> {

    private ArrayList<Equipos> equiposArrayList;
    private Context context;
    private OnEquipoListener listener;

    public AdaptadorEquipos( Context context) {
        this.equiposArrayList = new ArrayList<>();
        this.context = context;
        listener = (OnEquipoListener) context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Equipos equipo = equiposArrayList.get(position);
        holder.nombreEquipo.setText(equipo.getNombre());
        Glide.with(context).load(equipo.getImagen()).into(holder.imagenEquipo);

        holder.imagenEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onEquipoSelected(equipo);
            }
        });

    }

    @Override
    public int getItemCount() {
        return equiposArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView nombreEquipo;
        private ImageView imagenEquipo;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            nombreEquipo = itemView.findViewById(R.id.nombre_equipo);
            imagenEquipo = itemView.findViewById(R.id.imagen_item);
        }
    }

    public void agregarEquipo(Equipos equipo){
        equiposArrayList.add(equipo);
        notifyDataSetChanged();
    }

    public interface OnEquipoListener{
        void onEquipoSelected(Equipos equipo);
    }

}
