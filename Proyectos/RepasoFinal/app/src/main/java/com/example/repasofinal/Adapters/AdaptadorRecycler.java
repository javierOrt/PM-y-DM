package com.example.repasofinal.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repasofinal.R;
import com.example.repasofinal.utils.Ligas;

import java.lang.invoke.LambdaConversionException;
import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.Myholder> {

    private ArrayList<Ligas> listaLigas;
    private Context context;
    private OnLigaListener listener;

    public AdaptadorRecycler( Context context) {

        this.context = context;
        this.listaLigas = new ArrayList<>();
        listener = (OnLigaListener) context;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ligas,parent,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {

        Ligas liga = listaLigas.get(position);
        holder.nombreLiga.setText(liga.getNombre());

        holder.linearLigas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onLigaSelecionada(holder.nombreLiga.getText().toString());
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaLigas.size();
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView nombreLiga;
        LinearLayout linearLigas;


        public Myholder(@NonNull View itemView) {
            super(itemView);
            nombreLiga = itemView.findViewById(R.id.nombre_liga);
            linearLigas = itemView.findViewById(R.id.linear_ligas);

        }
    }

    public interface OnLigaListener{
        void onLigaSelecionada(String nombresLiga);
    }

    public void agregarLiga(Ligas liga){
        listaLigas.add(liga);
        notifyDataSetChanged();


    }




}
