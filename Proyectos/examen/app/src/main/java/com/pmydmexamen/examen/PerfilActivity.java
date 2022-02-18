package com.pmydmexamen.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    private ImageView imagenPersonaje;
    private TextView textoNombre, textoHabilidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        instancias();
        if (getIntent().getExtras() != null) {
            imagenPersonaje.setImageResource(getIntent().getIntExtra("Imagen",0));
            textoNombre.setText(getIntent().getStringExtra("Nombre"));
            textoHabilidad.setText(getIntent().getStringExtra("Habilidad"));
        }
    }

    private void instancias() {
        imagenPersonaje = findViewById(R.id.imagen_jugador);
        textoNombre = findViewById(R.id.text_nombre_jugador);
        textoHabilidad = findViewById(R.id.text_habilidad_jugador);
    }
}