package com.example.proyectojson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectojson.Adaptadores.AdaptadorRecycler;
import com.example.proyectojson.Dialogos.DialogoConfirmacion;
import com.example.proyectojson.utils.Equipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnEquipoListener, DialogoConfirmacion.OnDialogoConfirm {


    private RecyclerView recyclerView;
    private AdaptadorRecycler adaptadorRecycler;
    private Equipo equipo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler);
        adaptadorRecycler = new AdaptadorRecycler(MainActivity.this);

        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));




        String url  = "https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?s=Soccer&c=Spain";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v("Resultado","proceso peticion");
                try {
                    JSONArray arrayEquipòs = response.getJSONArray("teams");


                    for (int i = 0; i < arrayEquipòs.length() ; i++) {
                        JSONObject equipo = arrayEquipòs.getJSONObject(i);
                        String nombre = equipo.getString("strTeam");
                        String id = equipo.getString("idTeam");
                        String anio = equipo.getString("intFormedYear");
                        String escudo = equipo.getString("strTeamBadge");
                        String estadio = equipo.getString("strStadium");
                        Equipo equipo1 = new Equipo(id,nombre,escudo,estadio,anio);
                        adaptadorRecycler.agregarEquipo(equipo1);
                        Log.v("Resultado",response.toString());


                        //Log.v("Resultado",listaEquipos.toString());
                    }
                    Log.v("Resultado","response.toString()");





                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(getApplicationContext()).add(jsonObjectRequest);
    }

    @Override
    public void onEquipoSelected(Equipo equipo) {

        this.equipo = equipo;

        DialogoConfirmacion dialogoConfirmacion = DialogoConfirmacion.newInstance(equipo.getNombre());
        dialogoConfirmacion.show(getSupportFragmentManager(),"confirm");


    }

    @Override
    public void onDialogoSelected() {

        Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
        intent.putExtra("equipo",equipo);
        startActivity(intent);
    }
}