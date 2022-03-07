package com.example.proyectojson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.proyectojson.utils.Equipo;

public class MainActivity2 extends AppCompatActivity {

    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imagen = findViewById(R.id.iamgen_selecionada);

        if (getIntent().getExtras() != null){
            Equipo equipo = (Equipo) getIntent().getExtras().getSerializable("equipo");
            Glide.with(getApplicationContext()).load(equipo.getEscudo()).into(imagen);
        }
    }
}