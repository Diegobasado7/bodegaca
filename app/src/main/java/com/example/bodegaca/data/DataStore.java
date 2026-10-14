package com.example.bodegaca.data;

import com.example.bodegaca.model.Categoria;
import com.example.bodegaca.model.Producto;
import com.example.bodegaca.model.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static List<Categoria> categorias = new ArrayList<>();
    private static List<Proveedor> proveedores = new ArrayList<>();
    private static List<Producto> productos = new ArrayList<>();
    private static int contadorCategoriaId = 1;

    static {
        // Precarga de categorías para Comercializadora Ángel
        categorias.add(new Categoria(contadorCategoriaId++, "Frutos Secos", true));
        categorias.add(new Categoria(contadorCategoriaId++, "Quesos", true));
        categorias.add(new Categoria(contadorCategoriaId++, "Semillas", true));
        categorias.add(new Categoria(contadorCategoriaId++, "Otros (Lácteos y Vinos)", true));

        // Precarga de proveedores
        proveedores.add(new Proveedor(1, "Agrícola del Valle", "+56911112222", "Frutos Secos y Semillas"));
        proveedores.add(new Proveedor(2, "Quesos Artesanales Sur", "+56933334444", "Quesos y Leche"));
        proveedores.add(new Proveedor(3, "Viña y Lácteos Cordillera", "+56955556666", "Leche de cabra, vaca y vino"));

        // Precarga de productos
        productos.add(new Producto(1, "Almendras 1kg", categorias.get(0), proveedores.get(0), 50, 8500.0));
        productos.add(new Producto(2, "Queso de Cabra Madurado", categorias.get(1), proveedores.get(1), 20, 6000.0));
    }

    public static List<Categoria> getCategorias() {
        return categorias;
    }

    public static List<Categoria> getCategoriasActivas() {
        List<Categoria> activas = new ArrayList<>();
        for (Categoria c : categorias) {
            if (c.isActiva()) {
                activas.add(c);
            }
        }
        return activas;
    }

    public static boolean agregarCategoria(String nombre) {
        // Evitar nombres duplicados (ignorando mayúsculas/minúsculas)
        for (Categoria c : categorias) {
            if (c.getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                return false;
            }
        }
        categorias.add(new Categoria(contadorCategoriaId++, nombre.trim(), true));
        return true;
    }

    public static List<Proveedor> getProveedores() {
        return proveedores;
    }

    public static void agregarProveedor(Proveedor p) {
        proveedores.add(p);
    }

    public static List<Producto> getProductos() {
        return productos;
    }

    public static void agregarProducto(Producto p) {
        productos.add(p);
    }
}