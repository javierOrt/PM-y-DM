package com.example.t03_inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.t03_inicio.utils.Persona;

public class FordActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView recuperarNombre;
    private TextView recuperarApellido;
    private TextView recuperarTelefono;
    private CheckBox recuperarExperiencia;
    /*
    private String nombre, apellido;
    private int telefono;
    private boolean experiencia;
     */
    private Persona personaRecuperada;
    private Button botonContestar;

    /*
        1.)Crear XML y le doy las IDs a los elementos
        2.)En la parte lógica creo tantas variables como elementos ID tenga en la parte gráfica
        3.)Todos los elementos creados en el punto anterior los instancio con el findViewById(R.Id.el:Id:del:punto:anterior)
        4.)Configuro las acciones
            a)Implemento en la clase la accion que voy a manejar
            b)En un metodo acciones asocio la variable con el listener correspondiente "this"
            c)Manejo las acciones creadas en el metodo Implementacion
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ford);
        instancias();
        if(getIntent().getExtras() != null){
            recuperarDatos();
            setearDatos();
        }
        acciones();
    }

    private void acciones() {
        botonContestar.setOnClickListener(this);
    }

    private void setearDatos() {
        recuperarNombre.setText(personaRecuperada.getNombre());
        recuperarApellido.setText(personaRecuperada.getApellido());
        recuperarTelefono.setText(String.valueOf(personaRecuperada.getTelefono()));
        recuperarExperiencia.setChecked(personaRecuperada.isExperiencia());
    }

    private void instancias() {
        recuperarNombre = findViewById(R.id.recuperar_nombre);
        recuperarApellido = findViewById(R.id.recuperar_apellido);
        recuperarTelefono = findViewById(R.id.recuperar_telefono);
        recuperarExperiencia = findViewById(R.id.recuperar_experiencia);
        botonContestar = findViewById(R.id.boton_contestar);
    }


    private void recuperarDatos() {
        /*nombre = getIntent().getExtras().getString("nombre");
        apellido = getIntent().getExtras().getString("apellido");
        telefono = getIntent().getExtras().getInt("telefono");
        experiencia = getIntent().getExtras().getBoolean("experiencia");*/
        personaRecuperada = (Persona) getIntent().getExtras().getSerializable("persona");
        /*Log.v("test", nombre);
        Log.v("test", apellido);*/
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        personaRecuperada.setApellido(personaRecuperada.getApellido());
        intent.putExtra("persona", personaRecuperada);
        if(recuperarExperiencia.isChecked())
            setResult(1, intent);
        else
            setResult(0, intent);
        finish();
    }
}