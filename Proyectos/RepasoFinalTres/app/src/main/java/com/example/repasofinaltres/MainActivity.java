package com.example.repasofinaltres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.repasofinaltres.Adapters.AdapterEquipo;
import com.example.repasofinaltres.Adapters.AdapterLigas;
import com.example.repasofinaltres.Dialogos.DialogoConfirmacion;
import com.example.repasofinaltres.Dialogos.DialogoDetalle;
import com.example.repasofinaltres.Fragments.FragmentEquipo;
import com.example.repasofinaltres.Fragments.FragmentLigas;
import com.example.repasofinaltres.utils.Equipo;

public class MainActivity extends AppCompatActivity implements AdapterLigas.OnLigaListener, AdapterEquipo.OnEquipoListener, DialogoConfirmacion.OnDialogoListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sitio_fragment,new FragmentLigas(),"inicio");



        fragmentTransaction.replace(R.id.sitio_fragment,new FragmentLigas(),"inicio");
        fragmentTransaction.addToBackStack("inicio");
        fragmentTransaction.commit();
    }

    @Override
    public void onLigaSelected(String nombreLiga) {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if (findViewById(R.id.sitio_detalle)!=null){
            fragmentTransaction.replace(R.id.sitio_detalle, FragmentEquipo.newInstance(nombreLiga),"ligas");
        }else{
            fragmentTransaction.replace(R.id.sitio_fragment, FragmentEquipo.newInstance(nombreLiga),"ligas");

        }

        fragmentTransaction.addToBackStack("inicio");
        fragmentTransaction.commit();


    }

    @Override
    public void onEquipoSelecionado(Equipo equipo) {

        fragmentManager = getSupportFragmentManager();
        DialogoConfirmacion dialogoConfirmacion = DialogoConfirmacion.newInstance(equipo);
        dialogoConfirmacion.show(fragmentManager,"dialogoConfirmacion");

    }

    @Override
    public void onDialogoSelected(Equipo equipo) {

        fragmentManager = getSupportFragmentManager();
        DialogoDetalle dialogoDetalle = DialogoDetalle.newInstance(equipo);
        dialogoDetalle.show(fragmentManager,"dialogoDetalle");
    }
}