package com.examen.javierortizfeliz3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.examen.javierortizfeliz3.adapters.AdapterLista;
import com.examen.javierortizfeliz3.utils.ListaSeleccionada;

import java.util.ArrayList;

public class ListasActivity extends AppCompatActivity {

    private Spinner spinner;
    private ListView listTipo;

    private ArrayList<String> arrayTipo;
    private ArrayList<ListaSeleccionada> listaElementosSeleccionados;
    private ArrayAdapter adapterTipo;
    private ArrayList<ListaSeleccionada> listaElementos;
    private AdapterLista adapterLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        instancias();
        rellenarListas();
        asociarElementos();
        acciones();
    }

    private void acciones() {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                listaElementosSeleccionados.clear();

                for (ListaSeleccionada listaSeleccionada: listaElementos) {

                    if (adapterTipo.getItem(position).toString().equals(listaSeleccionada.getTipo())) {

                        listaElementosSeleccionados.add(listaSeleccionada);
                        adapterLista.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void asociarElementos() {
        spinner.setAdapter(adapterTipo);
        listTipo.setAdapter(adapterLista);
    }

    private void rellenarListas() {
        arrayTipo.add("Fútbol");
        arrayTipo.add("Juegos");
        arrayTipo.add("Series");

        listaElementos.add(new ListaSeleccionada("Romario", "FC. Barcelona", R.drawable.romario,"Fútbol"));
        listaElementos.add(new ListaSeleccionada("Ronaldo", "Brasil", R.drawable.ronaldo,"Fútbol"));
        listaElementos.add(new ListaSeleccionada("Maradona", "Argentina", R.drawable.maradona,"Fútbol"));
        listaElementos.add(new ListaSeleccionada("Zidane", "Francia", R.drawable.zidane,"Fútbol"));
        listaElementos.add(new ListaSeleccionada("Metal Gear", "Sigilo", R.drawable.metal,"Juegos"));
        listaElementos.add(new ListaSeleccionada("Gran Turismo", "Coches", R.drawable.gt,"Juegos"));
        listaElementos.add(new ListaSeleccionada("God Of War", "Plataformas", R.drawable.god,"Juegos"));
        listaElementos.add(new ListaSeleccionada("Final Fantasy X", "Rol", R.drawable.ffx,"Juegos"));
        listaElementos.add(new ListaSeleccionada("Stranger Things", "Fantastica", R.drawable.stranger,"Series"));
        listaElementos.add(new ListaSeleccionada("Juego de tronos", "Histórica", R.drawable.tronos,"Series"));
        listaElementos.add(new ListaSeleccionada("Lost", "Fantastica", R.drawable.lost,"series"));
        listaElementos.add(new ListaSeleccionada("La casa de papel", "Accion", R.drawable.papel,"Series"));

    }

    private void instancias() {
        spinner = findViewById(R.id.spinner);
        listTipo = findViewById(R.id.list_tipo);
        listaElementos = new ArrayList<>();
        listaElementosSeleccionados = new ArrayList<>();
        arrayTipo = new ArrayList<>();
        adapterTipo = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, arrayTipo);
        adapterLista = new AdapterLista(listaElementosSeleccionados,getApplicationContext());
    }
}