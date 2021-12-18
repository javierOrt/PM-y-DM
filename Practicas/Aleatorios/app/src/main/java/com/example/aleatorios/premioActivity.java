package com.example.aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Observable;

public class premioActivity extends AppCompatActivity {

    private EditText editText;
    private Button btnGanador,btnJugador;
    private TextView textViewJugadores,textViewGanador;
    private ArrayList<String> listJugadores;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premio);

        instancias();
        acciones();
    }

    private void acciones() {

        btnJugador.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                listJugadores.add(editText.getText().toString());
                textViewJugadores.append(listJugadores.get(contador)+"\n");
                contador++;

            }
        });

        btnGanador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numAleatorio=(int)Math.floor(Math.random()*(contador+1));
                textViewGanador.setText(listJugadores.get(numAleatorio));
            }
        });
    }

    private void instancias() {

        editText = findViewById(R.id.editText_nuevoJugador);
        btnGanador = findViewById(R.id.btn_ganador);
        btnJugador = findViewById(R.id.btn_jugador);
        textViewJugadores = findViewById(R.id.textView_jugadores);
        textViewGanador = findViewById(R.id.textView_ganador);
        listJugadores = new ArrayList<>();
    }
}