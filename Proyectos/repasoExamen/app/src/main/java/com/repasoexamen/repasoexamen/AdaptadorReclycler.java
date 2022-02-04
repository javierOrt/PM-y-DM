package com.repasoexamen.repasoexamen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorReclycler extends RecyclerView.Adapter<AdaptadorReclycler.MyHolder> {

    private ArrayList<Contacto> listaContactos;
    private Context context;
    private OnRecyclerContactoListener listener;

    public AdaptadorReclycler(ArrayList<Contacto> listaContactos, Context context) {
        this.listaContactos = listaContactos;
        this.context = context;
        listener = (OnRecyclerContactoListener) context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_fila,parent,false);
        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Contacto contacto = listaContactos.get(position);

        holder.imagen.setImageResource(contacto.getImagen());
        holder.nombre.setText(contacto.getNombre());
        holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onContactoSelected(contacto);
            }
        });
    }

    public interface OnRecyclerContactoListener{
        void onContactoSelected(Contacto contacto);
    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView nombre;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.texto_item);
            imagen = itemView.findViewById(R.id.imagen_item);
        }
    }
}