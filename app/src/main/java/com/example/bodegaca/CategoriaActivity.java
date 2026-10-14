package com.example.bodegaca;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bodegaca.data.DataStore;
import com.example.bodegaca.model.Categoria;
import java.util.List;

public class CategoriaActivity extends AppCompatActivity {
    private EditText etNombreCategoria;
    private ListView lvCategorias;
    private ArrayAdapter<Categoria> adapter;
    private List<Categoria> listaCategoriasActivas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        etNombreCategoria = findViewById(R.id.etNombreCategoria);
        Button btnGuardar = findViewById(R.id.btnGuardarCategoria);
        lvCategorias = findViewById(R.id.lvCategorias);

        actualizarLista();

        btnGuardar.setOnClickListener(v -> {
            String nombre = etNombreCategoria.getText().toString();
            if (nombre.isEmpty()) {
                Toast.makeText(this, "Ingrese un nombre para la categoría", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean agregado = DataStore.agregarCategoria(nombre);
            if (agregado) {
                Toast.makeText(this, "Categoría creada con éxito", Toast.LENGTH_SHORT).show();
                etNombreCategoria.setText("");
                actualizarLista();
            } else {
                Toast.makeText(this, "Error: Ya existe una categoría con ese nombre", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void actualizarLista() {
        // Muestra estrictamente las categorías activas
        listaCategoriasActivas = DataStore.getCategoriasActivas();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCategoriasActivas);
        lvCategorias.setAdapter(adapter);
    }
}