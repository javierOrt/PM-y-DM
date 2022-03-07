package com.example.proyectojson.Adaptadores;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectojson.R;
import com.example.proyectojson.utils.Equipo;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.Myholder>  {

    private ArrayList<Equipo> listaEquipos;
    private Context context;
    private OnEquipoListener listener;

    public AdaptadorRecycler( Context context) {
        this.listaEquipos = new ArrayList<>();
        this.context = context;
        listener = (OnEquipoListener) context;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista,parent,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {

        Equipo equipo = listaEquipos.get(position);
        //holder.imagen.setImageResource(listaEquipos.getImagen());
        holder.nombre.setText(equipo.getNombre());
        Glide.with(context).load(equipo.getEscudo()).into(holder.imagen);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onEquipoSelected(equipo);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaEquipos.size();
    }

    class Myholder extends RecyclerView.ViewHolder{
    TextView nombre;
    ImageView imagen;
    LinearLayout linearLayout;

    public Myholder(@NonNull View itemView) {
        super(itemView);
        nombre = itemView.findViewById(R.id.nombre_equipo);
        imagen = itemView.findViewById(R.id.imagen_item);
        linearLayout = itemView.findViewById(R.id.linear_list);
    }
}

    public void agregarEquipo(Equipo equipo){
        listaEquipos.add(equipo);
        notifyDataSetChanged();
        Log.v("Resultado",String.valueOf(listaEquipos.size()));

}


public interface OnEquipoListener{
        void onEquipoSelected(Equipo equipo);
}



}
