package com.example.repasofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.repasofinal.Adapters.AdaptadorEquipos;
import com.example.repasofinal.Adapters.AdaptadorRecycler;
import com.example.repasofinal.Dialogos.DialogoEquipo;
import com.example.repasofinal.Fragments.FragmentEquipo;
import com.example.repasofinal.Fragments.FragmentInicio;
import com.example.repasofinal.utils.Equipos;
import com.example.repasofinal.utils.Ligas;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnLigaListener, AdaptadorEquipos.OnEquipoListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

        fragmentTransaction.replace(R.id.sitio_fragments,new FragmentInicio(),"inicio");
        fragmentTransaction.addToBackStack("inicio");
        fragmentTransaction.commit();

    }


    @Override
    public void onLigaSelecionada(String nombresLiga) {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if(findViewById(R.id.sitio_equipos)!=null){
            fragmentTransaction.replace(R.id.sitio_equipos,FragmentEquipo.newInstance(nombresLiga));
        }else{
            fragmentTransaction.replace(R.id.sitio_fragments,FragmentEquipo.newInstance(nombresLiga));
        }

        fragmentTransaction.commit();



    }

    @Override
    public void onEquipoSelected(Equipos equipo) {

        fragmentManager = getSupportFragmentManager();

        DialogoEquipo dialogoEquipo = DialogoEquipo.newInstance(equipo);
        dialogoEquipo.show(fragmentManager,"dialogoEquipo");




    }
}
