package com.pmydmexamen.examen;

public class Jugador {

    private int imagen;
    private String nombre, habilidad, procedencia;

    public Jugador(int imagen, String nombre, String habilidad, String procedencia) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.habilidad = habilidad;
        this.procedencia = procedencia;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }
}
