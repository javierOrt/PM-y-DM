package com.example.repasofinaldos.Fragments;

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
import com.example.repasofinaldos.R;
import com.example.repasofinaldos.utils.Categorias;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentCategorias extends Fragment implements AdaptadorCategorias.OnCategoriaListener {

    private RecyclerView recyclerView;
    private View view;
    private AdaptadorCategorias adaptadorCategorias;

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
        adaptadorCategorias = new AdaptadorCategorias(getContext());
        recyclerView.setAdapter(adaptadorCategorias);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        String url = "https://www.themealdb.com/api/json/v1/1/categories.php";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray arrayCategorias = response.getJSONArray("categories");

                    for (int i = 0; i < arrayCategorias.length(); i++) {
                        JSONObject categoria = arrayCategorias.getJSONObject(i);
                        String nombreCategoria = categoria.getString("strCategory");
                        String imagenCategoria = categoria.getString("strCategoryThumb");
                        Categorias categoria1 = new Categorias(nombreCategoria,imagenCategoria);
                        adaptadorCategorias.agregarCategoria(categoria1);


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

    @Override
    public void onCategoriaSelecionada(String nombresCategorias) {

    }
}
