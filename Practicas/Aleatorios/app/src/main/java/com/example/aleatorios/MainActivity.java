package com.example.aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton shuffle,dados,premio;

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

        Intent intent = new Intent();

        switch (v.getId()){
            case R.id.shuffle:
                intent = new Intent(getApplicationContext(),shuffleActivity.class);
                break;
            case R.id.dados:
                intent = new Intent(getApplicationContext(),dadosActivity.class);
                break;
            case R.id.premio:
                intent = new Intent(getApplicationContext(),premioActivity.class);
                break;
        }
        startActivity(intent);
    }
}