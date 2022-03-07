package com.example.proyectojson.Dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoConfirmacion extends DialogFragment {

    private Context context ;
    private String nombre;

    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);
        this.context = context;
        nombre = getArguments().getString("nombre");
    }

    public static DialogoConfirmacion newInstance(String nombre){
        DialogoConfirmacion d = new DialogoConfirmacion();
        Bundle bundle = new Bundle();
        bundle.putString("nombre",nombre);
        d.setArguments(bundle);
        //despues de retornar se ejecuta el ciclo de vida completo
        return d;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("Dialogo confirmacion");
        builder.setMessage("¿ Estas seguro que el" +nombre+ "es tu equipo favorito ?");
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        builder.setNeutralButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return builder.create();
    }

    public interface OnDialogoConfirm{
        void onDialogoSelected();
    }




}
