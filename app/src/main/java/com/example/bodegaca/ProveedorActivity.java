package com.example.bodegaca;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bodegaca.data.DataStore;
import com.example.bodegaca.model.Proveedor;

public class ProveedorActivity extends AppCompatActivity {
    private EditText etNombre, etTelefono, etProducto;
    private ListView lvProveedores;
    private ArrayAdapter<Proveedor> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedores);

        etNombre = findViewById(R.id.etNombreProveedor);
        etTelefono = findViewById(R.id.etTelefonoProveedor);
        etProducto = findViewById(R.id.etProductoOfrecido);
        Button btnGuardar = findViewById(R.id.btnGuardarProveedor);
        lvProveedores = findViewById(R.id.lvProveedores);

        actualizarLista();

        btnGuardar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            String tel = etTelefono.getText().toString();
            String prod = etProducto.getText().toString();

            if (nombre.isEmpty() || tel.isEmpty() || prod.isEmpty()) {
                Toast.makeText(this, "Complete todos los campos del proveedor", Toast.LENGTH_SHORT).show();
                return;
            }

            int nuevoId = DataStore.getProveedores().size() + 1;
            Proveedor nuevoProveedor = new Proveedor(nuevoId, nombre, tel, prod);
            DataStore.agregarProveedor(nuevoProveedor);

            Toast.makeText(this, "Proveedor registrado", Toast.LENGTH_SHORT).show();
            etNombre.setText("");
            etTelefono.setText("");
            etProducto.setText("");
            actualizarLista();
        });
    }

    private void actualizarLista() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DataStore.getProveedores());
        lvProveedores.setAdapter(adapter);
    }
}