package com.example.repasofinaldos.utils;

import java.io.Serializable;

public class Categorias implements Serializable {

    private String categoria,imagenCategoria;

    public Categorias(String categoria, String imagenCategoria) {
        this.categoria = categoria;
        this.imagenCategoria = imagenCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagenCategoria() {
        return imagenCategoria;
    }

    public void setImagenCategoria(String imagenCategoria) {
        this.imagenCategoria = imagenCategoria;
    }
}
