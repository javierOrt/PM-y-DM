package com.example.aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class dadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        getIntent();
    }
}