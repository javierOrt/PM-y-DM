package com.example.configuraciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button boton1,boton2,boton3,boton4,boton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();

        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            accionesland();
        }
    }

    private void accionesland() {
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
        boton4.setOnClickListener(this);
        boton5.setOnClickListener(this);

    }

    private void acciones() {
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
        boton4.setOnClickListener(this);
    }

    private void instancias() {
        boton1 = findViewById(R.id.pulsar1);
        boton2 = findViewById(R.id.pulsar2);
        boton3 = findViewById(R.id.pulsar3);
        boton4 = findViewById(R.id.pulsar4);
        boton5 = findViewById(R.id.pulsar5);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pulsar1:
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.text_toast),Toast.LENGTH_SHORT).show();
                break;
            case R.id.pulsar2:
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.text_toast),Toast.LENGTH_SHORT).show();
                break;
            case R.id.pulsar3:
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.text_toast),Toast.LENGTH_SHORT).show();
                break;
            case R.id.pulsar4:
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.text_toast),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}