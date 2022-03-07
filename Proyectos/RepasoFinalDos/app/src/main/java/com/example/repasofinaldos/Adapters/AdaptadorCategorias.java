package com.example.repasofinaldos.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.repasofinaldos.R;
import com.example.repasofinaldos.utils.Categorias;

import java.util.ArrayList;

public class AdaptadorCategorias extends RecyclerView.Adapter<AdaptadorCategorias.MyHolder> {

    private ArrayList<Categorias> listaCategorias;
    private Context context;
    private OnCategoriaListener listener;

    public AdaptadorCategorias( Context context) {
        this.listaCategorias = new ArrayList<>();
        this.context = context;
        listener = (OnCategoriaListener) context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_categoria,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Categorias categorias = listaCategorias.get(position);
        holder.nombreCategoria.setText(categorias.getCategoria());
        Glide.with(context).load(categorias.getImagenCategoria()).into(holder.imagenCategoria);

        holder.nombreCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCategoriaSelecionada(holder.nombreCategoria.getText().toString());
            }
        });



    }

    @Override
    public int getItemCount() {
        return listaCategorias.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView nombreCategoria;
        private ImageView imagenCategoria;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nombreCategoria = itemView.findViewById(R.id.texto_categoria);
            imagenCategoria = itemView.findViewById(R.id.imagen_categoria);
        }
    }

    public interface OnCategoriaListener{
        void onCategoriaSelecionada(String nombresCategorias);
    }

    public void agregarCategoria(Categorias categoria){
        listaCategorias.add(categoria);
        notifyDataSetChanged();
    }
}
