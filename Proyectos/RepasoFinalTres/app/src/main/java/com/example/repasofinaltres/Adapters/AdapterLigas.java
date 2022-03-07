package com.example.repasofinaltres.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repasofinaltres.R;
import com.example.repasofinaltres.utils.Ligas;

import java.util.ArrayList;

public class AdapterLigas extends RecyclerView.Adapter<AdapterLigas.MyHoloder> {

    private ArrayList<Ligas> ligasArrayList;
    private Context context;
    private OnLigaListener listener;


    public AdapterLigas(Context context) {
        this.context = context;
        this.ligasArrayList = new ArrayList<>();
        listener = (OnLigaListener) context;
    }

    @NonNull
    @Override
    public MyHoloder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ligas,parent,false);
        return new MyHoloder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoloder holder, int position) {

        Ligas liga = ligasArrayList.get(position);
        holder.nombreLIga.setText(liga.getNombre());
        holder.nombreLIga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onLigaSelected(holder.nombreLIga.getText().toString());
            }
        });

    }

    @Override
    public int getItemCount() {
        return ligasArrayList.size();
    }

    public class MyHoloder extends RecyclerView.ViewHolder {

        private TextView nombreLIga;

        public MyHoloder(@NonNull View itemView) {
            super(itemView);
            nombreLIga = itemView.findViewById(R.id.texto_ligas);
        }
    }

    public interface OnLigaListener{
        void onLigaSelected(String nombreLiga);
    }

    public void agregarLigas(Ligas liga){
        ligasArrayList.add(liga);
        notifyDataSetChanged();
    }
}
