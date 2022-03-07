package com.example.repasofinaltres.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.example.repasofinaltres.R;
import com.example.repasofinaltres.utils.Equipo;

public class DialogoDetalle extends DialogFragment {

    private TextView pais;
    private ImageView estadio,equipacion;
    private Equipo equipo;
    private View view;
    private Context context;

    public static DialogoDetalle newInstance(Equipo equipo) {

        Bundle args = new Bundle();

        DialogoDetalle fd = new DialogoDetalle();
        args.putSerializable("equipo",equipo);
        fd.setArguments(args);
        return fd;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

        if(this.getArguments()!=null){
            equipo = (Equipo) this.getArguments().getSerializable("equipo");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        pais = view.findViewById(R.id.pais_equipo);
        estadio = view.findViewById(R.id.estadio_equipo);
        equipacion = view.findViewById(R.id.equipacion_equipo);

        pais.setText(equipo.getPais());
        Glide.with(context).load(equipo.getEstadio()).into(estadio);
        Glide.with(context).load(equipo.getEquipacion()).into(equipacion);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_detalle,null,false);
        builder.setView(view);

        return builder.create();
    }
}
