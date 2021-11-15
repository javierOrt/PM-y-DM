package com.example.javierortizfeliz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editOperando1, editOperando2;
    private Button botonSumar,botonRestar,botonMultiplicar,botonDividir,botonModulo,botonResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void instancias() {
        editOperando1 = findViewById(R.id.edit_operando1);
        editOperando2 = findViewById(R.id.edit_operando2);
        botonSumar = findViewById(R.id.boton_sumar);
        botonRestar = findViewById(R.id.boton_restar);
        botonMultiplicar = findViewById(R.id.boton_multiplicar);
        botonDividir = findViewById(R.id.boton_dividir);
        botonModulo = findViewById(R.id.boton_modulo);
        botonResultado = findViewById(R.id.boton_resultado);
    }

    private void acciones() {
        botonSumar.setOnClickListener(this);
        botonRestar.setOnClickListener(this);
        botonMultiplicar.setOnClickListener(this);
        botonDividir.setOnClickListener(this);
        botonModulo.setOnClickListener(this);
        botonResultado.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        int suma,resta,multiplicacion,division,modulo,resultado;

        switch (v.getId()){

            case R.id.boton_sumar:

                if (!editOperando1.getText().toString().isEmpty()
                        || !editOperando2.getText().toString().isEmpty()) {

                    suma = Integer.parseInt(editOperando1.getText().toString())+Integer.parseInt(editOperando2.getText().toString());

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Faltan Operandos",Toast.LENGTH_SHORT).show();
                }
            case R.id.boton_restar:

                if (!editOperando1.getText().toString().isEmpty()
                        || !editOperando2.getText().toString().isEmpty()) {

                    resta = Integer.parseInt(editOperando1.getText().toString())-Integer.parseInt(editOperando2.getText().toString());

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Faltan Operandos",Toast.LENGTH_SHORT).show();
                }
            case R.id.boton_multiplicar:

                if (!editOperando1.getText().toString().isEmpty()
                        || !editOperando2.getText().toString().isEmpty()) {

                    multiplicacion = Integer.parseInt(editOperando1.getText().toString())*Integer.parseInt(editOperando2.getText().toString());

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Faltan Operandos",Toast.LENGTH_SHORT).show();
                }
            case R.id.boton_dividir:

                if (!editOperando1.getText().toString().isEmpty()
                        || !editOperando2.getText().toString().isEmpty()) {

                    division = Integer.parseInt(editOperando1.getText().toString())/Integer.parseInt(editOperando2.getText().toString());

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Faltan Operandos",Toast.LENGTH_SHORT).show();
                }
            case R.id.boton_modulo:

                if (!editOperando1.getText().toString().isEmpty()
                        || !editOperando2.getText().toString().isEmpty()) {

                    modulo = Integer.parseInt(editOperando1.getText().toString())%Integer.parseInt(editOperando2.getText().toString());

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Faltan Operandos",Toast.LENGTH_SHORT).show();
                }
            case R.id.boton_resultado:

                if (!editOperando1.getText().toString().isEmpty()
                        || !editOperando2.getText().toString().isEmpty()) {

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Faltan Operandos",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}