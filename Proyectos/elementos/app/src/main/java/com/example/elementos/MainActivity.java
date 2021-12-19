package com.example.elementos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ToggleButton toggle;
    private TextView textoToggle,textoCheck,textoRadios;
    private Button comprobar;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private RadioButton radioOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instancias();
        acciones();
    }

    private void acciones() {

        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoToggle.setText(String.valueOf(toggle.isChecked()));
                textoCheck.setText(String.valueOf(checkBox.isChecked()));
                radioOpciones = findViewById(radioGroup.getCheckedRadioButtonId());
                if (radioOpciones != null) {
                    textoRadios.setText(String.valueOf(radioOpciones.getText()));
                }
            }
        });

        toggle.setOnCheckedChangeListener(this);
        checkBox.setOnCheckedChangeListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioOpciones = findViewById(checkedId);
                textoRadios.setText(radioOpciones.getText());
            }
        });
    }

    private void instancias() {
        toggle = findViewById(R.id.toggle);
        textoToggle = findViewById(R.id.text_toggle);
        comprobar = findViewById(R.id.boton_comprobar);
        checkBox = findViewById(R.id.checkbox);
        textoCheck = findViewById(R.id.text_checkbox);
        textoRadios = findViewById(R.id.text_radios);
        radioGroup = findViewById(R.id.radioGroup);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {
            case R.id.toggle:
                textoToggle.setText(String.valueOf(isChecked));
                break;
            case R.id.checkbox:
                textoCheck.setText(String.valueOf(isChecked));
                break;
        }
    }
}