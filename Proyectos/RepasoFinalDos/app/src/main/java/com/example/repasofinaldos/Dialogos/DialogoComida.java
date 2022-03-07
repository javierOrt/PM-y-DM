package com.example.repasofinaldos.Dialogos;

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
import com.example.repasofinaldos.R;
import com.example.repasofinaldos.utils.Comidas;

public class DialogoComida extends DialogFragment {

    private TextView nombrePLato;
    private ImageView imagenPlato;
    private View view;
    private Context context;
    private Comidas comida;

    public static DialogoComida newInstance(Comidas comidas) {

        Bundle args = new Bundle();

        DialogoComida dc = new DialogoComida();
        args.putSerializable("comida",comidas);
        dc.setArguments(args);
        return dc;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        view = LayoutInflater.from(context).inflate(R.layout.dialogo_comida,null,false);
        builder.setView(view);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if(this.getArguments()!= null) {
            comida = (Comidas) this.getArguments().getSerializable("comida");
        }

    }

    @Override
    public void onStart() {
        super.onStart();

        nombrePLato = view.findViewById(R.id.nombre_plato);
        imagenPlato = view.findViewById(R.id.imagen_plato);

        Glide.with(context).load(comida.getImagenComida()).into(imagenPlato);
        nombrePLato.setText(comida.getNombreComida());

    }
}
