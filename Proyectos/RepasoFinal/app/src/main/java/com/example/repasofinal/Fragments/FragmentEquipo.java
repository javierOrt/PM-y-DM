package com.example.repasofinal.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.repasofinal.Adapters.AdaptadorEquipos;
import com.example.repasofinal.Adapters.AdaptadorRecycler;
import com.example.repasofinal.R;
import com.example.repasofinal.utils.Equipos;
import com.example.repasofinal.utils.Ligas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentEquipo extends Fragment {


    private View view;

    private String nombreLigue;
    private AdaptadorEquipos adaptadorEquipos;
    private RecyclerView recyclerView;

    public static FragmentEquipo newInstance(String nombre){
        FragmentEquipo fragmentEquipo = new FragmentEquipo();
        Bundle bundle = new Bundle();
        bundle.putString("nombreLiga",nombre);

        fragmentEquipo.setArguments(bundle);

        return  fragmentEquipo;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(this.getArguments()!= null){
            this.nombreLigue =  this.getArguments().getString("nombreLiga");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentinicio,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        //equiposArrayList = new ArrayList<>();

        nombreLigue.replace(" ","%20");
        String url = "https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?l="+nombreLigue;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray arrayEquipos = response.getJSONArray("teams");

                    for (int i = 0; i < arrayEquipos.length() ; i++) {
                        JSONObject equipo = arrayEquipos.getJSONObject(i);
                        String nombre = equipo.getString("strTeam");
                        String id = equipo.getString("idTeam");
                        String anio = equipo.getString("intFormedYear");
                        String escudo = equipo.getString("strTeamBadge");
                        String estadio = equipo.getString("strStadium");
                        Equipos equipo1 = new Equipos(nombre,estadio,anio,escudo);
                        adaptadorEquipos.agregarEquipo(equipo1);
                        //Log.v("Resultado",response.toString());


                        //Log.v("Resultado",listaEquipos.toString());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(getContext()).add(jsonObjectRequest);

        recyclerView = view.findViewById(R.id.recycler_inicio);
        adaptadorEquipos = new AdaptadorEquipos(getContext());
        recyclerView.setAdapter(adaptadorEquipos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));




        //nombre.setText(equipo.getNombre());

    }




}
