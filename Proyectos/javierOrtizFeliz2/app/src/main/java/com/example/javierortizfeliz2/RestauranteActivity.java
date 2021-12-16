package com.example.javierortizfeliz2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.javierortizfeliz2.Adapters.AdaptadorRestaurante;
import com.example.javierortizfeliz2.utils.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class RestauranteActivity extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Restaurante> listaRestaurantesMostrados,listaRestaurante;
    private AdaptadorRestaurante adaptadorLista;
    private String tipo,localidad;
    private int puntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);
        instancias();
        if (getIntent().getExtras() != null ){
            recuperarDatos();
        }
        rellenarListas();
        asociarElementos();
    }

    private void recuperarDatos() {
        tipo = getIntent().getExtras().getString("tipo");
        localidad = getIntent().getExtras().getString("localidad");
        puntuacion = getIntent().getExtras().getInt("puntuacion");
    }

    private void rellenarListas() {
        listaRestaurante.add(new Restaurante("Italiano1","Madrid",5,"Italiano",9111));
        listaRestaurante.add(new Restaurante("Italiano2","Alcobendas",7,"Italiano",9222));
        listaRestaurante.add(new Restaurante("Italiano3","Pozuelo",9,"Italiano",9333));
        listaRestaurante.add(new Restaurante("Italiano4","Majadahonda",3,"Italiano",9444));
        listaRestaurante.add(new Restaurante("Italiano5","Madrid",5,"Italiano",9555));
        listaRestaurante.add(new Restaurante("Mediterraneo1","Madrid",6,"Mediterranea",9666));
        listaRestaurante.add(new Restaurante("Mediterraneo2","Alcobendas",7,"Mediterranea",9777));
        listaRestaurante.add(new Restaurante("Mediterraneo3","Pozuelo",5,"Mediterranea",9123));
        listaRestaurante.add(new Restaurante("Mediterraneo4","Majadahonda",2,"Mediterranea",9234));
        listaRestaurante.add(new Restaurante("Chino1","Madrid",5,"Chino",9345));
        listaRestaurante.add(new Restaurante("Chino2","Alcobendas",5,"Chino",9456));
        listaRestaurante.add(new Restaurante("Chino3","Pozuelo",6,"Chino",9567));
        listaRestaurante.add(new Restaurante("Japones1","Alcorcón",10,"Japones",8123));
        listaRestaurante.add(new Restaurante("Japones2","Alcobendas",5,"Japones",7123));
        listaRestaurante.add(new Restaurante("Japones3","Alcorcón",6,"Japones",6234));

        for (Restaurante restaurante: listaRestaurante) {
            if (restaurante.getLocalidad().equals(localidad) &&
                    restaurante.getPuntuacion()== puntuacion && restaurante.getTipo_comida().equals(tipo)){

                listaRestaurantesMostrados.add(restaurante);
            } else if (tipo.equals("Todas") &&
                       restaurante.getLocalidad().equals(localidad) &&
                       restaurante.getPuntuacion()==puntuacion){

                listaRestaurantesMostrados.add(restaurante);
            }
        }
    }

    private void asociarElementos() {
        lista.setAdapter(adaptadorLista);
    }

    private void instancias() {
        lista = findViewById(R.id.lista_restaurantes);
        listaRestaurantesMostrados = new ArrayList<>();
        listaRestaurante = new ArrayList<>();
        adaptadorLista = new AdaptadorRestaurante(listaRestaurantesMostrados,getApplicationContext());
    }
}