package com.example.bodegaca.model;

import java.io.Serializable;

public class Proveedor implements Serializable {
    private int id;
    private String nombre;
    private String telefono;
    private String productoOfrecido;

    public Proveedor(int id, String nombre, String telefono, String productoOfrecido) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.productoOfrecido = productoOfrecido;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getProductoOfrecido() { return productoOfrecido; }

    @Override
    public String toString() {
        return nombre + " (" + productoOfrecido + ")";
    }
}