package com.example.javierortizfeliz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.javierortizfeliz2.utils.Restaurante;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerTipoComida,spinnerLocalidad,spinnerValoracion;
    private ArrayAdapter adapterSpinnerTipoComida,adapterSpinnerLocalidad,adapterSpinnerValoracion;
    private ArrayList<String> listaTipoComidaSpinner,listaLocalidadSpinner,listaValoracionSpinner;
    private ArrayList<Restaurante> lista;
    private Button btnResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instancias();
        rellenarListas();
        asociarElementos();
        acciones();
    }

    private void acciones() {

    }

    private void rellenarListas() {
        listaTipoComidaSpinner.add("China");
        listaTipoComidaSpinner.add("Japonesa");
        listaTipoComidaSpinner.add("Mediterranea");
        listaTipoComidaSpinner.add("Italiana");
        listaTipoComidaSpinner.add("Todas");

        listaLocalidadSpinner.add("Madrid");
        listaLocalidadSpinner.add("Alcobendas");
        listaLocalidadSpinner.add("Majadahonda");
        listaLocalidadSpinner.add("Pozuelo");
        listaLocalidadSpinner.add("Alcorcón");

        listaValoracionSpinner.add("1");
        listaValoracionSpinner.add("2");
        listaValoracionSpinner.add("3");
        listaValoracionSpinner.add("4");
        listaValoracionSpinner.add("5");
        listaValoracionSpinner.add("6");
        listaValoracionSpinner.add("7");
        listaValoracionSpinner.add("8");
        listaValoracionSpinner.add("9");
        listaValoracionSpinner.add("10");

        lista.add(new Restaurante("Italiano1","Madrid",4,"Italiano",9111));
        lista.add(new Restaurante("Italiano2","Alcobendas",7,"Italiano",9222));
        lista.add(new Restaurante("Italiano3","Pozuelo",9,"Italiano",9333));
        lista.add(new Restaurante("Italiano4","Majadahonda",3,"Italiano",9444));
        lista.add(new Restaurante("Italiano5","Madrid",9,"Italiano",9555));
        lista.add(new Restaurante("Mediterraneo1","Madrid",6,"Mediterranea",9666));
        lista.add(new Restaurante("Mediterraneo2","Alcobendas",7,"Mediterranea",9777));
        lista.add(new Restaurante("Mediterraneo3","Pozuelo",5,"Mediterranea",9123));
        lista.add(new Restaurante("Mediterraneo4","Majadahonda",2,"Mediterranea",9234));
        lista.add(new Restaurante("Chino1","Madrid",10,"Chino",9345));
        lista.add(new Restaurante("Chino2","Alcobendas",5,"Chino",9456));
        lista.add(new Restaurante("Chino3","Pozuelo",6,"Chino",9567));
        lista.add(new Restaurante("Japones1","Alcorcón",10,"Japones",8123));
        lista.add(new Restaurante("Japones2","Alcobendas",5,"Japones",7123));
        lista.add(new Restaurante("Japones3","Alcorcón",6,"Japones",6234));

        adapterSpinnerTipoComida.notifyDataSetChanged();
        adapterSpinnerLocalidad.notifyDataSetChanged();
        adapterSpinnerValoracion.notifyDataSetChanged();
    }

    private void asociarElementos() {
        spinnerTipoComida.setAdapter(adapterSpinnerTipoComida);
        spinnerLocalidad.setAdapter(adapterSpinnerLocalidad);
        spinnerValoracion.setAdapter(adapterSpinnerValoracion);
    }

    private void instancias() {
        spinnerTipoComida = findViewById(R.id.tipoComida_spinner);
        spinnerLocalidad = findViewById(R.id.localidad_spinner);
        spinnerValoracion = findViewById(R.id.valoracion_spinner);

        listaTipoComidaSpinner = new ArrayList<>();
        listaLocalidadSpinner = new ArrayList<>();
        listaValoracionSpinner = new ArrayList<>();
        lista = new ArrayList<>();

        adapterSpinnerTipoComida = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,listaTipoComidaSpinner);
        adapterSpinnerLocalidad = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,listaLocalidadSpinner);
        adapterSpinnerValoracion = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,listaValoracionSpinner);
    }
}