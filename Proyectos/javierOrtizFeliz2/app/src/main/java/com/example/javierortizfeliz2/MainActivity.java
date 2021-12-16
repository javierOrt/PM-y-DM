package com.example.javierortizfeliz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnResultados;
    private Spinner spinnerComida, spinnerPuntuacion, spinnerLocalidad;
    private ArrayList<String> arrayComida, arrayPuntuacion, arrayLocalidad;
    private ArrayAdapter adapterComida, adapterPuntuacion, adapterLocalidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarListas();
        iniciarElementos();
        acciones();
    }

    private void acciones() {
        btnResultados.setOnClickListener(this);
    }

    private void iniciarElementos() {
        spinnerComida.setAdapter(adapterComida);
        spinnerPuntuacion.setAdapter(adapterPuntuacion);
        spinnerLocalidad.setAdapter(adapterLocalidad);

    }

    private void instancias() {
        btnResultados = findViewById(R.id.btn_resultados);

        spinnerComida = findViewById(R.id.spinner_comida);
        spinnerLocalidad = findViewById(R.id.spinner_localidad);
        spinnerPuntuacion = findViewById(R.id.spinner_puntuacion);

        arrayComida = new ArrayList<>();
        arrayPuntuacion = new ArrayList<>();
        arrayLocalidad = new ArrayList<>();

        adapterComida = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, arrayComida);
        adapterPuntuacion = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, arrayPuntuacion);
        adapterLocalidad = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, arrayLocalidad);
    }

    private void rellenarListas() {
        arrayComida.add("Chino");
        arrayComida.add("Japones");
        arrayComida.add("Mediterranea");
        arrayComida.add("Italiano");
        arrayComida.add("Todas");

        arrayLocalidad.add("Madrid");
        arrayLocalidad.add("Alcobendas");
        arrayLocalidad.add("Majadahonda");
        arrayLocalidad.add("Pozuelo");
        arrayLocalidad.add("Alcorcon");

        for (int i = 1; i < 11; i++) {
            arrayPuntuacion.add(String.valueOf(i));
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(),RestauranteActivity.class);
        intent.putExtra("tipo",adapterComida.getItem(spinnerComida.getSelectedItemPosition()).toString());
        intent.putExtra("localidad",adapterLocalidad.getItem(spinnerLocalidad.getSelectedItemPosition()).toString());
        intent.putExtra("puntuacion",Integer.parseInt(adapterPuntuacion.
                getItem(spinnerPuntuacion.getSelectedItemPosition()).toString()));

        startActivity(intent);
    }
}