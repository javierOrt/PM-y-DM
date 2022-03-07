package com.example.repasofinaltres.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.repasofinaltres.utils.Equipo;

public class DialogoConfirmacion extends DialogFragment {

    private Context context;
    private Equipo equipo;
    private OnDialogoListener listener;

    public static DialogoConfirmacion newInstance(Equipo equipo) {

        Bundle args = new Bundle();

        DialogoConfirmacion fragment = new DialogoConfirmacion();
        args.putSerializable("equipo",equipo);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        listener = (OnDialogoListener) context;
        equipo = (Equipo) this.getArguments().getSerializable("equipo");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage("¿Esta seguro quiere elegir al "+equipo.getNombre()+ " ?");
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                listener.onDialogoSelected(equipo);
            }
        });

        builder.setNegativeButton("NO ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        return builder.create();
    }

    public interface OnDialogoListener{
        void onDialogoSelected(Equipo equipo);
    }
}


