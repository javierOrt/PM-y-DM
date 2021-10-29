package com.example.t03_inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNombre,editApellido,editTelefono;
    private CheckBox checkExperience;
    private Button botonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        instancias();
        acciones();
    }

    private void acciones() {
        botonRegistrar.setOnClickListener(this);
    }

    private void instancias() {
        editApellido = findViewById(R.id.edit_apellidos);
        editNombre = findViewById(R.id.edit_nombre);
        editTelefono = findViewById(R.id.edit_telefono);
        checkExperience = findViewById(R.id.check_experiencia);
        botonRegistrar = findViewById(R.id.botonRegistrar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonRegistrar:

                String nombre,apellido;
                int telefono;
                boolean experiencia;

                if (!editNombre.getText().toString().isEmpty() && !editApellido.getText().toString().isEmpty() && !editTelefono.getText().toString().isEmpty()){

                    nombre = editNombre.getText().toString();
                    apellido = editApellido.getText().toString();
                    telefono = Integer.parseInt(editTelefono.getText().toString());
                    experiencia = checkExperience.isChecked();


                    Intent intent = new Intent(getApplicationContext(), FordActivity.class);

                    intent.putExtra("nombre",nombre);
                    intent.putExtra("apellido",apellido);
                    intent.putExtra("telefono",telefono);
                    intent.putExtra("experiencia",experiencia);

                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Falta un dato", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}