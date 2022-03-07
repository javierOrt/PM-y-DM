package com.example.repasofinaldos.utils;

import java.io.Serializable;

public class Comidas implements Serializable {

    private String nombreComida,imagenComida;

    public Comidas(String nombreComida, String imagenComida) {
        this.nombreComida = nombreComida;
        this.imagenComida = imagenComida;
    }

    public String getNombreComida() {
        return nombreComida;
    }

    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }

    public String getImagenComida() {
        return imagenComida;
    }

    public void setImagenComida(String imagenComida) {
        this.imagenComida = imagenComida;
    }
}
