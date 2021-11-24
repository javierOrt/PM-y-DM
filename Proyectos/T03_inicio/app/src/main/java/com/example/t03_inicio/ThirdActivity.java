package com.example.t03_inicio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.t03_inicio.utils.Persona;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editNombre, editApellido, editTelefono;
    private CheckBox checkExperiencia;
    private Button botonRegistro;
    private ImageView imagenExperiecia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        instancias();
        acciones();
    }

    private void acciones() {
        botonRegistro.setOnClickListener(this);
    }

    private void instancias() {
        editApellido = findViewById(R.id.edit_apellido_registro);
        editNombre = findViewById(R.id.edit_nombre_registro);
        editTelefono = findViewById(R.id.edit_telefono_registro);
        checkExperiencia = findViewById(R.id.check_experiencia);
        botonRegistro = findViewById(R.id.boton_registrar);
        imagenExperiecia = findViewById(R.id.imagen_experiencia);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.boton_registrar) {
            String nombre, apellido;
            int telefono;
            boolean experiencia;
            if (!(editNombre.getText().toString().isEmpty() && editApellido.getText().toString().isEmpty() && editTelefono.getText().toString().isEmpty())) {
                nombre = editNombre.getText().toString();
                apellido = editApellido.getText().toString();
                telefono = Integer.parseInt(editTelefono.getText().toString());
                experiencia = checkExperiencia.isChecked();

                //Toast.makeText(getApplicationContext(), nombre + " " + apellido + " " + telefono + " " + experiencia, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),FordActivity.class);

                    /*intent.putExtra("nombre",nombre);
                    intent.putExtra("apellido",apellido);
                    intent.putExtra("telefono",telefono);
                    intent.putExtra("experiencia",experiencia);*/

                intent.putExtra("persona", new Persona(nombre, apellido, telefono, experiencia));

                //startActivity(intent);
                if (experiencia)
                    startActivityForResult(intent, 1);
                else
                    startActivityForResult(intent, 0);
                //finish();
            } else {
                Toast.makeText(getApplicationContext(), "Falta algun campo por rellenar", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*if(requestCode == 1)
        {
            Persona recuperada = (Persona)data.getExtras().getSerializable("persona");
            Log.v("test", recuperada.getApellido());
        }
        else
        {
            Log.v("test", "No tienes Experiencia");
        }*/
        if(resultCode==0){
            imagenExperiecia.setImageResource(R.drawable.sinex);
        }
        else if(resultCode==1){
            imagenExperiecia.setImageResource(R.drawable.conex);
        }
    }
}