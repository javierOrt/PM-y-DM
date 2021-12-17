package com.examen.javierortizfeliz3.utils;

public class ListaSeleccionada {

    private String nombre, categoria;
    private int imagen;
    private String tipo;

    public ListaSeleccionada(String nombre, String categoria, int imagen, String tipo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.imagen = imagen;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
