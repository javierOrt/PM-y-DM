package com.example.javierortizfeliz2.utils;

public class Restaurante {

    private String nombre;
    private String direccion;
    private int valoracion;
    private String tipo;
    private int telefono;

    public Restaurante(String nombre, String direccion, int valoracion, String tipo, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.valoracion = valoracion;
        this.tipo = tipo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
