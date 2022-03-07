package com.example.repasofinal.utils;

import java.io.Serializable;

public class Equipos implements Serializable {

    private String nombre,estadio,anio, imagen;

    public Equipos(String nombre, String estadio, String anio, String imagen) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.anio = anio;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
