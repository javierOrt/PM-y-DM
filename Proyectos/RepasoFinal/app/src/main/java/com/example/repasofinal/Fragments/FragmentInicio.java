package com.example.repasofinal.Fragments;

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
import com.example.repasofinal.Adapters.AdaptadorRecycler;
import com.example.repasofinal.R;
import com.example.repasofinal.utils.Ligas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentInicio extends Fragment implements AdaptadorRecycler.OnLigaListener {

    //private ArrayList<Ligas> ligasArrayList;
    private RecyclerView recyclerView;
    private View view;
    private AdaptadorRecycler adaptadorRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentinicio,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        //ligasArrayList = new ArrayList<>();

        String url = "https://www.thesportsdb.com/api/v1/json/2/all_leagues.php";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray arrayLigas = response.getJSONArray("leagues");

                    for (int i = 0; i < arrayLigas.length(); i++) {
                        JSONObject liga = arrayLigas.getJSONObject(i);
                        String nombreLiga = liga.getString("strLeague");
                        Ligas liga1 = new Ligas(nombreLiga);
                        adaptadorRecycler.agregarLiga(liga1);


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

        adaptadorRecycler = new AdaptadorRecycler(getContext());
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void onLigaSelecionada(String nombresLiga) {



    }
}
