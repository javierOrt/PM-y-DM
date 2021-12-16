package com.example.javierortizfeliz2.utils;

public class Restaurante {
    private String nombre,localidad;
    private int puntuacion;
    private String tipo_comida;
    private int telefono;

    public Restaurante(String nombre, String localidad, int puntuacion, String tipo_comida, int telefono) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.puntuacion = puntuacion;
        this.tipo_comida = tipo_comida;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getTipo_comida() {
        return tipo_comida;
    }

    public void setTipo_comida(String tipo_comida) {
        this.tipo_comida = tipo_comida;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
