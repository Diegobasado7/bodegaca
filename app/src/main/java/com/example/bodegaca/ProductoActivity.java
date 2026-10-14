package com.example.bodegaca;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bodegaca.data.DataStore;
import com.example.bodegaca.model.Categoria;
import com.example.bodegaca.model.Producto;
import com.example.bodegaca.model.Proveedor;

import java.util.List;

public class ProductoActivity extends AppCompatActivity {
    private EditText etNombre, etStock, etPrecio;
    private Spinner spinnerCategorias, spinnerProveedores;
    private ListView lvProductos;
    private ArrayAdapter<Producto> adapterProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        etNombre = findViewById(R.id.etNombreProducto);
        etStock = findViewById(R.id.etStockProducto);
        etPrecio = findViewById(R.id.etPrecioProducto);
        spinnerCategorias = findViewById(R.id.spinnerCategorias);
        spinnerProveedores = findViewById(R.id.spinnerProveedores);
        Button btnGuardar = findViewById(R.id.btnGuardarProducto);
        lvProductos = findViewById(R.id.lvProductos);

        cargarSpinners();
        actualizarListaProductos();

        btnGuardar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            String stockStr = etStock.getText().toString();
            String precioStr = etPrecio.getText().toString();

            if (nombre.isEmpty() || stockStr.isEmpty() || precioStr.isEmpty()) {
                Toast.makeText(this, "Complete todos los campos del producto", Toast.LENGTH_SHORT).show();
                return;
            }

            if (spinnerCategorias.getSelectedItem() == null || spinnerProveedores.getSelectedItem() == null) {
                Toast.makeText(this, "Debe existir al menos una categoría activa y un proveedor", Toast.LENGTH_SHORT).show();
                return;
            }

            Categoria categoriaSeleccionada = (Categoria) spinnerCategorias.getSelectedItem();
            Proveedor proveedorSeleccionado = (Proveedor) spinnerProveedores.getSelectedItem();
            int stock = Integer.parseInt(stockStr);
            double precio = Double.parseDouble(precioStr);
            int id = DataStore.getProductos().size() + 1;

            Producto nuevoProducto = new Producto(id, nombre, categoriaSeleccionada, proveedorSeleccionado, stock, precio);
            DataStore.agregarProducto(nuevoProducto);

            Toast.makeText(this, "Producto registrado correctamente", Toast.LENGTH_SHORT).show();
            etNombre.setText("");
            etStock.setText("");
            etPrecio.setText("");
            actualizarListaProductos();
        });
    }

    private void cargarSpinners() {
        // Solo carga categorías activas en el Spinner
        List<Categoria> categoriasActivas = DataStore.getCategoriasActivas();
        ArrayAdapter<Categoria> adapterCat = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categoriasActivas);
        spinnerCategorias.setAdapter(adapterCat);

        List<Proveedor> proveedores = DataStore.getProveedores();
        ArrayAdapter<Proveedor> adapterProv = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, proveedores);
        spinnerProveedores.setAdapter(adapterProv);
    }

    private void actualizarListaProductos() {
        adapterProducto = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DataStore.getProductos());
        lvProductos.setAdapter(adapterProducto);
    }
}