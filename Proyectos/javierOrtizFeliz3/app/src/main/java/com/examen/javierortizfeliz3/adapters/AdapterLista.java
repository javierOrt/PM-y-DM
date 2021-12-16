package com.examen.javierortizfeliz3.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.examen.javierortizfeliz3.R;
import com.examen.javierortizfeliz3.utils.ListaSeleccionada;

import java.util.ArrayList;

public class AdapterLista extends BaseAdapter {

    ArrayList<ListaSeleccionada> listaSeleccionada;
    Context context;

    public AdapterLista(ArrayList<ListaSeleccionada> listaSeleccionada, Context context) {
        this.listaSeleccionada = listaSeleccionada;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaSeleccionada.size();
    }

    @Override
    public Object getItem(int position) {
        return listaSeleccionada.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.lista_layout,parent,false);
        ListaSeleccionada listaActual = listaSeleccionada.get(position);

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView textoNombre = convertView.findViewById(R.id.text_lista_nombre);
        TextView textoCategoria = convertView.findViewById(R.id.text_lista_categoria);

        imageView.setImageResource(listaActual.getImagen());
        textoNombre.setText(listaActual.getNombre());
        textoCategoria.setText(listaActual.getCategoria());

        return convertView;
    }
}
