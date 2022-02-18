package com.pmydmexamen.examen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MyHolder> {

    private ArrayList<Jugador> listaJugadores;
    private Context context;
    private OnRecyclerContactoListener listener;

    public AdaptadorRecycler(ArrayList<Jugador> listaJugadores, Context context) {
        this.listaJugadores = listaJugadores;
        this.context = context;
        listener = (OnRecyclerContactoListener) context;
    }

    @NonNull
    @Override
    public AdaptadorRecycler.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_fila,parent,false);
        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.MyHolder holder, int position) {

        Jugador jugador = listaJugadores.get(position);

        holder.imagen.setImageResource(jugador.getImagen());
        holder.nombre.setText(jugador.getNombre());
        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onJugadorSelected(jugador);
            }
        });
    }

    public interface OnRecyclerContactoListener{
        void onJugadorSelected(Jugador jugador);
    }

    @Override
    public int getItemCount() {
        return listaJugadores.size();
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
