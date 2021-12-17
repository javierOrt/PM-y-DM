package com.example.javierortizfeliz2.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.javierortizfeliz2.R;
import com.example.javierortizfeliz2.utils.Restaurante;

import java.util.ArrayList;

public class AdaptadorRestaurante extends BaseAdapter {
    ArrayList<Restaurante> listaRestaurante;
    Context context;

    public AdaptadorRestaurante(ArrayList<Restaurante> listaRestaurante, Context context) {
        this.listaRestaurante = listaRestaurante;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaRestaurante.size();
    }

    @Override
    public Object getItem(int position) {
        return listaRestaurante.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.lista_layout,parent,false);
        Restaurante restauranteActual = listaRestaurante.get(position);

        TextView textoNombre = convertView.findViewById(R.id.text_lista_nombre);
        TextView textoLocalidad = convertView.findViewById(R.id.text_lista_localidad);

        textoNombre.setText(restauranteActual.getNombre());
        textoLocalidad.setText(restauranteActual.getLocalidad());

        return convertView;
    }
}
