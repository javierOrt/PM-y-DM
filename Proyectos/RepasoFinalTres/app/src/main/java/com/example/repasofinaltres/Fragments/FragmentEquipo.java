package com.example.repasofinaltres.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.repasofinaltres.Adapters.AdapterEquipo;
import com.example.repasofinaltres.R;
import com.example.repasofinaltres.utils.Equipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentEquipo extends Fragment {

    private RecyclerView recyclerView;
    private AdapterEquipo adapterEquipo;
    private View view;
    String nombreEquipo;

    public static FragmentEquipo newInstance(String equipo) {
        FragmentEquipo fe = new FragmentEquipo();
        Bundle args = new Bundle();

        args.putSerializable("equipo",equipo);
        fe.setArguments(args);
        return fe;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(this.getArguments()!= null){
            this.nombreEquipo =  this.getArguments().getString("equipo");
        }

    }

    @Override
    public void onStart() {
        super.onStart();

        nombreEquipo.replace(" ","%20");
        String url = "https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?l="+nombreEquipo;

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
                        String estadio = equipo.getString("strStadiumThumb");
                        String pais = equipo.getString("strCountry");
                        String equipacion = equipo.getString("strTeamJersey");
                        Equipo equipo1 = new Equipo(nombre,estadio,pais,escudo,equipacion);

                        adapterEquipo.agregarEquipo(equipo1);
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

        recyclerView = view.findViewById(R.id.recycler);
        adapterEquipo = new AdapterEquipo(getContext());
        recyclerView.setAdapter(adapterEquipo);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_ligas,container,false);
        return view;
    }
}
