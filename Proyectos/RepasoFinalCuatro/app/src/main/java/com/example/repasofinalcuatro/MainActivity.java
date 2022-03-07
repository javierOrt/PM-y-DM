package com.example.repasofinalcuatro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.repasofinalcuatro.Adaptadores.AdaptadorComida;
import com.example.repasofinalcuatro.Adaptadores.AdaptadorInicio;
import com.example.repasofinalcuatro.Fragments.FragmentComida;
import com.example.repasofinalcuatro.Fragments.FragmentInicio;
import com.example.repasofinalcuatro.utils.Categorias;
import com.example.repasofinalcuatro.utils.Comida;

public class MainActivity extends AppCompatActivity implements AdaptadorInicio.OnCategoriaListener, AdaptadorComida.OnComidaListener {
    
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sitio_fragment,new FragmentInicio(),"inicio");

        fragmentTransaction.addToBackStack("inicio");
        fragmentTransaction.commit();

    }

    @Override
    public void onCategoriaSelecionada(String nombreCategorias) {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.sitio_fragment,FragmentComida.newInstance(nombreCategorias));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();



    }

    @Override
    public void onComidaSelecionada(Comida comida) {



    }
}