package com.example.repasofinaldos.Fragments;

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
import com.example.repasofinaldos.Adapters.AdaptadorCategorias;
import com.example.repasofinaldos.Adapters.AdaptadorComidas;
import com.example.repasofinaldos.R;
import com.example.repasofinaldos.utils.Categorias;
import com.example.repasofinaldos.utils.Comidas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentComidas extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private AdaptadorComidas adaptadorComidas;
    private String nombreCategoria;


    public static FragmentComidas newInstance(String nombreCategorias) {
        FragmentComidas fc = new FragmentComidas();
        Bundle args = new Bundle();


        args.putString("categoria",nombreCategorias);
        fc.setArguments(args);
        return fc;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


        if(this.getArguments()!= null){
            this.nombreCategoria =  this.getArguments().getString("categoria");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_categorias,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        recyclerView = view.findViewById(R.id.recycler);
        adaptadorComidas = new AdaptadorComidas(getContext());
        recyclerView.setAdapter(adaptadorComidas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        String url = "https://www.themealdb.com/api/json/v1/1/filter.php?c="+nombreCategoria;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray arrayComidas = response.getJSONArray("meals");

                    for (int i = 0; i < arrayComidas.length(); i++) {
                        JSONObject comida = arrayComidas.getJSONObject(i);
                        String nombreComida = comida.getString("strMeal");
                        String imagenComida = comida.getString("strMealThumb");
                        Comidas comida1 = new Comidas(nombreComida,imagenComida);
                        adaptadorComidas.agregarComidas(comida1);


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


    }




}
