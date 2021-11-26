package com.example.aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton shuffle,dados,premio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instanccias();
        acciones();
    }

    private void acciones() {
        shuffle.setOnClickListener(this);
        dados.setOnClickListener(this);
        premio.setOnClickListener(this);
    }

    private void instanccias() {
        shuffle = findViewById(R.id.shuffle);
        dados = findViewById(R.id.dados);
        premio = findViewById(R.id.premio);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shuffle:
                Intent intentShuffle = new Intent(getApplicationContext(),shuffleActivity.class);
                break;
            case R.id.dados:
                Intent intentDados = new Intent(getApplicationContext(),dadosActivity.class);
                break;
            case R.id.premio:
                Intent intentPremio = new Intent(getApplicationContext(),premioActivity.class);
                break;
        }
    }
}