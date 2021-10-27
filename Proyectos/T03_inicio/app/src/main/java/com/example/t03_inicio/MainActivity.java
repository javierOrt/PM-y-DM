package com.example.t03_inicio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button saludar, saludar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        saludar.setOnClickListener(this);
        saludar2.setOnClickListener(this);

    }

    private void instancias() {
        saludar = findViewById(R.id.boton_saludar);
        saludar2 = findViewById(R.id.boton_saludar_2);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.boton_saludar:
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.text_click_b1), Toast.LENGTH_SHORT).show();
                break;
            case R.id.boton_saludar_2:
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.text_click_b2), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}