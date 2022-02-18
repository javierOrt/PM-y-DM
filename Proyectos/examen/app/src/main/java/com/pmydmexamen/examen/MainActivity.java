package com.pmydmexamen.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.window.SplashScreen;
import android.window.SplashScreenView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnRecyclerContactoListener {

    private RecyclerView recyclerView;
    private AdaptadorRecycler adaptadorRecycler;
    private ArrayList<Jugador> jugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarListas();
        asociarElementos();
    }

    private void asociarElementos() {
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    private void rellenarListas() {
        jugador.add(new Jugador(R.drawable.vision, "Mr. Vision", "Psicopoderes", "Alemania"));
        jugador.add(new Jugador(R.drawable.blanka, "Blanka", "Electricidad", "Brasil"));
        jugador.add(new Jugador(R.drawable.chunli, "Chun Li", "Karate", "China"));
        jugador.add(new Jugador(R.drawable.dalsim, "Dalsim", "Elasticidad", "India"));
        jugador.add(new Jugador(R.drawable.guile, "Guille", "Boomerang", "EEUU"));
        jugador.add(new Jugador(R.drawable.honda, "Honda", "Sumo", "Japón"));
        jugador.add(new Jugador(R.drawable.ken, "Key", "Judo", "Japon"));
        jugador.add(new Jugador(R.drawable.ryu, "Ryu", "Karate", "Japón"));
        jugador.add(new Jugador(R.drawable.vega, "Vega", "Garras", "España"));
        jugador.add(new Jugador(R.drawable.zang, "Zangief", "Fuerza", "Rusia"));
    }

    private void instancias() {
        jugador = new ArrayList<>();
        recyclerView = findViewById(R.id.reclycler);
        adaptadorRecycler = new AdaptadorRecycler(jugador,MainActivity.this);
    }

    @Override
    public void onJugadorSelected(Jugador jugador) {

        Intent intent = new Intent();
        intent = new Intent(getApplicationContext(),PerfilActivity.class);
        intent.putExtra("Imagen",jugador.getImagen());
        intent.putExtra("Nombre",jugador.getNombre());
        intent.putExtra("Habilidad",jugador.getHabilidad());
        startActivity(intent);
    }
}