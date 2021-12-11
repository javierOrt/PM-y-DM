package com.example.javierortiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instancias();
    }

    private void instancias() {

    }
}

/*
package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.listas.utils.Marcas;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Observable;

public class listasActivity extends AppCompatActivity {

    private Spinner spinnerMarcas;
    private ImageView imagenMarcas;
    private ArrayAdapter adapterSpinner;
    private ArrayList<Marcas> listaOpcionesSpinner;

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
        spinnerMarcas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), adapterSpinner.getItem(position).toString(), Toast.LENGTH_SHORT).show();
                Marcas marcaSeleccionada = (Marcas) adapterSpinner.getItem(position);
                imagenMarcas.setImageResource(marcaSeleccionada.getImagen());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void rellenarListas() {
        listaOpcionesSpinner.add(new Marcas("mercedes",R.drawable.mercedes));
        listaOpcionesSpinner.add(new Marcas("audi",R.drawable.audi));
        listaOpcionesSpinner.add(new Marcas("bmw",R.drawable.bmw));
        listaOpcionesSpinner.add(new Marcas("vw",R.drawable.vw));
        adapterSpinner.notifyDataSetChanged();
    }

    private void asociarElementos() {
        spinnerMarcas.setAdapter(adapterSpinner);
    }

    private void instancias() {
        spinnerMarcas = this.findViewById(R.id.spinner_marcas);
        listaOpcionesSpinner = new ArrayList();
        adapterSpinner = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,listaOpcionesSpinner);
        imagenMarcas = findViewById(R.id.imagen_marcas);
    }
}

 */
/*
package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.listas.utils.Marcas;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Observable;

public class listasActivity extends AppCompatActivity {

    private Spinner spinnerMarcas;
    private ImageView imagenMarcas;
    private ArrayAdapter adapterSpinner;
    private ArrayList<Marcas> listaOpcionesSpinner;

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
        spinnerMarcas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), adapterSpinner.getItem(position).toString(), Toast.LENGTH_SHORT).show();
                Marcas marcaSeleccionada = (Marcas) adapterSpinner.getItem(position);
                imagenMarcas.setImageResource(marcaSeleccionada.getImagen());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void rellenarListas() {
        listaOpcionesSpinner.add(new Marcas("mercedes",R.drawable.mercedes));
        listaOpcionesSpinner.add(new Marcas("audi",R.drawable.audi));
        listaOpcionesSpinner.add(new Marcas("bmw",R.drawable.bmw));
        listaOpcionesSpinner.add(new Marcas("vw",R.drawable.vw));
        adapterSpinner.notifyDataSetChanged();
    }

    private void asociarElementos() {
        spinnerMarcas.setAdapter(adapterSpinner);
    }

    private void instancias() {
        spinnerMarcas = this.findViewById(R.id.spinner_marcas);
        listaOpcionesSpinner = new ArrayList();
        adapterSpinner = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,listaOpcionesSpinner);
        imagenMarcas = findViewById(R.id.imagen_marcas);
    }
}

 */