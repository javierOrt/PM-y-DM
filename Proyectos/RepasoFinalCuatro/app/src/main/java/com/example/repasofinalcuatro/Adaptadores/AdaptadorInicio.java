package com.example.repasofinalcuatro.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.repasofinalcuatro.R;
import com.example.repasofinalcuatro.utils.Categorias;

import java.util.ArrayList;

public class AdaptadorInicio extends RecyclerView.Adapter<AdaptadorInicio.MyHolder> {

    private ArrayList<Categorias> categoriasArrayList;
    private Context context;
    private OnCategoriaListener listener;

    public AdaptadorInicio(Context context) {
        this.context = context;
        this.categoriasArrayList = new ArrayList<>();
        listener = (OnCategoriaListener) context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_categorias,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Categorias categorias = categoriasArrayList.get(position);
        holder.nombre.setText(categorias.getNombre());
        Glide.with(context).load(categorias.getImagen()).into(holder.imagen);

        holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCategoriaSelecionada(holder.nombre.getText().toString());
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoriasArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView nombre;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_categorias);
            nombre = itemView.findViewById(R.id.nombre_categorias);
        }
    }

    public interface OnCategoriaListener{
        void onCategoriaSelecionada(String nombreCategorias);
    }

    public void agregarCategoria(Categorias categorias){
        categoriasArrayList.add(categorias);
        notifyDataSetChanged();
    }
}
