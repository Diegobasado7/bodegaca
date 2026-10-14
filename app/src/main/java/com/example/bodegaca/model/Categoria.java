package com.example.bodegaca.model;

import java.io.Serializable;

public class Categoria implements Serializable {
    private int idUnico;
    private String nombre;
    private boolean activa;

    public Categoria(int idUnico, String nombre, boolean activa) {
        this.idUnico = idUnico;
        this.nombre = nombre;
        this.activa = activa;
    }

    public int getIdUnico() { return idUnico; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }

    @Override
    public String toString() {
        return idUnico + " - " + nombre;
    }
}