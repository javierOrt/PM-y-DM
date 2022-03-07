package com.example.proyectojson.utils;

import java.io.Serializable;

public class Equipo implements Serializable {

    private String id,nombre,escudo,estadio,anio;

    public Equipo(String id, String nombre, String escudo, String estadio, String anio) {
        this.id = id;
        this.nombre = nombre;
        this.escudo = escudo;
        this.estadio = estadio;
        this.anio = anio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
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
}
