package com.example.bodegaca.model;

import java.io.Serializable;

public class Producto implements Serializable {
    private int id;
    private String nombre;
    private Categoria categoria;
    private Proveedor proveedor;
    private int stock;
    private double precio;

    public Producto(int id, String nombre, Categoria categoria, Proveedor proveedor, int stock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.proveedor = proveedor;
        this.stock = stock;
        this.precio = precio;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public Categoria getCategoria() { return categoria; }
    public Proveedor getProveedor() { return proveedor; }
    public int getStock() { return stock; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return nombre + " | Stock: " + stock + " | Cat: " + categoria.getNombre() + " | Prov: " + proveedor.getNombre();
    }
}