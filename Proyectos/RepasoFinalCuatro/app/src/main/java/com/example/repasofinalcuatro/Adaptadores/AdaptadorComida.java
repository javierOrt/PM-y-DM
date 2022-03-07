package com.example.repasofinalcuatro.Adaptadores;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.repasofinalcuatro.R;
import com.example.repasofinalcuatro.utils.Comida;

import java.lang.invoke.LambdaConversionException;
import java.util.ArrayList;

public class AdaptadorComida extends RecyclerView.Adapter<AdaptadorComida.MyHolder> {

    private ArrayList<Comida> comidaArrayList;
    private Context context;
    private OnComidaListener listener;

    public AdaptadorComida(Context context) {
        this.context = context;
        this.comidaArrayList = new ArrayList<>();
        listener = (OnComidaListener) context;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comida,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Comida comida = comidaArrayList.get(position);
        holder.nombre.setText(comida.getNombre());
        Glide.with(context).load(comida.getImagen()).into(holder.imagen);

        holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onComidaSelecionada(comida);
            }
        });
    }

    @Override
    public int getItemCount() {
        return comidaArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private ImageView imagen;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_plato);
            imagen = itemView.findViewById(R.id.imagen_plato);

        }
    }

    public interface OnComidaListener{
        void onComidaSelecionada(Comida comida);
    }

    public void agregarComidas(Comida comida){
        comidaArrayList.add(comida);
        notifyDataSetChanged();
    }
}
