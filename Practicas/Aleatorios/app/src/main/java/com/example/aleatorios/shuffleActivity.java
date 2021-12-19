package com.example.aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class shuffleActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioOpciones;

    private EditText editTextMin,editTextMax,editTextDecimales,editTextEnteros;

    private TextView textViewNumeroAleatorio;

    private CheckBox checkBoxDecimales;

    private Switch switchRepetir;

    private Button buttonLanzar;

    private int min,max,numeroEnteros;
    private double numeroDecimales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuffle);

        instancias();
        acciones();
    }

    private void acciones() {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioOpciones = findViewById(checkedId);
            }
        });


        buttonLanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numeroEnteros = Integer.parseInt(editTextEnteros.getText().toString());

                if (editTextMin != null && editTextMax != null && radioOpciones.getId()==R.id.radioConRango){

                    min = Integer.parseInt(editTextMin.getText().toString());
                    max = Integer.parseInt(editTextMax.getText().toString());
                }

                if (checkBoxDecimales.isChecked() && editTextDecimales==null){

                    Toast.makeText(getApplicationContext(),"Introduzca un numero de decimales",Toast.LENGTH_SHORT).show();
                }

                if (checkBoxDecimales.isChecked() && editTextDecimales!=null && radioOpciones.getId()==R.id.radioConRango){

                    numeroDecimales = Double.parseDouble(editTextDecimales.getText().toString());
                    double numAleatorio;
                    double redondear = 1;

                    for (int j = 0; j < numeroDecimales; j++) {
                        redondear = redondear * 10.0;
                    }

                    for (int i = 0; i < numeroEnteros; i++) {

                        numAleatorio=Math.random()*(min-(max+1))+(max);

                        numAleatorio = Math.round(numAleatorio*redondear)/redondear;

                        textViewNumeroAleatorio.append(String.valueOf(numAleatorio));
                        textViewNumeroAleatorio.append("-");
                    }
                }

                if(!checkBoxDecimales.isChecked() && radioOpciones.getId()==R.id.radioConRango){

                    int numAleatorio;

                    for (int i = 0; i < numeroEnteros; i++) {

                        numAleatorio=(int)Math.floor(Math.random()*(min-(max+1))+(max));

                        textViewNumeroAleatorio.append(String.valueOf(numAleatorio));
                        textViewNumeroAleatorio.append("-");
                    }
                }

                if(!checkBoxDecimales.isChecked() && radioOpciones.getId()==R.id.radioSinRango){

                    int numAleatorio;

                    for (int i = 0; i < numeroEnteros; i++) {

                        numAleatorio=(int)Math.floor(Math.random()*(1-(100+1))+(100));

                        textViewNumeroAleatorio.append(String.valueOf(numAleatorio));
                        textViewNumeroAleatorio.append("-");
                    }
                }

                if(checkBoxDecimales.isChecked() && radioOpciones.getId()==R.id.radioSinRango && editTextDecimales!=null){

                    numeroDecimales = Double.parseDouble(editTextDecimales.getText().toString());

                    double redondear = 1;
                    double numAleatorio = 0;

                    for (int j = 0; j < numeroDecimales; j++) {
                        redondear = redondear * 10.0;
                    }

                    for (int i = 0; i < numeroEnteros; i++) {

                        numAleatorio=Math.random()*100;

                        numAleatorio = Math.round(numAleatorio*redondear)/redondear;

                        textViewNumeroAleatorio.append(String.valueOf(numAleatorio));
                        textViewNumeroAleatorio.append("-");
                    }
                }
            }
        });
    }

    private void instancias() {

        radioGroup = findViewById(R.id.radioGroup);
        editTextMin = findViewById(R.id.editText_minimo);
        editTextMax = findViewById(R.id.editText_maximo);
        editTextDecimales = findViewById(R.id.editText_numeroDecimales);
        editTextEnteros = findViewById(R.id.editText_numeroEnteros);
        textViewNumeroAleatorio = findViewById(R.id.text_numerosAleatorios);
        checkBoxDecimales = findViewById(R.id.checkbox_decimales);
        switchRepetir = findViewById(R.id.switchRepetir);
        buttonLanzar = findViewById(R.id.btn_lanzar);
    }
}