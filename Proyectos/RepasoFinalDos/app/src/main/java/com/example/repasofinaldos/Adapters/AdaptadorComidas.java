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
import com.example.repasofinaldos.utils.Comidas;

import java.util.ArrayList;

public class AdaptadorComidas extends RecyclerView.Adapter<AdaptadorComidas.MyHolder> {

    private ArrayList<Comidas> comidasArrayList;
    private Context context;
    private OnComidaListener listener;

    public AdaptadorComidas( Context context) {
        this.comidasArrayList = new ArrayList<>();
        this.context = context;
        listener = (OnComidaListener) context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_comidas,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Comidas comida = comidasArrayList.get(position);
        holder.nombreComida.setText(comida.getNombreComida());
        Glide.with(context).load(comida.getImagenComida()).into(holder.imagenComida);

        holder.nombreComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onComidaSelected(comida);

            }
        });

    }

    @Override
    public int getItemCount() {
        return comidasArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView nombreComida;
        private ImageView imagenComida;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nombreComida = itemView.findViewById(R.id.texto_comida);
            imagenComida = itemView.findViewById(R.id.imagen_comida);

        }
    }

    public void agregarComidas(Comidas comida){
        comidasArrayList.add(comida);
        notifyDataSetChanged();
    }

    public interface OnComidaListener{
        void onComidaSelected(Comidas comida);
    }
}
