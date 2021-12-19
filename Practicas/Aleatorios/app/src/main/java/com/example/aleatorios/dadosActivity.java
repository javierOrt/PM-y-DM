package com.example.aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class dadosActivity extends AppCompatActivity {

    Button btnDado;
    ImageView imageDado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        instancias();
        acciones();
    }

    private void acciones() {
        btnDado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int numAleatorio=(int)Math.floor(Math.random()*(5+1));

                if (numAleatorio==0){
                    imageDado.setImageResource(R.drawable.dado_uno);
                } else if (numAleatorio==1){
                    imageDado.setImageResource(R.drawable.dado_dos);
                }else if (numAleatorio==2){
                    imageDado.setImageResource(R.drawable.dado_tres);
                }else if (numAleatorio==3){
                    imageDado.setImageResource(R.drawable.dado_cuatro);
                }else if (numAleatorio==4){
                    imageDado.setImageResource(R.drawable.dado_cinco);
                }else if (numAleatorio==5){
                    imageDado.setImageResource(R.drawable.dado_seis);
                }
            }
        });
    }

    private void instancias() {
        btnDado = findViewById(R.id.btn_dado);
        imageDado = findViewById(R.id.image_dado);
    }
}