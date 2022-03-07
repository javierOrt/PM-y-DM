package com.example.repasofinaltres.utils;

import java.io.Serializable;

public class Equipo implements Serializable {

    private String nombre,estadio,pais,escudo,equipacion;

    public Equipo(String nombre, String estadio, String pais, String escudo, String equipacion) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.pais = pais;
        this.escudo = escudo;
        this.equipacion = equipacion;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public String getEquipacion() {
        return equipacion;
    }

    public void setEquipacion(String equipacion) {
        this.equipacion = equipacion;
    }
}
