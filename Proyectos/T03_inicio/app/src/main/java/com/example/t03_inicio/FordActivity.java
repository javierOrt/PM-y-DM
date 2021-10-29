package com.example.t03_inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class FordActivity extends AppCompatActivity {

    private TextView textApellido,textNombre,textTelefono;
    //private CheckBox textCheckExperience;
    String nombre,apellido;
    int telefono;
    boolean experiencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ford);
        if (getIntent().getExtras() != null){
            recuperarDatos();
            instancias();
            acciones();
        }
    }

    private void acciones() {
        textNombre.setText(nombre);
        textApellido.setText(apellido);
    }

    private void instancias() {
            textNombre = findViewById(R.id.datosNombre);
            textApellido = findViewById(R.id.datosApellido);
            textTelefono = findViewById(R.id.datosTelefono);
            //textCheckExperience = findViewById(R.id.datosCheck);
    }

    private void recuperarDatos() {
        nombre = getIntent().getExtras().getString("nombre","");
        apellido = getIntent().getExtras().getString("apellido","");
        telefono = getIntent().getExtras().getInt("telefono",0);
        experiencia = getIntent().getExtras().getBoolean("experiencia",false);
    }
}