package com.example.repasofinaldos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.repasofinaldos.Adapters.AdaptadorCategorias;
import com.example.repasofinaldos.Adapters.AdaptadorComidas;
import com.example.repasofinaldos.Dialogos.DialogoComida;
import com.example.repasofinaldos.Dialogos.DialogoConfirmacion;
import com.example.repasofinaldos.Fragments.FragmentCategorias;
import com.example.repasofinaldos.Fragments.FragmentComidas;
import com.example.repasofinaldos.utils.Comidas;

public class MainActivity extends AppCompatActivity implements AdaptadorCategorias.OnCategoriaListener, AdaptadorComidas.OnComidaListener, DialogoConfirmacion.OnDialogoListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.sitio_fragments,new FragmentCategorias(),"inicio");
        fragmentTransaction.addToBackStack("inicio");
        fragmentTransaction.commit();
    }

    @Override
    public void onCategoriaSelecionada(String nombresCategorias) {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if (findViewById(R.id.sitio_detalle)!=null){
            fragmentTransaction.replace(R.id.sitio_detalle, FragmentComidas.newInstance(nombresCategorias),"comidas");

        }else{
            fragmentTransaction.replace(R.id.sitio_fragments, FragmentComidas.newInstance(nombresCategorias),"comidas");

        }


        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void onComidaSelected(Comidas comida) {

        fragmentManager = getSupportFragmentManager();

        DialogoConfirmacion dialogoConfirmacion = DialogoConfirmacion.newInstance(comida);
        dialogoConfirmacion.show(fragmentManager,"dialogoconfirmacion");

    }

    @Override
    public void onDialogoSelected(Comidas comidas) {

        fragmentManager = getSupportFragmentManager();

        DialogoComida dialogoComida = DialogoComida.newInstance(comidas);
        dialogoComida.show(fragmentManager,"dialogoComida");

    }
}