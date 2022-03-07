package com.example.repasofinalcuatro.Fragments;

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
import com.example.repasofinalcuatro.Adaptadores.AdaptadorComida;
import com.example.repasofinalcuatro.R;
import com.example.repasofinalcuatro.utils.Categorias;
import com.example.repasofinalcuatro.utils.Comida;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentComida extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private AdaptadorComida adaptadorComida;
    private String nombreCateogoria;

    public static FragmentComida newInstance(String nombreCateogoria) {

        Bundle args = new Bundle();

        FragmentComida fragment = new FragmentComida();
        args.putString("categoria",nombreCateogoria);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (this.getArguments()!=null){
            this.nombreCateogoria = this.getArguments().getString("categoria"); //CUIDADO
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        recyclerView = view.findViewById(R.id.recycler);
        adaptadorComida = new AdaptadorComida(getContext());
        recyclerView.setAdapter(adaptadorComida);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        String url ="https://www.themealdb.com/api/json/v1/1/filter.php?c="+nombreCateogoria;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray arrayComidas = response.getJSONArray("meals");
                    for (int i = 0; i < arrayComidas.length(); i++) {

                        JSONObject comida= arrayComidas.getJSONObject(i);
                        String nombreComida = comida.getString("strMeal");
                        String imagenComida = comida.getString("strMealThumb");
                        Comida comida1 = new Comida(nombreComida,imagenComida);
                        adaptadorComida.agregarComidas(comida1);

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_inicio,container,false);
        return view;
    }
}
