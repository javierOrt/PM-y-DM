package com.example.repasofinal.utils;

import java.io.Serializable;

public class Ligas implements Serializable {
    private String nombre;

    public Ligas(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
