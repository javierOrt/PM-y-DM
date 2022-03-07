package com.example.repasofinalcuatro.utils;

import java.io.Serializable;

public class Comida implements Serializable {

    private String nombre,imagen;

    public Comida(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}


