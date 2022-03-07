package com.example.repasofinal.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.example.repasofinal.R;
import com.example.repasofinal.utils.Equipos;

public class DialogoEquipo extends DialogFragment {

    private TextView nombreEquipo;
    private ImageView imagenEquipo;
    private Equipos equipo;
    private Context context;
    private View view;

    public static DialogoEquipo newInstance(Equipos equipo) {

        Bundle args = new Bundle();

        DialogoEquipo fragmentEquipo = new DialogoEquipo();
        args.putSerializable("equipo",equipo);
        fragmentEquipo.setArguments(args);
        return fragmentEquipo;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

        if(this.getArguments()!= null){
            this.equipo = (Equipos) this.getArguments().getSerializable("equipo");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        nombreEquipo = view.findViewById(R.id.nombre_equipo);
        imagenEquipo = view.findViewById(R.id.imagen_equipo);

        Glide.with(context).load(equipo.getImagen()).into(imagenEquipo);
        nombreEquipo.setText(equipo.getNombre());
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_equipo,null,false);
        builder.setView(view);
        return builder.create();
    }
}
