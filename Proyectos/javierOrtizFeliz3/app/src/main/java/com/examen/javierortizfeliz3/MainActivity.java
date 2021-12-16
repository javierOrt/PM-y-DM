package com.examen.javierortizfeliz3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instancias();
        acciones();
    }

    private void acciones() {
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ListasActivity.class);
                startActivity(intent);
            }
        });
    }

    private void instancias() {
        btnIniciar = findViewById(R.id.btn_iniciar);
    }
}