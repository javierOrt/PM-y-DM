package com.repasoexamen.repasoexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorReclycler.OnRecyclerContactoListener {

    private RecyclerView recyclerView;
    private AdaptadorReclycler adaptadorReclycler;
    private ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<>();
        contactos.add(new Contacto("javi", "ortiz", "galapagar", 666, 0));
        contactos.add(new Contacto("jav", "orti", "galapaga", 66, 0));
        contactos.add(new Contacto("ja", "ort", "galapag", 6, 0));
        recyclerView = findViewById(R.id.reclycler);
        adaptadorReclycler = new AdaptadorReclycler(contactos,MainActivity.this);
        recyclerView.setAdapter(adaptadorReclycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onContactoSelected(Contacto contacto) {
        Toast.makeText(getApplicationContext(),contacto.getNombre(),Toast.LENGTH_SHORT).show();
    }
}