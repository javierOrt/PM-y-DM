package com.example.repasofinaldos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.repasofinaldos.utils.Comidas;

public class DialogoConfirmacion extends DialogFragment {

    private Context context;
    private Comidas comidas;
    private OnDialogoListener listener;

    public static DialogoConfirmacion newInstance(Comidas comidas) {

        Bundle args = new Bundle();

        DialogoConfirmacion dc = new DialogoConfirmacion();
        args.putSerializable("comida",comidas);
        dc.setArguments(args);
        return dc;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        comidas = (Comidas) this.getArguments().getSerializable("comida");
        listener = (OnDialogoListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage("¿ Esta seguro de que el "+comidas.getNombreComida()+" es su plato favorito?");
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                listener.onDialogoSelected(comidas);
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
        void onDialogoSelected(Comidas comidas);
    }
}
